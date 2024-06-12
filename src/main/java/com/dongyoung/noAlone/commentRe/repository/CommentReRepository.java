package com.dongyoung.noAlone.commentRe.repository;

import com.dongyoung.noAlone.comment.entity.Comment;
import com.dongyoung.noAlone.commentRe.entity.CommentRe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentReRepository extends JpaRepository<CommentRe, Long> {
    List<CommentRe> findAllByComment_CommentId(Long commentId);
    CommentRe findByCommentReId(Long commentId);

}
