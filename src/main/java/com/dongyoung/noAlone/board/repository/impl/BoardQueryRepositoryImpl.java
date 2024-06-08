package com.dongyoung.noAlone.board.repository.impl;

import com.dongyoung.noAlone.board.entity.Board;
import com.dongyoung.noAlone.board.model.FindResponseBoardWithMemberListModel;
import com.dongyoung.noAlone.board.model.SearchCondition;
import com.dongyoung.noAlone.board.model.mapper.BoardMapper;
import com.dongyoung.noAlone.board.repository.BoardQueryRepository;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Wildcard;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

import static com.dongyoung.noAlone.board.entity.QBoard.board;

@Repository
@RequiredArgsConstructor
public class BoardQueryRepositoryImpl implements BoardQueryRepository {
    private final JPAQueryFactory queryFactory;
    private final BoardMapper boardMapper;

    @Override
    public Page<FindResponseBoardWithMemberListModel> findAllByQueryDsl(SearchCondition search, Pageable pageable) {

        List<Board> list = queryFactory.selectFrom(board)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .where(search(search.name()))
                .orderBy(board.boardId.desc())
                .fetch();
        JPAQuery<Long> count = queryFactory.select(Wildcard.count).from(board);
        return PageableExecutionUtils.getPage(list.stream().map(boardMapper::toBoardResListModel).collect(Collectors.toList()),pageable,count::fetchCount);
    }

    private BooleanExpression search(String search) {
        return search != null ? board.title.contains(search) : null;
    }
}
