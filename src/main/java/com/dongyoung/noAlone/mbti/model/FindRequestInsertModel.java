package com.dongyoung.noAlone.mbti.model;

import jakarta.persistence.Column;

public record FindRequestInsertModel(
        String name,
        String description
) {
}
