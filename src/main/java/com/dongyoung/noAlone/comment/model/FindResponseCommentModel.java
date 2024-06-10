package com.dongyoung.noAlone.comment.model;

import com.dongyoung.noAlone.board.model.FindResponseBoardCommentModel;
import com.dongyoung.noAlone.common.entity.DateTime;
import com.dongyoung.noAlone.member.Model.FindResponseMemberWithCommentModel;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record FindResponseCommentModel(
        Long commentId,
        String content,
        LocalDate inputDt,
        FindResponseBoardCommentModel board,
        FindResponseMemberWithCommentModel member
) {
}
