package com.dongyoung.noAlone.board.model;

import com.dongyoung.noAlone.member.Model.FindResponseMemberWithMemberListModel;
import com.dongyoung.noAlone.member.Model.FindResponseMemberWithMemberModel;

import java.time.LocalDate;

public record FindResponseBoardWithMemberModel(
        Long boardId,
        String title,
        String content,
        Long views,
        LocalDate inputDt,
        FindResponseMemberWithMemberModel member
) {
}
