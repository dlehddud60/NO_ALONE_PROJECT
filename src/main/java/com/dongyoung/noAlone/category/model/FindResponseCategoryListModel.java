package com.dongyoung.noAlone.category.model;

import java.time.LocalDate;

public record FindResponseCategoryListModel(
        Long categoryId,
        String name,
        String description,
        LocalDate inputDt
) {
}
