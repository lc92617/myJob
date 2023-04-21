package org.example.service;

import com.alibaba.fastjson.JSON;
import com.westsecu.inf.base.model.Pager;
import com.westsecu.inf.base.model.PagerInfo;
import com.westsecu.inf.base.model.service.result.PageResult;
import com.westsecu.inf.base.model.service.result.Result;
import com.westsecu.inf.redis.WedisTemplate;
import org.example.common.errorcode.AppErrorCodeConstant;
import org.example.domain.book.entity.Book;
import org.example.domain.book.repository.BookRepository;
import org.example.domain.book.repository.criteria.GetBookCriteria;
import org.example.domain.book.repository.criteria.ListBookCriteria;
import org.example.domain.book.repository.criteria.RemoveBookCriteria;
import org.example.service.param.ListBookParam;
import org.example.service.param.RemoveBookParam;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.Duration;
import java.util.concurrent.ExecutorService;

@Slf4j
@Component
public class BookService {

    @Autowired
    private BookRepository bookRepository;
    @Resource(name = "createBookTopic")
    private KafkaTemplate kafkaTemplate;
    @Resource(name = "standaloneTemplate")
    private WedisTemplate<String, Object> standaloneTemplate;
    @Resource(name = "clusterTemplate")
    private RedisTemplate<String, Object> clusterTemplate;
    @Resource(name = "syncDataExecutor")
    private ExecutorService executorService;

    public Result<Book> save(Book book) {
        RLock lock = standaloneTemplate.opsForDistributed().getLock(book.getName());
        if (!lock.tryLock()) {
            return Result.failure(AppErrorCodeConstant.CONCURRENT_ERROR);
        }
        try {
            // 保存数据
            boolean ret = bookRepository.save(book);
            // 发送创建消息
            kafkaTemplate.send("createBookTopic", String.valueOf(book.getId()), JSON.toJSONString(book));
            return ret ? Result.success(book) : Result.failure(AppErrorCodeConstant.CREATE_BOOK_FAILURE);
        } finally {
            lock.unlock();
        }
    }

    public Result<Book> get(Long id) {
        Book data = (Book) standaloneTemplate.opsForValue().get(String.valueOf(id));
        if (null != data) {
            return Result.success(data);
        }
        final Book cache = bookRepository.get(GetBookCriteria.builder().id(id).build());
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                // 更新缓存
                standaloneTemplate.opsForValue().set(String.valueOf(id), cache, Duration.ofSeconds(60L));
                clusterTemplate.opsForValue().set(String.valueOf(id), cache, Duration.ofSeconds(60L));
                log.info("[executor]Get Request id:{} data:{}", id, cache);
            }
        });
        return Result.success(cache);
    }

    public PageResult<Book> list(ListBookParam param) {
        PagerInfo<Book> ret = bookRepository.list(ListBookCriteria.builder().idList(param.getIdList()).build(), param.getPager().getPageNum(), param.getPager().getPageSize());
        return PageResult.success(ret.getData(), Pager.builder().pageNum(ret.getPageNum()).pageSize(ret.getPageSize()).total(ret.getTotal()).build());
    }

    public Result<Boolean> remove(RemoveBookParam param) {
        boolean ret = bookRepository.remove(RemoveBookCriteria.builder().idList(param.getIdList()).build());
        return Result.success(ret);
    }

    public Result<Boolean> modify(Book book) {
        boolean ret = bookRepository.modify(book);
        return Result.success(ret);
    }
}
