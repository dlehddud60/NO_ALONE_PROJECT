package com.dongyoung.noAlone.mbti.service.impl;

import com.dongyoung.noAlone.common.entity.DateTime;
import com.dongyoung.noAlone.mbti.entity.Mbti;
import com.dongyoung.noAlone.mbti.model.FindRequestMbtiDataModel;
import com.dongyoung.noAlone.mbti.repository.MbtiRepository;
import com.dongyoung.noAlone.mbti.service.MbtiService;
import com.dongyoung.noAlone.member.Model.FindResponseLoginMemberModel;
import com.dongyoung.noAlone.member.entity.Member;
import com.dongyoung.noAlone.member.entity.mapper.MemberMapper;
import com.dongyoung.noAlone.member.repository.MemberRepository;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Log4j2
@Service
@Transactional
@RequiredArgsConstructor
public class MbtiServiceImpl implements MbtiService {
    private final MbtiRepository mbtiRepository;
    private final MemberMapper memberMapper;
    private final MemberRepository memberRepository;

    @Override
    public void mbtiCheck(FindRequestMbtiDataModel mbtiData, HttpSession session) {
        String mbtiResult1 = mbtiData.E() > mbtiData.I() ? "E" : "I";
        String mbtiResult2 = mbtiData.N() > mbtiData.S() ? "N" : "S";
        String mbtiResult3 = mbtiData.T() > mbtiData.F() ? "T" : "F";
        String mbtiResult4 = mbtiData.P() > mbtiData.J() ? "P" : "J";

        String userMbti = mbtiResult1 + mbtiResult2 + mbtiResult3 + mbtiResult4;
        log.info("===========userMbti=============={}",userMbti);

        Mbti mbti = Mbti.builder()
                .name(userMbti)
                .dateTime(DateTime.builder()
                        .inputDt(LocalDate.now())
                        .build())
                .build();
        mbtiRepository.save(mbti);
        Member member = (Member) session.getAttribute("member");
        FindResponseLoginMemberModel memberModel = memberMapper.toLoginModel(member);
        memberRepository.findMemberById(memberModel.id()).setMbti(mbti);
    }
}
