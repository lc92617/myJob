package org.example.common.copier;

import com.westsecu.inf.base.copier.IObjectCopier;
import org.example.domain.book.entity.Book;
import org.example.sdk.book.request.UpdateBookRequest;
import org.mapstruct.Mapper;

@Mapper
public interface UpdateBookRequestToBookCopier extends IObjectCopier<UpdateBookRequest, Book> {
}
