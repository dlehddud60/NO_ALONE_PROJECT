package com.dongyoung.noAlone.board.model;

import java.time.LocalDate;

public record InsertRequestBoardModel(
        String title,
        String content,
        LocalDate inputDt,
        Long categoryId
) {
}
