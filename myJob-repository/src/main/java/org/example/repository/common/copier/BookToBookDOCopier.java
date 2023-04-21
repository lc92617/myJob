package org.example.repository.common.copier;

import com.westsecu.inf.base.copier.IObjectCopier;
import org.example.domain.book.entity.Book;
import org.example.repository.book.model.BookDO;
import org.mapstruct.Mapper;

@Mapper
public interface BookToBookDOCopier extends IObjectCopier<Book, BookDO> {

}
