package org.example.domain.library.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 图书馆领域模型
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Library implements Serializable {

    private static final long serialVersionUID = -1689428525862283541L;
    /**
     * 图书馆ID
     */
    private Long id;

    /**
     * 图书馆名称
     */
    private String name;

    /**
     * 图书馆地址
     */
    private String address;

    /**
     * 图书馆信息创建时间
     */
    private Date createTime;

    /**
     * 图书馆信息修改时间
     */
    private Date updateTime;
}
