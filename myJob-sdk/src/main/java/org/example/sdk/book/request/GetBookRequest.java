package org.example.sdk.book.request;

import com.westsecu.inf.base.model.api.request.AbstractRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * 获取图书信息请求
 */
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
public class GetBookRequest extends AbstractRequest {

    /**
     * 图书ID
     */
    private Long id;

}
