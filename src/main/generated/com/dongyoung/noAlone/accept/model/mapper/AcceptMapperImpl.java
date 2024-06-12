package com.dongyoung.noAlone.accept.model.mapper;

import com.dongyoung.noAlone.accept.entity.Accept;
import com.dongyoung.noAlone.accept.entity.Status;
import com.dongyoung.noAlone.accept.model.FindResponseAcceptModel;
import com.dongyoung.noAlone.common.entity.DateTime;
import com.dongyoung.noAlone.meeting.entity.Meeting;
import com.dongyoung.noAlone.meeting.model.FindResponseMeetingAndAcceptModel;
import com.dongyoung.noAlone.member.Model.FindResponseLoginMemberModel;
import com.dongyoung.noAlone.member.entity.Member;
import com.dongyoung.noAlone.member.entity.Role;
import java.time.LocalDate;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-10T21:00:00+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class AcceptMapperImpl implements AcceptMapper {

    @Override
    public FindResponseAcceptModel toAcceptModel(Accept accept) {
        if ( accept == null ) {
            return null;
        }

        FindResponseLoginMemberModel member = null;
        FindResponseMeetingAndAcceptModel meeting = null;
        Long acceptId = null;
        Status status = null;
        String aboutMe = null;
        String companionReason = null;
        DateTime dateTime = null;

        member = memberToFindResponseLoginMemberModel( accept.getMember() );
        meeting = meetingToFindResponseMeetingAndAcceptModel( accept.getMeeting() );
        acceptId = accept.getAcceptId();
        status = accept.getStatus();
        aboutMe = accept.getAboutMe();
        companionReason = accept.getCompanionReason();
        dateTime = accept.getDateTime();

        FindResponseAcceptModel findResponseAcceptModel = new FindResponseAcceptModel( acceptId, status, aboutMe, companionReason, dateTime, member, meeting );

        return findResponseAcceptModel;
    }

    protected FindResponseLoginMemberModel memberToFindResponseLoginMemberModel(Member member) {
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
        Role role = null;

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
        role = member.getRole();

        FindResponseLoginMemberModel findResponseLoginMemberModel = new FindResponseLoginMemberModel( memberId, id, password, nickname, name, email, gender, age, birthday, profileImage, birthyear, mobile, role );

        return findResponseLoginMemberModel;
    }

    protected FindResponseMeetingAndAcceptModel meetingToFindResponseMeetingAndAcceptModel(Meeting meeting) {
        if ( meeting == null ) {
            return null;
        }

        Long meetingId = null;
        String name = null;
        String content = null;
        String rule = null;
        String location = null;
        String question = null;

        meetingId = meeting.getMeetingId();
        name = meeting.getName();
        content = meeting.getContent();
        rule = meeting.getRule();
        location = meeting.getLocation();
        question = meeting.getQuestion();

        LocalDate inputDt = null;

        FindResponseMeetingAndAcceptModel findResponseMeetingAndAcceptModel = new FindResponseMeetingAndAcceptModel( meetingId, name, content, rule, location, question, inputDt );

        return findResponseMeetingAndAcceptModel;
    }
}
