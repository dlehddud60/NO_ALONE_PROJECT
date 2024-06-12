package com.dongyoung.noAlone.commentRe.model.mapper;

import com.dongyoung.noAlone.comment.entity.Comment;
import com.dongyoung.noAlone.commentRe.entity.CommentRe;
import com.dongyoung.noAlone.commentRe.model.FindResponseCommentReListModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CommentReMapper {

    @Mapping(source = "comment", target = "comment")
    @Mapping(source = "member", target = "member")
    @Mapping(source = "dateTime.inputDt", target = "inputDt")
    FindResponseCommentReListModel toCommentReListModel(CommentRe comment);
}
