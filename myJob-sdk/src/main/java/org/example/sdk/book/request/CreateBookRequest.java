package org.example.sdk.book.request;

import com.westsecu.inf.base.model.api.request.AbstractRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * 创建图书信息请求
 */
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
public class CreateBookRequest extends AbstractRequest {

    /**
     * 图书名称
     */
    private String name;

    /**
     * 图书作者ID
     */
    private Long authorId;

    /**
     * 所属的图书馆ID
     */
    private Long libraryId;

    /**
     * 图书是否启用
     */
    private Boolean enabled;

    /**
     * 图书库存
     */
    private Long stock;
}
