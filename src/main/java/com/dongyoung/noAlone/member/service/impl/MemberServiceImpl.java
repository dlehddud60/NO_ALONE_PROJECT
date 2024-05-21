package com.dongyoung.noAlone.member.service.impl;

import com.dongyoung.noAlone.common.entity.DateTime;
import com.dongyoung.noAlone.member.Model.FindRequestLoginModel;
import com.dongyoung.noAlone.member.Model.FindRequestMemberModel;
import com.dongyoung.noAlone.member.entity.Member;
import com.dongyoung.noAlone.member.entity.Role;
import com.dongyoung.noAlone.member.repository.MemberRepository;
import com.dongyoung.noAlone.member.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Log4j2
@Service
@Transactional
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void save(FindRequestMemberModel findRequestMemberModel) {

        String encode = passwordEncoder.encode(findRequestMemberModel.password());

        Member memberEntity = Member.builder()
                .id(findRequestMemberModel.id())
                .password(encode)
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

    @Override
    public String login(FindRequestLoginModel loginModel, HttpSession session) {
        log.info("============loginModel================={}",loginModel);
        Member member = memberRepository.findMemberById(loginModel.id());
        log.info("============member================={}",member);
        if(member != null && passwordEncoder.matches(loginModel.password(), member.getPassword())){
            session.setAttribute("member",member);
        }
        return "redirect:/member/";
    }
}
