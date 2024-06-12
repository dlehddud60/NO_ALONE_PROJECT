package com.dongyoung.noAlone.category.model.mapper;

import com.dongyoung.noAlone.category.entity.Category;
import com.dongyoung.noAlone.category.model.FindResponseCategoryListModel;
import com.dongyoung.noAlone.category.model.FindResponseCategoryModel;
import com.dongyoung.noAlone.common.entity.DateTime;
import java.time.LocalDate;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-10T21:00:00+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public FindResponseCategoryModel toCategoryModel(Category category) {
        if ( category == null ) {
            return null;
        }

        LocalDate inputDt = null;
        Long categoryId = null;
        String name = null;
        String description = null;

        inputDt = categoryDateTimeInputDt( category );
        categoryId = category.getCategoryId();
        name = category.getName();
        description = category.getDescription();

        FindResponseCategoryModel findResponseCategoryModel = new FindResponseCategoryModel( categoryId, name, description, inputDt );

        return findResponseCategoryModel;
    }

    @Override
    public FindResponseCategoryListModel toCategoryListModel(Category category) {
        if ( category == null ) {
            return null;
        }

        LocalDate inputDt = null;
        Long categoryId = null;
        String name = null;
        String description = null;

        inputDt = categoryDateTimeInputDt( category );
        categoryId = category.getCategoryId();
        name = category.getName();
        description = category.getDescription();

        FindResponseCategoryListModel findResponseCategoryListModel = new FindResponseCategoryListModel( categoryId, name, description, inputDt );

        return findResponseCategoryListModel;
    }

    private LocalDate categoryDateTimeInputDt(Category category) {
        if ( category == null ) {
            return null;
        }
        DateTime dateTime = category.getDateTime();
        if ( dateTime == null ) {
            return null;
        }
        LocalDate inputDt = dateTime.getInputDt();
        if ( inputDt == null ) {
            return null;
        }
        return inputDt;
    }
}
