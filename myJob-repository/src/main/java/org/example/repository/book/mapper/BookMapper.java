package org.example.repository.book.mapper;

import org.example.repository.book.model.BookDO;
import org.example.repository.book.model.BookDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BookMapper {
    long countByExample(BookDOExample example);

    int deleteByExample(BookDOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BookDO record);

    int insertSelective(BookDO record);

    List<BookDO> selectByExampleSelective(@Param("example") BookDOExample example, @Param("selective") BookDO.Column ... selective);

    List<BookDO> selectByExample(BookDOExample example);

    BookDO selectByPrimaryKeySelective(@Param("id") Long id, @Param("selective") BookDO.Column ... selective);

    BookDO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BookDO record, @Param("example") BookDOExample example);

    int updateByExample(@Param("record") BookDO record, @Param("example") BookDOExample example);

    int updateByPrimaryKeySelective(BookDO record);

    int updateByPrimaryKey(BookDO record);

    int batchInsert(@Param("list") List<BookDO> list);

    int batchInsertSelective(@Param("list") List<BookDO> list, @Param("selective") BookDO.Column ... selective);
}