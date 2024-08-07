package com.dongyoung.noAlone.board.model.mapper;

import com.dongyoung.noAlone.board.entity.Board;
import com.dongyoung.noAlone.board.model.FindResponseBoardListModel;
import com.dongyoung.noAlone.board.model.FindResponseBoardModel;
import com.dongyoung.noAlone.category.entity.Category;
import com.dongyoung.noAlone.category.model.FindResponseCategoryListModel;
import com.dongyoung.noAlone.category.model.FindResponseCategoryModel;
import com.dongyoung.noAlone.member.Model.FindResponseMemberWithMemberListModel;
import com.dongyoung.noAlone.member.Model.FindResponseMemberWithMemberModel;
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
public class BoardMapperImpl implements BoardMapper {

    @Override
    public FindResponseBoardListModel toBoardResListModel(Board board) {
        if ( board == null ) {
            return null;
        }

        FindResponseCategoryListModel category = null;
        FindResponseMemberWithMemberListModel member = null;
        Long boardId = null;
        String title = null;
        String content = null;
        Integer views = null;
        LocalDate inputDt = null;

        category = categoryToFindResponseCategoryListModel( board.getCategory() );
        member = memberToFindResponseMemberWithMemberListModel( board.getMember() );
        boardId = board.getBoardId();
        title = board.getTitle();
        content = board.getContent();
        views = board.getViews();
        inputDt = board.getInputDt();

        FindResponseBoardListModel findResponseBoardListModel = new FindResponseBoardListModel( boardId, title, content, views, inputDt, member, category );

        return findResponseBoardListModel;
    }

    @Override
    public FindResponseBoardModel toBoardResFindModel(Board board) {
        if ( board == null ) {
            return null;
        }

        FindResponseCategoryModel category = null;
        FindResponseMemberWithMemberModel member = null;
        Long boardId = null;
        String title = null;
        String content = null;
        Integer views = null;
        LocalDate inputDt = null;

        category = categoryToFindResponseCategoryModel( board.getCategory() );
        member = memberToFindResponseMemberWithMemberModel( board.getMember() );
        boardId = board.getBoardId();
        title = board.getTitle();
        content = board.getContent();
        views = board.getViews();
        inputDt = board.getInputDt();

        FindResponseBoardModel findResponseBoardModel = new FindResponseBoardModel( boardId, title, content, views, inputDt, member, category );

        return findResponseBoardModel;
    }

    protected FindResponseCategoryListModel categoryToFindResponseCategoryListModel(Category category) {
        if ( category == null ) {
            return null;
        }

        Long categoryId = null;
        String name = null;
        String description = null;
        LocalDate inputDt = null;

        categoryId = category.getCategoryId();
        name = category.getName();
        description = category.getDescription();
        inputDt = category.getInputDt();

        FindResponseCategoryListModel findResponseCategoryListModel = new FindResponseCategoryListModel( categoryId, name, description, inputDt );

        return findResponseCategoryListModel;
    }

    protected FindResponseMemberWithMemberListModel memberToFindResponseMemberWithMemberListModel(Member member) {
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

        FindResponseMemberWithMemberListModel findResponseMemberWithMemberListModel = new FindResponseMemberWithMemberListModel( memberId, id, password, nickname, name, email, gender, age, birthday, profileImage, birthyear, mobile );

        return findResponseMemberWithMemberListModel;
    }

    protected FindResponseCategoryModel categoryToFindResponseCategoryModel(Category category) {
        if ( category == null ) {
            return null;
        }

        Long categoryId = null;
        String name = null;
        String description = null;
        LocalDate inputDt = null;

        categoryId = category.getCategoryId();
        name = category.getName();
        description = category.getDescription();
        inputDt = category.getInputDt();

        FindResponseCategoryModel findResponseCategoryModel = new FindResponseCategoryModel( categoryId, name, description, inputDt );

        return findResponseCategoryModel;
    }

    protected FindResponseMemberWithMemberModel memberToFindResponseMemberWithMemberModel(Member member) {
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

        FindResponseMemberWithMemberModel findResponseMemberWithMemberModel = new FindResponseMemberWithMemberModel( memberId, id, password, nickname, name, email, gender, age, birthday, profileImage, birthyear, mobile );

        return findResponseMemberWithMemberModel;
    }
}
