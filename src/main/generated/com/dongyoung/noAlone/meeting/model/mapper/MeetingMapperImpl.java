package com.dongyoung.noAlone.meeting.model.mapper;

import com.dongyoung.noAlone.accept.entity.Accept;
import com.dongyoung.noAlone.accept.entity.Status;
import com.dongyoung.noAlone.category.entity.Category;
import com.dongyoung.noAlone.category.model.FindResponseCategoryModel;
import com.dongyoung.noAlone.common.entity.DateTime;
import com.dongyoung.noAlone.mbti.entity.Mbti;
import com.dongyoung.noAlone.mbti.model.FindResponseMbtiWithMemberModel;
import com.dongyoung.noAlone.meeting.entity.Meeting;
import com.dongyoung.noAlone.meeting.model.FindResponseMeetingAndOwnerListModel;
import com.dongyoung.noAlone.meeting.model.FindResponseMeetingAppliListModel;
import com.dongyoung.noAlone.meeting.model.FindResponseMeetingViewModel;
import com.dongyoung.noAlone.member.Model.FindResponseMemberWithAcceptListModel;
import com.dongyoung.noAlone.member.Model.FindResponseMemberWithOwnerListModel;
import com.dongyoung.noAlone.member.Model.FindResponseMemberWithOwnerModel;
import com.dongyoung.noAlone.member.entity.Member;
import com.dongyoung.noAlone.owner.entity.Owner;
import com.dongyoung.noAlone.owner.model.FindResponseOwnerwithMeetingListModel;
import com.dongyoung.noAlone.owner.model.FindResponseOwnerwithMeetingModel;
import java.time.LocalDate;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-09T22:18:41+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class MeetingMapperImpl implements MeetingMapper {

    @Override
    public FindResponseMeetingAndOwnerListModel toMeetingListModel(Meeting meeting) {
        if ( meeting == null ) {
            return null;
        }

        FindResponseOwnerwithMeetingListModel ownerListModel = null;
        LocalDate inputDt = null;
        Long meetingId = null;
        String name = null;
        String content = null;
        String rule = null;
        String location = null;
        String question = null;

        ownerListModel = ownerToFindResponseOwnerwithMeetingListModel( meeting.getOwner() );
        inputDt = meetingDateTimeInputDt( meeting );
        meetingId = meeting.getMeetingId();
        name = meeting.getName();
        content = meeting.getContent();
        rule = meeting.getRule();
        location = meeting.getLocation();
        question = meeting.getQuestion();

        FindResponseMeetingAndOwnerListModel findResponseMeetingAndOwnerListModel = new FindResponseMeetingAndOwnerListModel( meetingId, name, content, rule, location, question, inputDt, ownerListModel );

        return findResponseMeetingAndOwnerListModel;
    }

    @Override
    public FindResponseMeetingViewModel toMeetingModel(Meeting meeting) {
        if ( meeting == null ) {
            return null;
        }

        FindResponseOwnerwithMeetingModel ownerWithMeetingModel = null;
        LocalDate inputDt = null;
        Long meetingId = null;
        String name = null;
        String content = null;
        String rule = null;
        String location = null;
        String question = null;
        FindResponseCategoryModel category = null;

        ownerWithMeetingModel = ownerToFindResponseOwnerwithMeetingModel( meeting.getOwner() );
        inputDt = meetingDateTimeInputDt( meeting );
        meetingId = meeting.getMeetingId();
        name = meeting.getName();
        content = meeting.getContent();
        rule = meeting.getRule();
        location = meeting.getLocation();
        question = meeting.getQuestion();
        category = categoryToFindResponseCategoryModel( meeting.getCategory() );

        FindResponseMeetingViewModel findResponseMeetingViewModel = new FindResponseMeetingViewModel( meetingId, name, content, rule, location, question, inputDt, ownerWithMeetingModel, category );

        return findResponseMeetingViewModel;
    }

    @Override
    public FindResponseMeetingAppliListModel toMeetingAppliListModel(Accept accept) {
        if ( accept == null ) {
            return null;
        }

        FindResponseMemberWithAcceptListModel memberWithAcceptListModel = null;
        LocalDate inputDt = null;
        Long acceptId = null;
        Status status = null;
        String aboutMe = null;
        String companionReason = null;

        memberWithAcceptListModel = memberToFindResponseMemberWithAcceptListModel( accept.getMember() );
        inputDt = acceptDateTimeInputDt( accept );
        acceptId = accept.getAcceptId();
        status = accept.getStatus();
        aboutMe = accept.getAboutMe();
        companionReason = accept.getCompanionReason();

        FindResponseMeetingAppliListModel findResponseMeetingAppliListModel = new FindResponseMeetingAppliListModel( acceptId, status, aboutMe, companionReason, inputDt, memberWithAcceptListModel );

        return findResponseMeetingAppliListModel;
    }

    protected FindResponseMemberWithOwnerListModel memberToFindResponseMemberWithOwnerListModel(Member member) {
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

        FindResponseMemberWithOwnerListModel findResponseMemberWithOwnerListModel = new FindResponseMemberWithOwnerListModel( memberId, id, password, nickname, name, email, gender, age, birthday, profileImage, birthyear, mobile );

        return findResponseMemberWithOwnerListModel;
    }

    protected FindResponseOwnerwithMeetingListModel ownerToFindResponseOwnerwithMeetingListModel(Owner owner) {
        if ( owner == null ) {
            return null;
        }

        FindResponseMemberWithOwnerListModel memberListModel = null;

        memberListModel = memberToFindResponseMemberWithOwnerListModel( owner.getMember() );

        FindResponseOwnerwithMeetingListModel findResponseOwnerwithMeetingListModel = new FindResponseOwnerwithMeetingListModel( memberListModel );

        return findResponseOwnerwithMeetingListModel;
    }

    private LocalDate meetingDateTimeInputDt(Meeting meeting) {
        if ( meeting == null ) {
            return null;
        }
        DateTime dateTime = meeting.getDateTime();
        if ( dateTime == null ) {
            return null;
        }
        LocalDate inputDt = dateTime.getInputDt();
        if ( inputDt == null ) {
            return null;
        }
        return inputDt;
    }

    protected FindResponseMemberWithOwnerModel memberToFindResponseMemberWithOwnerModel(Member member) {
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

        FindResponseMemberWithOwnerModel findResponseMemberWithOwnerModel = new FindResponseMemberWithOwnerModel( memberId, id, password, nickname, name, email, gender, age, birthday, profileImage, birthyear, mobile );

        return findResponseMemberWithOwnerModel;
    }

    protected FindResponseOwnerwithMeetingModel ownerToFindResponseOwnerwithMeetingModel(Owner owner) {
        if ( owner == null ) {
            return null;
        }

        FindResponseMemberWithOwnerModel memberModel = null;

        memberModel = memberToFindResponseMemberWithOwnerModel( owner.getMember() );

        FindResponseOwnerwithMeetingModel findResponseOwnerwithMeetingModel = new FindResponseOwnerwithMeetingModel( memberModel );

        return findResponseOwnerwithMeetingModel;
    }

    protected FindResponseCategoryModel categoryToFindResponseCategoryModel(Category category) {
        if ( category == null ) {
            return null;
        }

        Long categoryId = null;
        String name = null;
        String description = null;

        categoryId = category.getCategoryId();
        name = category.getName();
        description = category.getDescription();

        LocalDate inputDt = null;

        FindResponseCategoryModel findResponseCategoryModel = new FindResponseCategoryModel( categoryId, name, description, inputDt );

        return findResponseCategoryModel;
    }

    protected FindResponseMbtiWithMemberModel mbtiToFindResponseMbtiWithMemberModel(Mbti mbti) {
        if ( mbti == null ) {
            return null;
        }

        Long mbtiId = null;
        String name = null;
        String description = null;

        mbtiId = mbti.getMbtiId();
        name = mbti.getName();
        description = mbti.getDescription();

        FindResponseMbtiWithMemberModel findResponseMbtiWithMemberModel = new FindResponseMbtiWithMemberModel( mbtiId, name, description );

        return findResponseMbtiWithMemberModel;
    }

    protected FindResponseMemberWithAcceptListModel memberToFindResponseMemberWithAcceptListModel(Member member) {
        if ( member == null ) {
            return null;
        }

        FindResponseMbtiWithMemberModel mbtiWithMemberModel = null;
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

        mbtiWithMemberModel = mbtiToFindResponseMbtiWithMemberModel( member.getMbti() );
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

        FindResponseMemberWithAcceptListModel findResponseMemberWithAcceptListModel = new FindResponseMemberWithAcceptListModel( memberId, id, password, nickname, name, email, gender, age, birthday, profileImage, birthyear, mobile, mbtiWithMemberModel );

        return findResponseMemberWithAcceptListModel;
    }

    private LocalDate acceptDateTimeInputDt(Accept accept) {
        if ( accept == null ) {
            return null;
        }
        DateTime dateTime = accept.getDateTime();
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
