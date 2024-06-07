package com.dongyoung.noAlone.category.model;

import java.time.LocalDate;

public record UpdateRequestCategoryModel(
        Long categoryId,
        String name,
        String description,
        LocalDate inputDt
) {
}
