package org.example.common.copier;

import com.westsecu.inf.base.copier.IObjectCopier;
import org.example.sdk.book.request.QueryBookRequest;
import org.example.service.param.ListBookParam;
import org.mapstruct.Mapper;

@Mapper
public interface QueryBookRequestToListBookParamCopier extends IObjectCopier<QueryBookRequest, ListBookParam> {

}
