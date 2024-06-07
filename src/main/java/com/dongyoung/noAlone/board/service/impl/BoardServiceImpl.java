package com.dongyoung.noAlone.board.service.impl;

import com.dongyoung.noAlone.board.entity.Board;
import com.dongyoung.noAlone.board.model.*;
import com.dongyoung.noAlone.board.model.mapper.BoardMapper;
import com.dongyoung.noAlone.board.repository.BoardQueryRepository;
import com.dongyoung.noAlone.board.repository.BoardRepository;
import com.dongyoung.noAlone.board.service.BoardService;
import com.dongyoung.noAlone.common.entity.DateTime;
import com.dongyoung.noAlone.member.entity.Member;
import com.dongyoung.noAlone.member.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    private final BoardRepository boardRepository;
    private final BoardQueryRepository boardQueryRepository;
    private final BoardMapper boardMapper;
    private final MemberRepository memberRepository;

    @Override
    public List<FindResponseBoardWithMemberListModel> findAll() {
        return boardRepository.findAll().stream().map(boardMapper::toBoardListModel).collect(Collectors.toList());
    }

    @Override
    public Page<FindResponseBoardWithMemberListModel> findAllByQueryDsl(SearchCondition search, Pageable pageable) {
        return boardQueryRepository.findAllByQueryDsl(search, pageable);
    }

    @Override
    public FindResponseBoardWithMemberModel find(Long boardId) {
        return boardMapper.toBoardFindModel(boardRepository.findByBoardId(boardId));
    }

    @Override
    public void save(InsertRequestBoardModel boardModel, Member member) {
        Board board = Board.builder()
                .title(boardModel.title())
                .content(boardModel.content())
                .dateTime(DateTime.builder()
                        .inputDt(LocalDate.now())
                        .build())
                .member(memberRepository.findByMemberId(member.getMemberId()))
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
}
