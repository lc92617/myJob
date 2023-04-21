package org.example.repository.library;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.westsecu.inf.base.copier.ObjectCopierFactory;
import com.westsecu.inf.base.model.PagerInfo;
import org.example.domain.library.entity.Library;
import org.example.domain.library.repository.LibraryRepository;
import org.example.domain.library.repository.criteria.GetLibraryCriteria;
import org.example.domain.library.repository.criteria.ListLibraryCriteria;
import org.example.domain.library.repository.criteria.RemoveLibraryCriteria;
import org.example.repository.library.mapper.LibraryMapper;
import org.example.repository.library.model.LibraryDO;
import org.example.repository.library.model.LibraryDOExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * 仓储实现，主要封装领域内的存储层的增、删、改、查操作
 * 1、支持从多种数据存储中间件中获取领域数据，eg：Mysql、ElasticSearch ...
 * 2、封装领域的事务性操作
 */
@Component
public class LibraryRepositoryImpl implements LibraryRepository {

    @Autowired
    private LibraryMapper mapper;
    @Autowired
    private ObjectCopierFactory copierFactory;

    @Override
    public boolean save(Library library) {
        LibraryDO record = copierFactory.to(library, LibraryDO.class);
        record.setCreateTime(new Date());
        record.setUpdateTime(record.getCreateTime());
        int rows = mapper.insertSelective(record);
        // 回填领域数据
        library.setId(record.getId());
        library.setCreateTime(record.getCreateTime());
        library.setUpdateTime(record.getUpdateTime());
        return rows == 0 ? Boolean.FALSE : Boolean.TRUE;
    }

    @Override
    public Library get(GetLibraryCriteria criteria) {
        LibraryDOExample example = new LibraryDOExample();
        LibraryDOExample.Criteria exampleCriteria = example.createCriteria();
        if (criteria.getId() != null) {
            exampleCriteria.andIdEqualTo(criteria.getId());
        }
        List<LibraryDO> data = mapper.selectByExample(example);
        return data == null || data.isEmpty() ? null : copierFactory.to(data.get(0), Library.class);
    }

    @Override
    public PagerInfo<Library> list(ListLibraryCriteria criteria, int pageNum, int pageSize) {
        LibraryDOExample example = new LibraryDOExample();
        LibraryDOExample.Criteria exampleCriteria = example.createCriteria();
        if (criteria.getIdList() != null && !criteria.getIdList().isEmpty()) {
            exampleCriteria.andIdIn(criteria.getIdList());
        }
        PageInfo<LibraryDO> pageInfo = PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(() -> mapper.selectByExample(example));
        List<Library> data = copierFactory.toList(pageInfo.getList(), Library.class);
        return PagerInfo.<Library>builder().pageNum(pageNum).pageSize(pageSize).total(pageInfo.getTotal()).data(data).build();
    }

    @Override
    public boolean remove(RemoveLibraryCriteria criteria) {
        LibraryDOExample example = new LibraryDOExample();
        LibraryDOExample.Criteria exampleCriteria = example.createCriteria();
        if (criteria.getIdList() != null && !criteria.getIdList().isEmpty()) {
            exampleCriteria.andIdIn(criteria.getIdList());
        }
        int rows = mapper.deleteByExample(example);
        return Boolean.TRUE;
    }
}
