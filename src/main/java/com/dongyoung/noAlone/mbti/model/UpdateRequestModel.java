package com.dongyoung.noAlone.mbti.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UpdateRequestModel(
        @NotNull
        Long mbtiId,
        @NotBlank
        String name,
        @NotBlank
        String description
) {
}
