package com.dongyoung.noAlone.category.model.mapper;

import com.dongyoung.noAlone.category.entity.Category;
import com.dongyoung.noAlone.category.model.FindResponseCategoryListModel;
import com.dongyoung.noAlone.category.model.FindResponseCategoryModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mapping(source = "dateTime.inputDt", target = "inputDt")
    FindResponseCategoryModel toCategoryModel(Category category);

    @Mapping(source = "dateTime.inputDt", target = "inputDt")
    FindResponseCategoryListModel toCategoryListModel(Category category);
}
