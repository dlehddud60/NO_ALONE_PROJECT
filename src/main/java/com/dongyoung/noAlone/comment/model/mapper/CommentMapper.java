package com.dongyoung.noAlone.comment.model.mapper;

import com.dongyoung.noAlone.board.model.FindResponseBoardCommentListModel;
import com.dongyoung.noAlone.comment.entity.Comment;
import com.dongyoung.noAlone.comment.model.FindResponseCommentListModel;
import com.dongyoung.noAlone.commentRe.entity.CommentRe;
import com.dongyoung.noAlone.commentRe.model.FindResponseCommentReListModel;
import com.dongyoung.noAlone.member.Model.FindResponseMemberWithCommentListModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentMapper {


    @Mapping(source = "board", target = "board")
    @Mapping(source = "member", target = "member")
    @Mapping(source = "dateTime.inputDt", target = "inputDt")
    FindResponseCommentListModel toCommentListModel(Comment comment);
}
