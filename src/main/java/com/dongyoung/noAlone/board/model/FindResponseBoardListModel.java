package com.dongyoung.noAlone.board.model;

import com.dongyoung.noAlone.category.model.FindResponseCategoryListModel;
import com.dongyoung.noAlone.member.Model.FindResponseMemberWithMemberListModel;

import java.time.LocalDate;

public record FindResponseBoardListModel(
        Long boardId,
        String title,
        String content,
        Integer views,
        LocalDate inputDt,
        FindResponseMemberWithMemberListModel member,
        FindResponseCategoryListModel category

) {
}
