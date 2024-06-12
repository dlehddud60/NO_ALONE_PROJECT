package com.dongyoung.noAlone.commentRe.service.impl;

import com.dongyoung.noAlone.comment.model.UpdateRequestCommentModel;
import com.dongyoung.noAlone.comment.repository.CommentRepository;
import com.dongyoung.noAlone.commentRe.entity.CommentRe;
import com.dongyoung.noAlone.commentRe.model.FindResponseCommentReListModel;
import com.dongyoung.noAlone.commentRe.model.InsertRequestCommentReModel;
import com.dongyoung.noAlone.commentRe.model.mapper.CommentReMapper;
import com.dongyoung.noAlone.commentRe.repository.CommentReRepository;
import com.dongyoung.noAlone.commentRe.service.CommentReService;
import com.dongyoung.noAlone.common.entity.DateTime;
import com.dongyoung.noAlone.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
@Log4j2
public class CommentReServiceImpl implements CommentReService {
    private final CommentReRepository commentReRepository;
    private final CommentRepository commentRepository;
    private final MemberRepository memberRepository;
    private final CommentReMapper commentReMapper;

    @Override
    public List<FindResponseCommentReListModel> findAll(Long commentId) {
        return commentReRepository.findAllByComment_CommentId(commentId).stream().map(commentReMapper::toCommentReListModel).collect(Collectors.toList());
    }

    @Override
    public void save(InsertRequestCommentReModel commentRe, Long memberId) {
        CommentRe commentReEntity = CommentRe.builder()
                .comment(commentRepository.findByCommentId(Long.parseLong(commentRe.commentId())))
                .member(memberRepository.findByMemberId(memberId))
                .content(commentRe.content())
                .dateTime(DateTime.builder()
                        .inputDt(LocalDate.now())
                        .build())
                .build();

        commentReRepository.save(commentReEntity);
    }

    @Override

    public void update(UpdateRequestCommentModel commentRe, Long commentReId) {
        CommentRe commentReEntity = commentReRepository.findByCommentReId(commentReId);
        commentReEntity.setContent(commentRe.content());
        commentReEntity.getDateTime().setUpdateDt(LocalDate.now());
    }

    @Override
    public void delete(Long commentReId) {
        commentReRepository.deleteById(commentReId);
    }
}
