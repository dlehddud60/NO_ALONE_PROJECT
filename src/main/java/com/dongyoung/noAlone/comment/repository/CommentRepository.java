package com.dongyoung.noAlone.comment.repository;

import com.dongyoung.noAlone.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    Comment findByCommentId(Long commentId);
    List<Comment> findAllByBoard_BoardId(Long boardId);
}
