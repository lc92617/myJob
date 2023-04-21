package org.example.sdk.book.request;

import com.westsecu.inf.base.model.api.request.AbstractPageRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * 检索图书信息请求
 */
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
public class SearchBookRequest extends AbstractPageRequest {

    /**
     * 检索关键字
     */
    private String searchKey;

    /**
     * 检索值
     */
    private String searchValue;

}
