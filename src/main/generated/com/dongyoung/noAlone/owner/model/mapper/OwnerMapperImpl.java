package com.dongyoung.noAlone.owner.model.mapper;

import com.dongyoung.noAlone.meeting.entity.Meeting;
import com.dongyoung.noAlone.meeting.model.FindResponseMeetingWithOwnerModel;
import com.dongyoung.noAlone.member.Model.FindResponseMemberWithOwnerModel;
import com.dongyoung.noAlone.member.entity.Member;
import com.dongyoung.noAlone.owner.entity.Owner;
import com.dongyoung.noAlone.owner.model.FindResponseOwnerModel;
import java.time.LocalDate;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-10T21:00:00+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class OwnerMapperImpl implements OwnerMapper {

    @Override
    public FindResponseOwnerModel toOwnerModel(Owner owner) {
        if ( owner == null ) {
            return null;
        }

        FindResponseMemberWithOwnerModel memberModel = null;
        FindResponseMeetingWithOwnerModel meetingModel = null;
        Long ownerId = null;

        memberModel = memberToFindResponseMemberWithOwnerModel( owner.getMember() );
        meetingModel = meetingToFindResponseMeetingWithOwnerModel( owner.getMeeting() );
        ownerId = owner.getOwnerId();

        FindResponseOwnerModel findResponseOwnerModel = new FindResponseOwnerModel( ownerId, memberModel, meetingModel );

        return findResponseOwnerModel;
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

    protected FindResponseMeetingWithOwnerModel meetingToFindResponseMeetingWithOwnerModel(Meeting meeting) {
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

        FindResponseMeetingWithOwnerModel findResponseMeetingWithOwnerModel = new FindResponseMeetingWithOwnerModel( meetingId, name, content, rule, location, question, inputDt );

        return findResponseMeetingWithOwnerModel;
    }
}
