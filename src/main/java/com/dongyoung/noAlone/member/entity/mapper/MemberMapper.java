package com.dongyoung.noAlone.member.entity.mapper;

import com.dongyoung.noAlone.member.Model.FindResponseLoginMemberModel;
import com.dongyoung.noAlone.member.entity.Member;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MemberMapper {
    FindResponseLoginMemberModel toLoginModel(Member member);
}
