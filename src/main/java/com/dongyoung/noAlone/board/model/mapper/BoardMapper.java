package com.dongyoung.noAlone.board.model.mapper;

import com.dongyoung.noAlone.board.entity.Board;
import com.dongyoung.noAlone.board.model.FindResponseBoardListModel;
import com.dongyoung.noAlone.board.model.FindResponseBoardModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDateTime;

@Mapper(componentModel = "spring")
public interface BoardMapper {

    @Mapping(source = "dateTime.inputDt", target = "inputDt")
    FindResponseBoardListModel toBoardListModel(Board board);

    @Mapping(source = "dateTime.inputDt", target = "inputDt")
    FindResponseBoardModel toBoardFindModel(Board board);

}
