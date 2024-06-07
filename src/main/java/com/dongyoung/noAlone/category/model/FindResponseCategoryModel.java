package com.dongyoung.noAlone.category.model;

import jakarta.persistence.Column;

import java.time.LocalDate;

public record FindResponseCategoryModel(

        Long categoryId,
        String name,
        String description,
        LocalDate inputDt
) {
}
