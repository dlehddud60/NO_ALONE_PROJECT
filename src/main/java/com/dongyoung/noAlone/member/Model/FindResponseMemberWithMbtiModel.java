package com.dongyoung.noAlone.member.Model;

import com.dongyoung.noAlone.mbti.model.FindResponseMbtiModel;
import com.dongyoung.noAlone.mbti.model.FindResponseMbtiWithMemberModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

public record FindResponseMemberWithMbtiModel(
        String id,
        @NotBlank(message = "비밀번호는 필수 입력 값입니다.")
        @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,16}", message = "비밀번호는 8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.")
        String password,
        @Pattern(regexp = "^[ㄱ-ㅎ가-힣a-z0-9-_]{2,10}$", message = "닉네임은 특수문자를 제외한 2~10자리여야 합니다.")
        String nickname,

        @NotBlank(message = "사용자의 이름 필수 입력 값입니다.")
        String name,

        @Pattern(regexp = "^(?:\\w+\\.?)*\\w+@(?:\\w+\\.)+\\w+$", message = "이메일 형식이 올바르지 않습니다.")
        @NotBlank(message = "이메일은 필수 입력 값입니다.")
        String email,

        @NotBlank(message = "성별을 선택해주시길 바랍니다.")
        String gender,

        @NotNull(message = "나이는 필수 입력 값입니다.")
        Integer age,

        @NotBlank(message = "월일은 필수 입력 값입니다.")
        String birthday,

        @NotBlank(message = "생년은 필수 입력 값입니다.")
        String birthyear,
        @NotBlank(message = "핸드폰 번호는 필수 입력 값입니다.")
        String mobile,

        LocalDate updateDt,
        FindResponseMbtiWithMemberModel mbtiWithMemberModel
) {
}
