package org.example.domain.library.repository.criteria;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 查询图书馆条件
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class GetLibraryCriteria {

    /**
     * 图书馆ID
     */
    private Long id;
}
