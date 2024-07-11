package com.dongyoung.noAlone.board.model.mapper;

import com.dongyoung.noAlone.board.entity.Board;
import com.dongyoung.noAlone.board.model.FindResponseBoardListModel;
import com.dongyoung.noAlone.board.model.FindResponseBoardModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BoardMapper {


    @Mapping(source = "category", target = "category")
    @Mapping(source = "member", target = "member")
    FindResponseBoardListModel toBoardResListModel(Board board);

    @Mapping(source = "category", target = "category")
    @Mapping(source = "member", target = "member")
    FindResponseBoardModel toBoardResFindModel(Board board);

}
