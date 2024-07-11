package com.dongyoung.noAlone.commentRe.model.mapper;

import com.dongyoung.noAlone.board.entity.Board;
import com.dongyoung.noAlone.board.model.FindResponseBoardCommentListModel;
import com.dongyoung.noAlone.comment.entity.Comment;
import com.dongyoung.noAlone.comment.model.FindResponseCommentListModel;
import com.dongyoung.noAlone.commentRe.entity.CommentRe;
import com.dongyoung.noAlone.commentRe.model.FindResponseCommentReListModel;
import com.dongyoung.noAlone.member.Model.FindResponseMemberWithCommentListModel;
import com.dongyoung.noAlone.member.entity.Member;
import java.time.LocalDate;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-11T10:51:19+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class CommentReMapperImpl implements CommentReMapper {

    @Override
    public FindResponseCommentReListModel toCommentReListModel(CommentRe comment) {
        if ( comment == null ) {
            return null;
        }

        FindResponseCommentListModel comment1 = null;
        FindResponseMemberWithCommentListModel member = null;
        Long commentReId = null;
        String content = null;
        LocalDate inputDt = null;

        comment1 = commentToFindResponseCommentListModel( comment.getComment() );
        member = memberToFindResponseMemberWithCommentListModel( comment.getMember() );
        commentReId = comment.getCommentReId();
        content = comment.getContent();
        inputDt = comment.getInputDt();

        FindResponseCommentReListModel findResponseCommentReListModel = new FindResponseCommentReListModel( commentReId, content, inputDt, comment1, member );

        return findResponseCommentReListModel;
    }

    protected FindResponseBoardCommentListModel boardToFindResponseBoardCommentListModel(Board board) {
        if ( board == null ) {
            return null;
        }

        Long boardId = null;
        String title = null;
        String content = null;
        Integer views = null;
        LocalDate inputDt = null;

        boardId = board.getBoardId();
        title = board.getTitle();
        content = board.getContent();
        views = board.getViews();
        inputDt = board.getInputDt();

        FindResponseCommentListModel comment = null;

        FindResponseBoardCommentListModel findResponseBoardCommentListModel = new FindResponseBoardCommentListModel( boardId, title, content, views, inputDt, comment );

        return findResponseBoardCommentListModel;
    }

    protected FindResponseMemberWithCommentListModel memberToFindResponseMemberWithCommentListModel(Member member) {
        if ( member == null ) {
            return null;
        }

        Long memberId = null;
        String id = null;
        String password = null;
        String nickname = null;
        String name = null;
        String email = null;
        String gender = null;
        int age = 0;
        String birthday = null;
        String profileImage = null;
        String birthyear = null;
        String mobile = null;

        memberId = member.getMemberId();
        id = member.getId();
        password = member.getPassword();
        nickname = member.getNickname();
        name = member.getName();
        email = member.getEmail();
        gender = member.getGender();
        age = member.getAge();
        birthday = member.getBirthday();
        profileImage = member.getProfileImage();
        birthyear = member.getBirthyear();
        mobile = member.getMobile();

        FindResponseMemberWithCommentListModel findResponseMemberWithCommentListModel = new FindResponseMemberWithCommentListModel( memberId, id, password, nickname, name, email, gender, age, birthday, profileImage, birthyear, mobile );

        return findResponseMemberWithCommentListModel;
    }

    protected FindResponseCommentListModel commentToFindResponseCommentListModel(Comment comment) {
        if ( comment == null ) {
            return null;
        }

        Long commentId = null;
        String content = null;
        LocalDate inputDt = null;
        FindResponseBoardCommentListModel board = null;
        FindResponseMemberWithCommentListModel member = null;

        commentId = comment.getCommentId();
        content = comment.getContent();
        inputDt = comment.getInputDt();
        board = boardToFindResponseBoardCommentListModel( comment.getBoard() );
        member = memberToFindResponseMemberWithCommentListModel( comment.getMember() );

        FindResponseCommentListModel findResponseCommentListModel = new FindResponseCommentListModel( commentId, content, inputDt, board, member );

        return findResponseCommentListModel;
    }
}
