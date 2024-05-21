package com.dongyoung.noAlone.member.Model;

import jakarta.persistence.Column;

public record FindRequestMemberModel(
        String id,
        String password,
        String nickname,
        String name,
        String email,
        String gender,
        int age,
        String birthday,
        String profileImage,
        String birthyear,
        String mobile
) {
}
