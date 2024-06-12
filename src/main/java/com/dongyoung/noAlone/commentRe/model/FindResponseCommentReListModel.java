package com.dongyoung.noAlone.commentRe.model;

import com.dongyoung.noAlone.board.model.FindResponseBoardCommentListModel;
import com.dongyoung.noAlone.comment.model.FindResponseCommentListModel;
import com.dongyoung.noAlone.member.Model.FindResponseMemberWithCommentListModel;

import java.time.LocalDate;

public record FindResponseCommentReListModel(
        Long commentReId,
        String content,
        LocalDate inputDt,
        FindResponseCommentListModel comment,
        FindResponseMemberWithCommentListModel member
) {
}
