package com.dongyoung.noAlone.board.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.lang.Nullable;

import java.time.LocalDate;

public record InsertRequestBoardModel(
        @NotBlank(message = "전부 입력해주시길 바랍니다.")
        String title,
        @NotBlank(message = "전부 입력해주시길 바랍니다. ")
        String content,
        LocalDate inputDt,
        String  categoryId,
        @Nullable
        String meetingId,
        String memberId
) {
}
