package com.dongyoung.noAlone.board.model;

import jakarta.persistence.Column;

import java.time.LocalDate;

public record FindResponseBoardModel(
        Long boardId,
        String title,
        String content,
        LocalDate inputDt
) {
}
