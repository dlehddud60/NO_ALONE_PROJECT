package com.dongyoung.noAlone.board.model;

import com.dongyoung.noAlone.category.model.FindResponseCategoryModel;
import com.dongyoung.noAlone.comment.model.FindResponseCommentModel;
import com.dongyoung.noAlone.member.Model.FindResponseMemberWithMemberModel;

import java.time.LocalDate;

public record FindResponseBoardCommentModel(
        Long boardId,
        String title,
        String content,
        Integer views,
        LocalDate inputDt,
        FindResponseCommentModel comment
) {
}
