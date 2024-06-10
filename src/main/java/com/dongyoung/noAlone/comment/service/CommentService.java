package com.dongyoung.noAlone.comment.service;

import com.dongyoung.noAlone.comment.model.FindResponseCommentListModel;
import com.dongyoung.noAlone.comment.model.InsertRequestCommentModel;
import com.dongyoung.noAlone.comment.model.UpdateRequestCommentModel;

import java.util.List;

public interface CommentService {
    List<FindResponseCommentListModel> findAll(Long boardId);

    void save(InsertRequestCommentModel comment,Long memberId);

    void update(UpdateRequestCommentModel comment, Long commentId);

    void delete(Long commentId);
}
