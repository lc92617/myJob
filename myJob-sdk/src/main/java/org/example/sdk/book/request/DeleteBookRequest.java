package org.example.sdk.book.request;

import com.westsecu.inf.base.model.api.request.AbstractRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

/**
 * 删除图书信息请求
 */
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
public class DeleteBookRequest extends AbstractRequest {

    /**
     * 图书ID列表
     */
    private List<Long> idList;
}
