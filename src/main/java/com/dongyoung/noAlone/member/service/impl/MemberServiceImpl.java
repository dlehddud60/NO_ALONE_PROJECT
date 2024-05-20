package com.dongyoung.noAlone.member.service.impl;

import com.dongyoung.noAlone.common.entity.DateTime;
import com.dongyoung.noAlone.member.Model.FindRequestMemberModel;
import com.dongyoung.noAlone.member.entity.Member;
import com.dongyoung.noAlone.member.entity.Role;
import com.dongyoung.noAlone.member.repository.MemberRepository;
import com.dongyoung.noAlone.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void save(FindRequestMemberModel findRequestMemberModel) {

        String encode = passwordEncoder.encode(findRequestMemberModel.pw());

        Member memberEntity = Member.builder()
                .id(findRequestMemberModel.id())
                .pw(encode)
                .nickname(findRequestMemberModel.nickname())
                .name(findRequestMemberModel.name())
                .email(findRequestMemberModel.email())
                .gender(findRequestMemberModel.gender())
                .age(findRequestMemberModel.age())
                .birthday(findRequestMemberModel.birthday())
                .birthyear(findRequestMemberModel.birthyear())
                .mobile(findRequestMemberModel.mobile())
                .role(Role.ADMIN)
                .dateTime(DateTime.builder()
                        .inputDt(LocalDate.now())
                        .build())
                .build();
        memberRepository.save(memberEntity);
    }
}
