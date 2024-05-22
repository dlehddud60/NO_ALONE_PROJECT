package com.dongyoung.noAlone.mbti.model;

public record FindRequestUpdateModel(
        Long mbtiId,
        String name,
        String description
) {
}
