package org.example.domain.book.repository.criteria;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 批量查询图书条件
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class ListBookCriteria {

    /**
     * 图书ID列表
     */
    private List<Long> idList;

    /**
     * 所属图书馆ID
     */
    private Long libraryId;

}
