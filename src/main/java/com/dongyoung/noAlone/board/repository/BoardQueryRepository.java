package com.dongyoung.noAlone.board.repository;

import com.dongyoung.noAlone.board.model.FindCategorySort;
import com.dongyoung.noAlone.board.model.FindResponseBoardListModel;
import com.dongyoung.noAlone.board.model.SearchCondition;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BoardQueryRepository {
    Page<FindResponseBoardListModel> findAllByQueryDsl(SearchCondition search, Pageable pageable, FindCategorySort category);

}
