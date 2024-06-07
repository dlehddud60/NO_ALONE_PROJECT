package com.dongyoung.noAlone.category.model;

import java.time.LocalDate;

public record InsertRequestCategoryModel(
        String name,
        String description,
        LocalDate inputDt
) {
}
