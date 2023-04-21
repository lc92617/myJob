package org.example.domain.book.repository.criteria;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 删除图书条件
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class RemoveBookCriteria {

    /**
     * 图书ID列表
     */
    private List<Long> idList;
}
