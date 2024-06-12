package com.dongyoung.noAlone.commentRe.model;

import com.dongyoung.noAlone.board.model.FindResponseBoardCommentModel;
import com.dongyoung.noAlone.member.Model.FindResponseMemberWithCommentModel;

import java.time.LocalDate;

public record FindResponseCommentReModel(
        Long commentReId,
        String content,
        LocalDate inputDt,
        FindResponseBoardCommentModel board,
        FindResponseMemberWithCommentModel member
) {
}
