package com.dongyoung.noAlone.board.repository;

import com.dongyoung.noAlone.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
    Board findByBoardId(Long boardId);
}
