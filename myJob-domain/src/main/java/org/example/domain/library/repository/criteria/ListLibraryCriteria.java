package org.example.domain.library.repository.criteria;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 批量查询图书馆条件
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class ListLibraryCriteria {

    /**
     * 图书馆ID列表
     */
    private List<Long> idList;

}
