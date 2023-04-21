package org.example.sdk.book;

import com.westsecu.inf.base.model.api.response.PageResponse;
import com.westsecu.inf.base.model.api.response.Response;
import org.example.sdk.book.model.BookDTO;
import org.example.sdk.book.request.CreateBookRequest;
import org.example.sdk.book.request.DeleteBookRequest;
import org.example.sdk.book.request.GetBookRequest;
import org.example.sdk.book.request.QueryBookRequest;
import org.example.sdk.book.request.SearchBookRequest;
import org.example.sdk.book.request.UpdateBookRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 图书Book的RPC服务接口
 * <p>
 * 1、提供Book的查询能力
 * 2、提供Book的管理能力
 * </p>
 *
 * @version 1.0
 */
@FeignClient(name = "org.example", contextId = "bookFeignClient", path = "/feign/book")
public interface BookFeignClient {

    /**
     * 创建图书信息
     *
     * @param request 请求
     * @return 响应
     */
    @PostMapping("/create")
    Response<BookDTO> create(@RequestBody CreateBookRequest request);

    /**
     * 删除图书信息
     *
     * @param request 请求
     * @return 响应
     */
    @PostMapping("/delete")
    Response delete(@RequestBody DeleteBookRequest request);

    /**
     * 更新图书信息
     *
     * @param request 请求
     * @return 响应
     */
    @PostMapping("/update")
    Response update(@RequestBody UpdateBookRequest request);

    /**
     * 获取图书信息
     *
     * @param request 请求
     * @return 响应
     */
    @PostMapping("/get")
    Response<BookDTO> get(@RequestBody GetBookRequest request);

    /**
     * 查询图书信息
     *
     * @param request 请求
     * @return 响应
     */
    @PostMapping("/query")
    PageResponse<BookDTO> query(@RequestBody QueryBookRequest request);

    /**
     * 检索图书信息
     *
     * @param request 请求
     * @return 响应
     */
    @PostMapping("/search")
    PageResponse<BookDTO> search(@RequestBody SearchBookRequest request);
}
