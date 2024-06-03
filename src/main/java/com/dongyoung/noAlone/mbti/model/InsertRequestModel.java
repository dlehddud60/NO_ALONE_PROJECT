package com.dongyoung.noAlone.mbti.model;

import jakarta.validation.constraints.NotBlank;

public record InsertRequestModel(
        @NotBlank
        String name,
        @NotBlank
        String description
) {
}
