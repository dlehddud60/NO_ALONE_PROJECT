package com.dongyoung.noAlone.like.service.impl;

import com.dongyoung.noAlone.comment.entity.Comment;
import com.dongyoung.noAlone.comment.repository.CommentRepository;
import com.dongyoung.noAlone.commentRe.entity.CommentRe;
import com.dongyoung.noAlone.commentRe.repository.CommentReRepository;
import com.dongyoung.noAlone.like.entity.Like;
import com.dongyoung.noAlone.like.entity.LikeDivision;
import com.dongyoung.noAlone.like.model.CountRequestLikeModel;
import com.dongyoung.noAlone.like.model.DeleteRequestLikeModel;
import com.dongyoung.noAlone.like.model.FindRequestLikeModel;
import com.dongyoung.noAlone.like.model.InsertRequestLikeModel;
import com.dongyoung.noAlone.like.repository.LikeRepository;
import com.dongyoung.noAlone.like.service.LikeService;
import com.dongyoung.noAlone.member.entity.Member;
import com.dongyoung.noAlone.member.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
@Log4j2
public class LikeServiceImpl implements LikeService {
    private final LikeRepository likeRepository;
    private final MemberRepository memberRepository;
    private final CommentRepository commentrepository;
    private final CommentReRepository commentReRepository;

    @Override
    public void save(InsertRequestLikeModel likeRequest, Long memberId) {

        log.info("============likeRequest========={}", likeRequest);
        Member member = memberRepository.findByMemberId(memberId);
        if (likeRequest.likeDivision().equals(LikeDivision.COMMENT)) {
            Comment comment = commentrepository.findByCommentId(likeRequest.commentId());
            Like like = Like.builder()
                    .comment(comment)
                    .member(member)
                    .build();
            likeRepository.save(like);
        } else if (likeRequest.likeDivision().equals(LikeDivision.COMMENT_RE)) {
            CommentRe byCommentReId = commentReRepository.findByCommentReId(likeRequest.commentReId());
            Like like = Like.builder()
                    .commentRe(byCommentReId)
                    .member(member)
                    .build();
            likeRepository.save(like);
        }

    }

    @Override
    public Boolean myLike(FindRequestLikeModel like, Long memberId) {
        if (like.likeDivision().equals(LikeDivision.COMMENT)) {
            Optional<Like> likeOptional = likeRepository.findByCommentCommentIdAndMemberMemberId(like.commentId(), memberId);
            return likeOptional.isPresent();

        } else if (like.likeDivision().equals(LikeDivision.COMMENT_RE)) {
            Optional<Like> likeOptional = likeRepository.findByCommentReCommentReIdAndMemberMemberId(like.commentReId(), memberId);
            return likeOptional.isPresent();
        }
        return false;
    }

    @Override
    public Integer count(CountRequestLikeModel countRequestLikeModel) {
        if (countRequestLikeModel.likeDivision().equals(LikeDivision.COMMENT)) {
            return likeRepository.countByComment_CommentId(countRequestLikeModel.commentId());
        } else if (countRequestLikeModel.likeDivision().equals(LikeDivision.COMMENT_RE)) {
            return likeRepository.countByCommentRe_CommentReId(countRequestLikeModel.commentReId());
        }
        return 0;
    }

    @Override
    public void delete(DeleteRequestLikeModel likeRequest, Long memberId) {
        Member member = memberRepository.findByMemberId(memberId);
        if (likeRequest.likeDivision().equals(LikeDivision.COMMENT)) {
            likeRepository.deleteByCommentCommentIdAndMemberMemberId(likeRequest.commentId(), member.getMemberId());

        } else if (likeRequest.likeDivision().equals(LikeDivision.COMMENT_RE)) {
            likeRepository.deleteByCommentReCommentReIdAndMemberMemberId(likeRequest.commentReId(), member.getMemberId());
        }
    }
}
