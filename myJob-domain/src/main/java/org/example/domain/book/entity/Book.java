package org.example.domain.book.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 图书领域实体定义
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book implements Serializable {

    private static final long serialVersionUID = 861799904083777395L;
    /**
     * 图书的ID
     */
    private Long id;

    /**
     * 图书名称
     */
    private String name;

    /**
     * 所属的图书馆ID
     */
    private Long libraryId;

    /**
     * 图书作者ID
     */
    private Long authorId;

    /**
     * 图书是否可以使用
     */
    private Boolean enabled;

    /**
     * 图书的库存
     */
    private Long stock;

    /**
     * 信息创建时间
     */
    private Date createTime;

    /**
     * 信息更新时间
     */
    private Date updateTime;
}
