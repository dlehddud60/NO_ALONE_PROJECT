package com.dongyoung.noAlone.comment.model;

import com.dongyoung.noAlone.board.model.FindResponseBoardCommentModel;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record InsertRequestCommentModel(
        @NotBlank(message = "빈값을 입력하실 수 없습니다.")
        String content,
        String boardId
) {
}
