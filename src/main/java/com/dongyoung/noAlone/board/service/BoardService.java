package com.dongyoung.noAlone.board.service;

import com.dongyoung.noAlone.board.model.*;
import com.dongyoung.noAlone.member.entity.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BoardService{
    List<FindResponseBoardWithMemberListModel> findAll();

    FindResponseBoardWithMemberModel find(Long boardId);

    void save(InsertRequestBoardModel boardModel, Member member);

    void update(UpdateRequestBoardModel boardModel);

    void delete(Long boardId);

    Page<FindResponseBoardWithMemberListModel> findAllByQueryDsl(SearchCondition search, Pageable pageable);
}

