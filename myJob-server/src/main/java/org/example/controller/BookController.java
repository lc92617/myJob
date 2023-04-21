package org.example.controller;

import com.westsecu.inf.base.copier.ObjectCopierFactory;
import com.westsecu.inf.base.model.Pager;
import com.westsecu.inf.base.model.api.response.PageResponse;
import com.westsecu.inf.base.model.api.response.Response;
import com.westsecu.inf.base.model.service.result.PageResult;
import com.westsecu.inf.base.model.service.result.Result;
import org.example.common.constant.AppConstants;
import org.example.domain.book.entity.Book;
import org.example.sdk.book.BookFeignClient;
import org.example.sdk.book.model.BookDTO;
import org.example.sdk.book.request.CreateBookRequest;
import org.example.sdk.book.request.DeleteBookRequest;
import org.example.sdk.book.request.GetBookRequest;
import org.example.sdk.book.request.QueryBookRequest;
import org.example.sdk.book.request.SearchBookRequest;
import org.example.sdk.book.request.UpdateBookRequest;
import org.example.service.BookService;
import org.example.service.param.ListBookParam;
import org.example.service.param.RemoveBookParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/feign/book")
public class BookController implements BookFeignClient {

    @Autowired
    private BookService bookService;
    @Autowired
    private ObjectCopierFactory copierFactory;

    @Override
    public Response<BookDTO> create(CreateBookRequest request) {
        // 参数处理
        Book param = copierFactory.to(request, Book.class);
        // 业务逻辑处理
        Result<Book> ret = bookService.save(param);
        // 响应处理
        BookDTO data = copierFactory.to(ret.getData(), BookDTO.class);
        return Response.of(ret.getCode(), ret.getMessage(), data);
    }

    @Override
    public Response delete(DeleteBookRequest request) {
        // 参数处理
        RemoveBookParam param = copierFactory.to(request, RemoveBookParam.class);
        // 业务逻辑处理
        Result<Boolean> ret = bookService.remove(param);
        // 响应处理
        return Response.of(ret.getCode(), ret.getMessage(), ret.getData());
    }

    @Override
    public Response update(UpdateBookRequest request) {
        // 参数处理
        Book param = copierFactory.to(request, Book.class);
        // 业务逻辑处理
        Result<Boolean> ret = bookService.modify(param);
        // 响应处理
        return Response.of(ret.getCode(), ret.getMessage(), ret.getData());
    }

    @Override
    public Response<BookDTO> get(GetBookRequest request) {
        // 参数处理
        // 业务逻辑处理
        Result<Book> ret = bookService.get(request.getId());
        // 响应处理
        BookDTO data = copierFactory.to(ret.getData(), BookDTO.class);
        return Response.of(ret.getCode(), ret.getMessage(), data);
    }

    @Override
    public PageResponse<BookDTO> query(QueryBookRequest request) {
        // 参数处理
        if (null == request.getPager()) {
            request.setPager(Pager.builder().pageNum(AppConstants.DEFAULT_PAGE_NUM).pageSize(AppConstants.DEFAULT_PAGE_SIZE).build());
        }
        ListBookParam param = copierFactory.to(request, ListBookParam.class);
        // 业务逻辑处理
        PageResult<Book> ret = bookService.list(param);
        // 响应处理
        List<BookDTO> data = copierFactory.toList(ret.getData(), BookDTO.class);
        return PageResponse.of(ret.getCode(), ret.getMessage(), data, ret.getPager());
    }

    @Override
    public PageResponse<BookDTO> search(SearchBookRequest request) {
        // 参数处理
        // 业务逻辑处理
        // 响应处理
        return null;
    }
}
