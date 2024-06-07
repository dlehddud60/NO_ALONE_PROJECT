package com.dongyoung.noAlone.board.model.mapper;

import com.dongyoung.noAlone.board.entity.Board;
import com.dongyoung.noAlone.board.model.FindResponseBoardListModel;
import com.dongyoung.noAlone.board.model.FindResponseBoardModel;
import com.dongyoung.noAlone.board.model.FindResponseBoardWithMemberListModel;
import com.dongyoung.noAlone.board.model.FindResponseBoardWithMemberModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDateTime;

@Mapper(componentModel = "spring")
public interface BoardMapper {

    @Mapping(source = "member", target = "member")
    @Mapping(source = "dateTime.inputDt", target = "inputDt")
    FindResponseBoardWithMemberListModel toBoardListModel(Board board);

    @Mapping(source = "member", target = "member")
    @Mapping(source = "dateTime.inputDt", target = "inputDt")
    FindResponseBoardWithMemberModel toBoardFindModel(Board board);

}
