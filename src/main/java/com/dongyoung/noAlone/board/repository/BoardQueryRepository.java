package com.dongyoung.noAlone.board.repository;

import com.dongyoung.noAlone.board.model.FindResponseBoardWithMemberListModel;
import com.dongyoung.noAlone.board.model.SearchCondition;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BoardQueryRepository {
    Page<FindResponseBoardWithMemberListModel> findAllByQueryDsl(SearchCondition search, Pageable pageable);

}
