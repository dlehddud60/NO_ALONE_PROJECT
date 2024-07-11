package com.dongyoung.noAlone.like.repository;

import com.dongyoung.noAlone.like.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LikeRepository extends JpaRepository<Like, Long> {
    Integer countByComment_CommentId(Long commentId);
    Integer countByCommentRe_CommentReId(Long commentReId);
    void deleteByCommentCommentIdAndMemberMemberId(Long commentId, Long memberId);
    void deleteByCommentReCommentReIdAndMemberMemberId(Long commentReId, Long memberId);
    Optional<Like> findByCommentCommentIdAndMemberMemberId(Long commentId, Long memberId);
    Optional<Like> findByCommentReCommentReIdAndMemberMemberId(Long commentReId, Long memberId);
}
//findByMeeting_MeetingIdAndMember_MemberId