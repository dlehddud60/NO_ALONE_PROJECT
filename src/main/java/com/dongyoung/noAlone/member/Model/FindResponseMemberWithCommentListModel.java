package com.dongyoung.noAlone.member.Model;

public record FindResponseMemberWithCommentListModel(
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
