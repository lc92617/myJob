package org.example.sdk.book.model;

import com.westsecu.inf.base.model.BaseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * 图书Book传输对象
 *
 * @version 1.0
 */
@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO extends BaseDTO {

    /**
     * 图书的ID
     */
    private Long id;

    /**
     * 图书的名字
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
     * 图书的库存
     */
    private Long stock;
}
