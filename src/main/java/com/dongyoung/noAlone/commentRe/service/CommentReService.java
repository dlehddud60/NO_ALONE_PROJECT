package com.dongyoung.noAlone.commentRe.service;

import com.dongyoung.noAlone.comment.model.UpdateRequestCommentModel;
import com.dongyoung.noAlone.commentRe.model.FindResponseCommentReListModel;
import com.dongyoung.noAlone.commentRe.model.InsertRequestCommentReModel;

import java.util.List;

public interface CommentReService {
    List<FindResponseCommentReListModel> findAll(Long commentId);

    void save(InsertRequestCommentReModel commentRe, Long memberId);

    void update(UpdateRequestCommentModel comment, Long commentReId);

    void delete(Long commentReId);
}
