package com.dongyoung.noAlone.member.service.impl;

import com.dongyoung.noAlone.mbti.repository.MbtiRepository;
import com.dongyoung.noAlone.member.Model.FindResponseMemberWithMbtiModel;
import com.dongyoung.noAlone.member.Model.InsertRequestMemberModel;
import com.dongyoung.noAlone.member.Model.LoginRequestModel;
import com.dongyoung.noAlone.member.Model.UpdateRequestMemberModel;
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

import java.util.Optional;

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
    public void save(InsertRequestMemberModel insertRequestMemberModel, HttpSession session) {

        String encode = passwordEncoder.encode(insertRequestMemberModel.password());

        Member memberEntity = Member.builder()
                .id(insertRequestMemberModel.id())
                .password(encode)
                .nickname(insertRequestMemberModel.nickname())
                .name(insertRequestMemberModel.name())
                .email(insertRequestMemberModel.email())
                .gender(insertRequestMemberModel.gender())
                .age(insertRequestMemberModel.age())
                .birthday(insertRequestMemberModel.birthday())
                .birthyear(insertRequestMemberModel.birthyear())
                .mobile(insertRequestMemberModel.mobile())
                .role(Role.ADMIN)
                .build();
        memberRepository.save(memberEntity);
        session.setAttribute("member", memberEntity);

    }

    @Override
    public String login(LoginRequestModel loginModel, HttpSession session) {
        Member member = memberRepository.findMemberById(loginModel.id());
        if (member != null && passwordEncoder.matches(loginModel.password(), member.getPassword())) {
            session.setAttribute("member", member);
        }
        return "redirect:/board/list";
    }

    @Override
    public FindResponseMemberWithMbtiModel find(String id) {
        FindResponseMemberWithMbtiModel memberDTO = memberMapper.toMemberWithMbti(memberRepository.findMemberById(id));
        return memberDTO;
    }

    @Override
    public void update(UpdateRequestMemberModel memberUpdateModel, HttpSession session) {
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
        session.setAttribute("member", member);
    }

    @Override
    public boolean verifyExistEmail(String email) {
        Optional<Member> member = memberRepository.findByEmail(email);
        log.info("========isPresent======={}", member.isPresent());
        return member.isPresent();
    }
}
