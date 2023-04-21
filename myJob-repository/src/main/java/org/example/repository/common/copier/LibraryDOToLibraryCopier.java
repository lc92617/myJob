package org.example.repository.common.copier;

import com.westsecu.inf.base.copier.IObjectCopier;
import org.example.domain.library.entity.Library;
import org.example.repository.library.model.LibraryDO;
import org.mapstruct.Mapper;

@Mapper
public interface LibraryDOToLibraryCopier extends IObjectCopier<LibraryDO, Library> {

}
