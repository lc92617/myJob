package org.example.repository.library.mapper;

import org.example.repository.library.model.LibraryDO;
import org.example.repository.library.model.LibraryDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface LibraryMapper {
    long countByExample(LibraryDOExample example);

    int deleteByExample(LibraryDOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(LibraryDO record);

    int insertSelective(LibraryDO record);

    List<LibraryDO> selectByExampleSelective(@Param("example") LibraryDOExample example, @Param("selective") LibraryDO.Column ... selective);

    List<LibraryDO> selectByExample(LibraryDOExample example);

    LibraryDO selectByPrimaryKeySelective(@Param("id") Long id, @Param("selective") LibraryDO.Column ... selective);

    LibraryDO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") LibraryDO record, @Param("example") LibraryDOExample example);

    int updateByExample(@Param("record") LibraryDO record, @Param("example") LibraryDOExample example);

    int updateByPrimaryKeySelective(LibraryDO record);

    int updateByPrimaryKey(LibraryDO record);

    int batchInsert(@Param("list") List<LibraryDO> list);

    int batchInsertSelective(@Param("list") List<LibraryDO> list, @Param("selective") LibraryDO.Column ... selective);
}