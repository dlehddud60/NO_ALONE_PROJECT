package com.dongyoung.noAlone.board.model;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record UpdateRequestBoardModel(
        Long boardId,
        @NotBlank(message = "전부 입력해주시길 바랍니다.")
        String title,
        @NotBlank(message = "전부 입력해주시길 바랍니다.")
        String content,
        LocalDate inputDt
) {
}
