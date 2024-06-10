package com.dongyoung.noAlone.comment.model;

import com.dongyoung.noAlone.board.model.FindResponseBoardCommentListModel;
import com.dongyoung.noAlone.board.model.FindResponseBoardCommentModel;
import com.dongyoung.noAlone.member.Model.FindResponseMemberWithCommentListModel;

import java.time.LocalDate;

public record FindResponseCommentListModel(
        Long commentId,
        String content,
        LocalDate inputDt,
        FindResponseBoardCommentListModel board,
        FindResponseMemberWithCommentListModel member
) {
}
