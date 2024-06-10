package com.dongyoung.noAlone.board.model;

import com.dongyoung.noAlone.comment.model.FindResponseCommentListModel;
import com.dongyoung.noAlone.comment.model.FindResponseCommentModel;

import java.time.LocalDate;

public record FindResponseBoardCommentListModel(
        Long boardId,
        String title,
        String content,
        Integer views,
        LocalDate inputDt,
        FindResponseCommentListModel comment
) {
}
