package com.dongyoung.noAlone.accept.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record InsertRequestApplicationModel(
        @NotBlank(message = "자기소개를 입력해주시길 바랍니다.")
        String aboutMe,
        @NotBlank(message = "신청 이유에 대해서 알려주시길 바랍니다.")
        String companionReason,
        @NotNull
        Long memberId,
        @NotNull
        Long meetingId
) {
}
