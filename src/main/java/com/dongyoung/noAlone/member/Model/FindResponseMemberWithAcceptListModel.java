package com.dongyoung.noAlone.member.Model;

import com.dongyoung.noAlone.mbti.model.FindResponseMbtiWithMemberModel;

public record FindResponseMemberWithAcceptListModel(
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
        String mobile,
        FindResponseMbtiWithMemberModel mbtiWithMemberModel
) {
}
