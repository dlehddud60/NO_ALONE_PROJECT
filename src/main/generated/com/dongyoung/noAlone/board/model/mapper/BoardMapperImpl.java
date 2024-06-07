package com.dongyoung.noAlone.board.model.mapper;

import com.dongyoung.noAlone.board.entity.Board;
import com.dongyoung.noAlone.board.model.FindResponseBoardListModel;
import com.dongyoung.noAlone.board.model.FindResponseBoardModel;
import com.dongyoung.noAlone.common.entity.DateTime;
import java.time.LocalDate;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-07T17:22:04+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class BoardMapperImpl implements BoardMapper {

    @Override
    public FindResponseBoardListModel toBoardListModel(Board board) {
        if ( board == null ) {
            return null;
        }

        LocalDate inputDt = null;
        Long boardId = null;
        String title = null;
        String content = null;
        Long views = null;

        inputDt = boardDateTimeInputDt( board );
        boardId = board.getBoardId();
        title = board.getTitle();
        content = board.getContent();
        views = board.getViews();

        FindResponseBoardListModel findResponseBoardListModel = new FindResponseBoardListModel( boardId, title, content, views, inputDt );

        return findResponseBoardListModel;
    }

    @Override
    public FindResponseBoardModel toBoardFindModel(Board board) {
        if ( board == null ) {
            return null;
        }

        LocalDate inputDt = null;
        Long boardId = null;
        String title = null;
        String content = null;

        inputDt = boardDateTimeInputDt( board );
        boardId = board.getBoardId();
        title = board.getTitle();
        content = board.getContent();

        FindResponseBoardModel findResponseBoardModel = new FindResponseBoardModel( boardId, title, content, inputDt );

        return findResponseBoardModel;
    }

    private LocalDate boardDateTimeInputDt(Board board) {
        if ( board == null ) {
            return null;
        }
        DateTime dateTime = board.getDateTime();
        if ( dateTime == null ) {
            return null;
        }
        LocalDate inputDt = dateTime.getInputDt();
        if ( inputDt == null ) {
            return null;
        }
        return inputDt;
    }
}
