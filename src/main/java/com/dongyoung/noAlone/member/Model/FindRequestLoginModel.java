package com.dongyoung.noAlone.member.Model;

import jakarta.persistence.Column;

public record FindRequestLoginModel(
        String id,
        String password) {
}
