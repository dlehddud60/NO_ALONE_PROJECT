package com.dongyoung.noAlone.board.model;

import java.time.LocalDate;

public record UpdateRequestBoardModel(
        Long boardId,
        String title,
        String content,
        LocalDate inputDt
) {
}
