package com.dongyoung.noAlone.commentRe.model;

import jakarta.validation.constraints.NotBlank;

public record InsertRequestCommentReModel(
        @NotBlank(message = "빈값을 입력하실 수 없습니다.")
        String content,
        String commentId
        ) {
}
