package com.dongyoung.noAlone.board.model;

import com.dongyoung.noAlone.member.Model.FindResponseMemberWithMemberListModel;

import java.time.LocalDate;

public record FindResponseBoardWithMemberListModel(
        Long boardId,
        String title,
        String content,
        Integer views,
        LocalDate inputDt,
        FindResponseMemberWithMemberListModel member
) {
}
