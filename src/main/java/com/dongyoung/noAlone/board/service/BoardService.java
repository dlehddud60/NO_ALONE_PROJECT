package com.dongyoung.noAlone.board.service;

import com.dongyoung.noAlone.board.model.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BoardService{
    List<FindResponseBoardListModel> findAll();

    FindResponseBoardModel find(Long boardId);

    void save(InsertRequestBoardModel boardModel);

    void update(UpdateRequestBoardModel boardModel);

    void delete(Long boardId);

    Page<FindResponseBoardListModel> findAllByQueryDsl(SearchCondition search, Pageable pageable);
}

