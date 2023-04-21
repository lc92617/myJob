package org.example.domain.library.repository;

import com.westsecu.inf.base.model.PagerInfo;
import org.example.domain.library.entity.Library;
import org.example.domain.library.repository.criteria.GetLibraryCriteria;
import org.example.domain.library.repository.criteria.ListLibraryCriteria;
import org.example.domain.library.repository.criteria.RemoveLibraryCriteria;

/**
 * 图书馆Library的仓储接口定义，主要封装领域内的存储层的增、删、改、查操作
 * 1、支持从多种数据存储中间件中获取领域数据，eg：Mysql、ElasticSearch ...
 * 2、封装领域的事务性操作
 */
public interface LibraryRepository {

    /**
     * 保存图书馆信息
     *
     * @param library 图书馆信息
     * @return 是否成功
     */
    boolean save(Library library);

    /**
     * 查询图书馆信息
     *
     * @param criteria 查询条件
     * @return 图书馆信息
     */
    Library get(GetLibraryCriteria criteria);

    /**
     * 分页查询图书馆信息
     *
     * @param criteria 查询条件
     * @param pageNum  分页页号
     * @param pageSize 分页个数
     * @return 图书馆信息列表
     */
    PagerInfo<Library> list(ListLibraryCriteria criteria, int pageNum, int pageSize);

    /**
     * 删除图书馆信息
     *
     * @param criteria 删除条件
     * @return 是否成功
     */
    boolean remove(RemoveLibraryCriteria criteria);

}
