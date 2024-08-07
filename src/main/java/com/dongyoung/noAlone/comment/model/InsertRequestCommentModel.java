package com.dongyoung.noAlone.comment.model;

import jakarta.validation.constraints.NotBlank;

public record InsertRequestCommentModel(
        @NotBlank(message = "빈값을 입력하실 수 없습니다.")
        String content,
        Long boardId
) {
}
