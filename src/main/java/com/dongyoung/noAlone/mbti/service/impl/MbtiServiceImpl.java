package com.dongyoung.noAlone.mbti.service.impl;

import com.dongyoung.noAlone.common.entity.DateTime;
import com.dongyoung.noAlone.mbti.entity.Mbti;
import com.dongyoung.noAlone.mbti.model.*;
import com.dongyoung.noAlone.mbti.model.mapper.MbtiMapper;
import com.dongyoung.noAlone.mbti.repository.MbtiRepository;
import com.dongyoung.noAlone.mbti.service.MbtiService;
import com.dongyoung.noAlone.member.entity.Member;
import com.dongyoung.noAlone.member.repository.MemberRepository;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@Service
@Transactional
@RequiredArgsConstructor
public class MbtiServiceImpl implements MbtiService {
    private final MbtiRepository mbtiRepository;
    private final MbtiMapper mbtiMapper;
    private final MemberRepository memberRepository;


    @Override
    public void save(FindRequestInsertModel insertModel) {

        Mbti mbti = Mbti.builder()
                .name(insertModel.name())
                .description(insertModel.description())
                .dateTime(DateTime.builder()
                        .inputDt(LocalDate.now())
                        .build())
                .build();
        mbtiRepository.save(mbti);
    }

    @Override
    public void update(FindRequestUpdateModel updateModel) {
        Mbti mbti = mbtiRepository.findByMbtiId(updateModel.mbtiId());
        mbti.setName(updateModel.name());
        mbti.setDescription(updateModel.description());
    }

    @Override
    public List<FindResponseMbtiListModel> findAll() {
        return mbtiRepository.findAll().stream().map(mbtiMapper::toMbtiListModel).collect(Collectors.toList());
    }

    @Override
    public FindResponseMbtiModel find(Long mbtiId) {
        return mbtiMapper.toMbtiModel(mbtiRepository.findByMbtiId(mbtiId));
    }

    @Override
    public void delete(Long mbtiId) {
        mbtiRepository.deleteById(mbtiId);
    }

    @Override
    public FindResponseMbtiModel mbtiCheck(FindRequestMbtiDataModel mbtiData, HttpSession session) {
        String mbtiResult1 = mbtiData.E() > mbtiData.I() ? "E" : "I";
        String mbtiResult2 = mbtiData.N() > mbtiData.S() ? "N" : "S";
        String mbtiResult3 = mbtiData.T() > mbtiData.F() ? "T" : "F";
        String mbtiResult4 = mbtiData.P() > mbtiData.J() ? "P" : "J";

        String userMbti = mbtiResult1 + mbtiResult2 + mbtiResult3 + mbtiResult4;

        Mbti mbtiName = mbtiRepository.findByName(userMbti);
        Member member = (Member) session.getAttribute("member");
        memberRepository.findMemberById(member.getId()).setMbti(mbtiName);
        FindResponseMbtiModel mbtiModel = mbtiMapper.toMbtiModel(memberRepository.findMemberById(member.getId()).getMbti());
        return mbtiModel;
    }
}
