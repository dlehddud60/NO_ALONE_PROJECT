package com.dongyoung.noAlone.category.service;

import com.dongyoung.noAlone.category.model.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryService {
    List<FindResponseCategoryListModel> findAll();

    FindResponseCategoryModel find(Long categoryId);

    void save(InsertRequestCategoryModel categoryModel);

    void update(UpdateRequestCategoryModel categoryModel);

    void delete(Long categoryId);

    Page<FindResponseCategoryListModel> findAllbyQueryDsl(SearchCondition search, Pageable pageable);

}
