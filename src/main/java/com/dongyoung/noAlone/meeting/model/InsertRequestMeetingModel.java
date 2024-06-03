package com.dongyoung.noAlone.meeting.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record InsertRequestMeetingModel(

        @NotBlank(message = "모임명을 입력해주시길 바랍니다.")
        String name,
        @NotBlank(message = "모임의 상세 내용을 입력해주시길 바랍니다.")
        String content,
        @NotBlank(message = "모임의 규칙을 입력해주시길 바랍니다.")
        String rule,
        @NotBlank(message = "모임의 활동 범위인 지역을 입력해주시길 바랍니다.")
        String location,
        @NotBlank(message = "가입할 모임의 멤버에 대한 질문을 입력해주시길 바랍니다.")
        String question,
        @NotNull
        Long memberId
) {
}
