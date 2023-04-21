package org.example.repository.book;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.westsecu.inf.base.copier.ObjectCopierFactory;
import com.westsecu.inf.base.model.PagerInfo;
import org.example.domain.book.entity.Book;
import org.example.domain.book.repository.BookRepository;
import org.example.domain.book.repository.criteria.GetBookCriteria;
import org.example.domain.book.repository.criteria.ListBookCriteria;
import org.example.domain.book.repository.criteria.RemoveBookCriteria;
import org.example.repository.book.mapper.BookMapper;
import org.example.repository.book.model.BookDO;
import org.example.repository.book.model.BookDOExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 仓储实现，主要封装领域内的存储层的增、删、改、查操作
 * 1、支持从多种数据存储中间件中获取领域数据，eg：Mysql、ElasticSearch ...
 * 2、封装领域的事务性操作
 */
@Component
public class BookRepositoryImpl implements BookRepository {

    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private ObjectCopierFactory copierFactory;

    @Transactional
    @Override
    public boolean save(Book book) {
        BookDO record = copierFactory.to(book, BookDO.class);
        record.setCreateTime(new Date());
        record.setUpdateTime(record.getCreateTime());
        int rows = bookMapper.insertSelective(record);
        // 回填领域数据
        book.setId(record.getId());
        book.setCreateTime(record.getCreateTime());
        book.setUpdateTime(record.getUpdateTime());
        return rows == 0 ? Boolean.FALSE : Boolean.TRUE;
    }

    @Override
    public Book get(GetBookCriteria criteria) {
        BookDOExample example = new BookDOExample();
        BookDOExample.Criteria exampleCriteria = example.createCriteria();
        if (criteria.getId() != null) {
            exampleCriteria.andIdEqualTo(criteria.getId());
        }
        List<BookDO> data = bookMapper.selectByExample(example);
        return data == null || data.isEmpty() ? null : copierFactory.to(data.get(0), Book.class);
    }

    @Override
    public PagerInfo<Book> list(ListBookCriteria criteria, int pageNum, int pageSize) {
        BookDOExample example = new BookDOExample();
        BookDOExample.Criteria exampleCriteria = example.createCriteria();
        if (null != criteria.getIdList() && !criteria.getIdList().isEmpty()) {
            exampleCriteria.andIdIn(criteria.getIdList());
        }
        if (null != criteria.getLibraryId()) {
            exampleCriteria.andLibraryIdEqualTo(criteria.getLibraryId());
        }
        PageInfo<BookDO> pageInfo = PageHelper.startPage(pageNum, pageSize)
                .doSelectPageInfo(() -> bookMapper.selectByExample(example));
        List<Book> data = copierFactory.toList(pageInfo.getList(), Book.class);
        return PagerInfo.<Book>builder().pageNum(pageNum).pageSize(pageSize).total(pageInfo.getTotal()).data(data).build();
    }

    @Override
    public boolean remove(RemoveBookCriteria criteria) {
        BookDOExample example = new BookDOExample();
        BookDOExample.Criteria exampleCriteria = example.createCriteria();
        if (criteria.getIdList() != null && !criteria.getIdList().isEmpty()) {
            exampleCriteria.andIdIn(criteria.getIdList());
        }
        bookMapper.deleteByExample(example);
        return Boolean.TRUE;
    }

    @Override
    public boolean modify(Book book) {
        BookDO record = copierFactory.to(book, BookDO.class);
        record.setUpdateTime(new Date());
        bookMapper.updateByPrimaryKeySelective(record);
        return Boolean.TRUE;
    }

}
