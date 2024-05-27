package com.dongyoung.noAlone.member.Model.mapper;

import com.dongyoung.noAlone.member.Model.FindRequestRegisterMemberModel;
import com.dongyoung.noAlone.member.Model.FindResponseMemberWithMbtiModel;
import com.dongyoung.noAlone.member.entity.Member;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MemberMapper {
    @Mapping(source = "dateTime.updateDt",target = "updateDt")
    @Mapping(source = "mbti",target = "mbtiWithMemberModel")
    FindResponseMemberWithMbtiModel toMemberWithMbti(Member member);
}
