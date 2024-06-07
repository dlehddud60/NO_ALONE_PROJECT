package com.dongyoung.noAlone.board.model;

import java.time.LocalDate;

public record FindResponseBoardListModel(
        Long boardId,
        String title,
        String content,
        Long views,
        LocalDate inputDt
) {
}
