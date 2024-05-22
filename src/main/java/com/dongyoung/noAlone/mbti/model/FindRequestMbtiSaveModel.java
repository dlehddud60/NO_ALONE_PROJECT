package com.dongyoung.noAlone.mbti.model;

import jakarta.persistence.Column;

public record FindRequestMbtiSaveModel(
        String name,
        String description
) {
}
