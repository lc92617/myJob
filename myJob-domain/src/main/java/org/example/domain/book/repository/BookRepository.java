package org.example.domain.book.repository;

import com.westsecu.inf.base.model.PagerInfo;
import org.example.domain.book.entity.Book;
import org.example.domain.book.repository.criteria.GetBookCriteria;
import org.example.domain.book.repository.criteria.ListBookCriteria;
import org.example.domain.book.repository.criteria.RemoveBookCriteria;

/**
 * 图书Book的仓储接口定义，主要封装领域内的存储层的增、删、改、查操作
 * 1、支持从多种数据存储中间件中获取领域数据，eg：Mysql、ElasticSearch ...
 * 2、封装领域的事务性操作
 */
public interface BookRepository {

    /**
     * 保存图书信息
     *
     * @param book 图书信息
     * @return 是否成功
     */
    boolean save(Book book);

    /**
     * 查询图书信息
     *
     * @param criteria 查询条件
     * @return 图书信息
     */
    Book get(GetBookCriteria criteria);

    /**
     * 分页查询图书信息
     *
     * @param criteria 查询条件
     * @param pageNum  分页页号
     * @param pageSize 分页个数
     * @return 图书信息列表
     */
    PagerInfo<Book> list(ListBookCriteria criteria, int pageNum, int pageSize);

    /**
     * 删除图书信息
     *
     * @param criteria 删除条件
     * @return 是否成功
     */
    boolean remove(RemoveBookCriteria criteria);

    /**
     * 修改图书信息
     *
     * @param book 图书信息
     * @return 是否成功
     */
    boolean modify(Book book);
}
