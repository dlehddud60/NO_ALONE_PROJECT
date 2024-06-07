package com.dongyoung.noAlone.category.repository;

import com.dongyoung.noAlone.category.model.FindResponseCategoryListModel;
import com.dongyoung.noAlone.category.model.SearchCondition;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryQueryRepository {
    Page<FindResponseCategoryListModel> findAllbyQueryDsl(SearchCondition search, Pageable pageable);
}
