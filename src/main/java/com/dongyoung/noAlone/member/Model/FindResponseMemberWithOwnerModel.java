package com.dongyoung.noAlone.member.Model;

import com.dongyoung.noAlone.member.entity.Role;

public record FindResponseMemberWithOwnerModel(
        Long memberId,
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
