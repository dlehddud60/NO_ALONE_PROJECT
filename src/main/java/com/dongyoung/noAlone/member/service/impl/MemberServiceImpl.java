package com.dongyoung.noAlone.member.service.impl;

import com.dongyoung.noAlone.common.entity.DateTime;
import com.dongyoung.noAlone.mbti.repository.MbtiRepository;
import com.dongyoung.noAlone.member.Model.FindRequestLoginModel;
import com.dongyoung.noAlone.member.Model.FindRequestRegisterMemberModel;
import com.dongyoung.noAlone.member.Model.FindRequestMemberUpdateModel;
import com.dongyoung.noAlone.member.Model.FindResponseMemberWithMbtiModel;
import com.dongyoung.noAlone.member.Model.mapper.MemberMapper;
import com.dongyoung.noAlone.member.entity.Member;
import com.dongyoung.noAlone.member.entity.Role;
import com.dongyoung.noAlone.member.repository.MemberRepository;
import com.dongyoung.noAlone.member.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Log4j2
@Service
@Transactional
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final MemberMapper memberMapper;
    private final MbtiRepository mbtiRepository;

    @Override
    public void save(FindRequestRegisterMemberModel findRequestRegisterMemberModel) {

        String encode = passwordEncoder.encode(findRequestRegisterMemberModel.password());

        Member memberEntity = Member.builder()
                .id(findRequestRegisterMemberModel.id())
                .password(encode)
                .nickname(findRequestRegisterMemberModel.nickname())
                .name(findRequestRegisterMemberModel.name())
                .email(findRequestRegisterMemberModel.email())
                .gender(findRequestRegisterMemberModel.gender())
                .age(findRequestRegisterMemberModel.age())
                .birthday(findRequestRegisterMemberModel.birthday())
                .birthyear(findRequestRegisterMemberModel.birthyear())
                .mobile(findRequestRegisterMemberModel.mobile())
                .role(Role.ADMIN)
                .dateTime(DateTime.builder()
                        .inputDt(LocalDate.now())
                        .build())
                .build();
        memberRepository.save(memberEntity);
    }

    @Override
    public String login(FindRequestLoginModel loginModel, HttpSession session) {
        Member member = memberRepository.findMemberById(loginModel.id());
        if (member != null && passwordEncoder.matches(loginModel.password(), member.getPassword())) {
            session.setAttribute("member", member);
        }
        return "redirect:/member/update";
    }

    @Override
    public FindResponseMemberWithMbtiModel find(String id) {
        FindResponseMemberWithMbtiModel memberDTO = memberMapper.toMemberWithMbti(memberRepository.findMemberById(id));
        return memberDTO;
    }

    @Override
    public void update(FindRequestMemberUpdateModel memberUpdateModel) {
        Member member = memberRepository.findMemberById(memberUpdateModel.id());
        member.setNickname(memberUpdateModel.nickname());
        member.setName(memberUpdateModel.name());
        member.setEmail(memberUpdateModel.email());
        member.setGender(memberUpdateModel.gender());
        member.setAge(memberUpdateModel.age());
        member.setBirthyear(memberUpdateModel.birthyear());
        member.setBirthday(memberUpdateModel.birthday());
        member.setMobile(memberUpdateModel.mobile());
        member.setMbti(mbtiRepository.findByName(memberUpdateModel.mbtiName()));
    }
}
