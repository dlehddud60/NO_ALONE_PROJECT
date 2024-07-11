package com.dongyoung.noAlone.category.model.mapper;

import com.dongyoung.noAlone.category.entity.Category;
import com.dongyoung.noAlone.category.model.FindResponseCategoryListModel;
import com.dongyoung.noAlone.category.model.FindResponseCategoryModel;
import java.time.LocalDate;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-11T10:51:18+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public FindResponseCategoryModel toCategoryModel(Category category) {
        if ( category == null ) {
            return null;
        }

        Long categoryId = null;
        String name = null;
        String description = null;
        LocalDate inputDt = null;

        categoryId = category.getCategoryId();
        name = category.getName();
        description = category.getDescription();
        inputDt = category.getInputDt();

        FindResponseCategoryModel findResponseCategoryModel = new FindResponseCategoryModel( categoryId, name, description, inputDt );

        return findResponseCategoryModel;
    }

    @Override
    public FindResponseCategoryListModel toCategoryListModel(Category category) {
        if ( category == null ) {
            return null;
        }

        Long categoryId = null;
        String name = null;
        String description = null;
        LocalDate inputDt = null;

        categoryId = category.getCategoryId();
        name = category.getName();
        description = category.getDescription();
        inputDt = category.getInputDt();

        FindResponseCategoryListModel findResponseCategoryListModel = new FindResponseCategoryListModel( categoryId, name, description, inputDt );

        return findResponseCategoryListModel;
    }
}
