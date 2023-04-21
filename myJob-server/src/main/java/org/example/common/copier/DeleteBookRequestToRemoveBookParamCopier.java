package org.example.common.copier;

import com.westsecu.inf.base.copier.IObjectCopier;
import org.example.sdk.book.request.DeleteBookRequest;
import org.example.service.param.RemoveBookParam;
import org.mapstruct.Mapper;

@Mapper
public interface DeleteBookRequestToRemoveBookParamCopier extends IObjectCopier<DeleteBookRequest, RemoveBookParam> {
}
