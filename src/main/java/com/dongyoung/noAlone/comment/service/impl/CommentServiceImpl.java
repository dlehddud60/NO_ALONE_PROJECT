package com.dongyoung.noAlone.comment.service.impl;

import com.dongyoung.noAlone.board.repository.BoardRepository;
import com.dongyoung.noAlone.comment.entity.Comment;
import com.dongyoung.noAlone.comment.model.FindResponseCommentListModel;
import com.dongyoung.noAlone.comment.model.InsertRequestCommentModel;
import com.dongyoung.noAlone.comment.model.UpdateRequestCommentModel;
import com.dongyoung.noAlone.comment.model.mapper.CommentMapper;
import com.dongyoung.noAlone.comment.repository.CommentRepository;
import com.dongyoung.noAlone.comment.service.CommentService;
import com.dongyoung.noAlone.common.entity.DateTime;
import com.dongyoung.noAlone.member.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
@Log4j2
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;
    private final CommentMapper commentMapper;

    @Override
    public List<FindResponseCommentListModel> findAll(Long boardId) {
        return commentRepository.findAllByBoard_BoardId(boardId).stream().map(commentMapper::toCommentListModel).collect(Collectors.toList());
    }

    @Override
    public void save(InsertRequestCommentModel comment, Long memberId) {
        Comment commentEntity = Comment.builder()
                .content(comment.content())
                .dateTime(DateTime.builder()
                        .inputDt(LocalDate.now())
                        .build())
                .board(boardRepository.findByBoardId(Long.parseLong(comment.boardId())))
                .member(memberRepository.findByMemberId(memberId))
                .build();
        commentRepository.save(commentEntity);
    }

    @Override
    public void update(UpdateRequestCommentModel commentModel, Long commentId) {
        Comment comment = commentRepository.findByCommentId(commentId);
        comment.setContent(commentModel.content());
    }

    @Override
    public void delete(Long commentId) {
        commentRepository.deleteById(commentId);
    }
}
