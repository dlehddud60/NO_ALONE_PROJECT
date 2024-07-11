package com.dongyoung.noAlone.member.Model.mapper;

import com.dongyoung.noAlone.mbti.entity.Mbti;
import com.dongyoung.noAlone.mbti.model.FindResponseMbtiWithMemberModel;
import com.dongyoung.noAlone.member.Model.FindResponseMemberWithMbtiModel;
import com.dongyoung.noAlone.member.entity.Member;
import java.time.LocalDate;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-11T10:51:18+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class MemberMapperImpl implements MemberMapper {

    @Override
    public FindResponseMemberWithMbtiModel toMemberWithMbti(Member member) {
        if ( member == null ) {
            return null;
        }

        FindResponseMbtiWithMemberModel mbtiWithMemberModel = null;
        String id = null;
        String password = null;
        String nickname = null;
        String name = null;
        String email = null;
        String gender = null;
        Integer age = null;
        String birthday = null;
        String birthyear = null;
        String mobile = null;
        LocalDate updateDt = null;

        mbtiWithMemberModel = mbtiToFindResponseMbtiWithMemberModel( member.getMbti() );
        id = member.getId();
        password = member.getPassword();
        nickname = member.getNickname();
        name = member.getName();
        email = member.getEmail();
        gender = member.getGender();
        age = member.getAge();
        birthday = member.getBirthday();
        birthyear = member.getBirthyear();
        mobile = member.getMobile();
        updateDt = member.getUpdateDt();

        FindResponseMemberWithMbtiModel findResponseMemberWithMbtiModel = new FindResponseMemberWithMbtiModel( id, password, nickname, name, email, gender, age, birthday, birthyear, mobile, updateDt, mbtiWithMemberModel );

        return findResponseMemberWithMbtiModel;
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
}
