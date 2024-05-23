package com.dongyoung.noAlone.member.Model;

import com.dongyoung.noAlone.mbti.model.FindResponseMbtiModel;
import com.dongyoung.noAlone.mbti.model.FindResponseMbtiWithMemberModel;

import java.time.LocalDate;

public record FindResponseMemberWithMbtiModel(
        String id,
        String password,
        String nickname,
        String name,
        String email,
        String gender,
        int age,
        String birthday,
        String birthyear,
        String mobile,
        LocalDate updateDt,
        FindResponseMbtiWithMemberModel mbtiWithMemberModel
) {
}
