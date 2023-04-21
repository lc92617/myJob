package org.example.domain.book.repository.criteria;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 查询图书条件
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class GetBookCriteria {

    /**
     * 图书ID
     */
    private Long id;
}
