package com.dongyoung.noAlone.comment.model.mapper;

import com.dongyoung.noAlone.comment.entity.Comment;
import com.dongyoung.noAlone.comment.model.FindResponseCommentListModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    @Mapping(source = "board", target = "board")
    @Mapping(source = "member", target = "member")
    @Mapping(source = "dateTime.inputDt", target = "inputDt")
    FindResponseCommentListModel toCommentListModel(Comment comment);
}
