package com.dongyoung.noAlone.meeting.model;

import com.dongyoung.noAlone.accept.entity.Status;
import jakarta.validation.constraints.NotNull;

public record ChangeStatusRequestModel(
        @NotNull(message = "값이 정상적으로 들어가지 않았습니다.")
        Long acceptId,
        @NotNull(message = "값이 정상적으로 들어가지 않았습니다.")
        Status status
) {
}
