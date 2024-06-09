package com.dongyoung.noAlone.board.service.impl;

import com.dongyoung.noAlone.board.entity.Board;
import com.dongyoung.noAlone.board.model.*;
import com.dongyoung.noAlone.board.model.mapper.BoardMapper;
import com.dongyoung.noAlone.board.repository.BoardQueryRepository;
import com.dongyoung.noAlone.board.repository.BoardRepository;
import com.dongyoung.noAlone.board.service.BoardService;
import com.dongyoung.noAlone.category.repository.CategoryRepository;
import com.dongyoung.noAlone.common.entity.DateTime;
import com.dongyoung.noAlone.member.entity.Member;
import com.dongyoung.noAlone.member.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
@Log4j2
public class BoardServiceImpl implements BoardService {
    private final BoardRepository boardRepository;
    private final BoardQueryRepository boardQueryRepository;
    private final BoardMapper boardMapper;
    private final MemberRepository memberRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public List<FindResponseBoardListModel> findAll() {
        return boardRepository.findAll().stream().map(boardMapper::toBoardResListModel).collect(Collectors.toList());
    }

    @Override
    public Page<FindResponseBoardListModel> findAllByQueryDsl(SearchCondition search, Pageable pageable, FindCategorySort category) {
        return boardQueryRepository.findAllByQueryDsl(search, pageable,category);
    }

    @Override
    public FindResponseBoardModel find(Long boardId) {
        return boardMapper.toBoardResFindModel(boardRepository.findByBoardId(boardId));
    }

    @Override
    public void save(InsertRequestBoardModel boardModel, Member member) {
        log.info("=======boardModel======{}",boardModel);
        Board board = Board.builder()
                .title(boardModel.title())
                .content(boardModel.content())
                .views(0)
                .dateTime(DateTime.builder()
                        .inputDt(LocalDate.now())
                        .build())
                .member(memberRepository.findByMemberId(member.getMemberId()))
                .category(categoryRepository.findByCategoryId(Long.parseLong(boardModel.categoryId())))
                .build();
        boardRepository.save(board);
    }

    @Override
    public void update(UpdateRequestBoardModel boardModel) {
        Board board = boardRepository.findByBoardId(boardModel.boardId());
        board.setTitle(boardModel.title());
        board.setContent(boardModel.content());
    }

    @Override
    public void delete(Long boardId) {
        boardRepository.deleteById(boardId);
    }

    @Override
    public void updateCount(Long boardId) {
        Board board = boardRepository.findByBoardId(boardId);
        board.setViews(board.getViews() + 1);
    }
}
