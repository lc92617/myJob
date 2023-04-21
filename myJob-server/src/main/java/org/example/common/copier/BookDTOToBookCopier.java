package org.example.common.copier;

import com.westsecu.inf.base.copier.IObjectCopier;
import org.example.domain.book.entity.Book;
import org.example.sdk.book.model.BookDTO;
import org.mapstruct.Mapper;

@Mapper
public interface BookDTOToBookCopier extends IObjectCopier<BookDTO, Book> {

}
