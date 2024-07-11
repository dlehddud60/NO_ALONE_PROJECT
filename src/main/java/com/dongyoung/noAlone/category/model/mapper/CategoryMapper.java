package com.dongyoung.noAlone.category.model.mapper;

import com.dongyoung.noAlone.category.entity.Category;
import com.dongyoung.noAlone.category.model.FindResponseCategoryListModel;
import com.dongyoung.noAlone.category.model.FindResponseCategoryModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    FindResponseCategoryModel toCategoryModel(Category category);

    FindResponseCategoryListModel toCategoryListModel(Category category);
}
