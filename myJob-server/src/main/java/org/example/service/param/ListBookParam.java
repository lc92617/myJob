package org.example.service.param;

import com.westsecu.inf.base.model.service.param.AbstractPageParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
public class ListBookParam extends AbstractPageParam {

    private List<Long> idList;
}
