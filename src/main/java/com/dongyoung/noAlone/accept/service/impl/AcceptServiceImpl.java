package com.dongyoung.noAlone.accept.service.impl;

import com.dongyoung.noAlone.accept.entity.Accept;
import com.dongyoung.noAlone.accept.entity.Status;
import com.dongyoung.noAlone.accept.model.FindResponseAcceptModel;
import com.dongyoung.noAlone.accept.model.InsertRequestApplicationModel;
import com.dongyoung.noAlone.accept.model.mapper.AcceptMapper;
import com.dongyoung.noAlone.accept.repository.AcceptRepository;
import com.dongyoung.noAlone.accept.service.AcceptService;
import com.dongyoung.noAlone.meeting.model.ChangeStatusRequestModel;
import com.dongyoung.noAlone.meeting.model.FindResponseMeetingAppliListModel;
import com.dongyoung.noAlone.meeting.model.mapper.MeetingMapper;
import com.dongyoung.noAlone.meeting.repository.MeetingRepository;
import com.dongyoung.noAlone.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class AcceptServiceImpl implements AcceptService {
    private final AcceptRepository acceptRepository;
    private final MeetingMapper meetingMapper;
    private final AcceptMapper acceptMapper;
    private final MeetingRepository meetingRepository;
    private final MemberRepository memberRepository;

    @Override
    public FindResponseAcceptModel findByMeeting_MeetingIdAndMember_MemberId(Long meetingId, Long memberId) {
        return acceptMapper.toAcceptModel(acceptRepository.findByMeetingMeetingIdAndMemberMemberId(meetingId, memberId));
    }

    @Override
    public void application(InsertRequestApplicationModel appliModel) {

        Accept accept = Accept.builder()
                .meeting(meetingRepository.findByMeetingId(appliModel.meetingId()))
                .member(memberRepository.findByMemberId(appliModel.memberId()))
                .aboutMe(appliModel.aboutMe())
                .companionReason(appliModel.companionReason())
                .status(Status.APPLY)
                .build();
        acceptRepository.save(accept);
    } // accept컨트롤러로 옮기기

    @Override
    public List<FindResponseMeetingAppliListModel> applicationList(Long meetingId) {
        return acceptRepository.findAllByMeeting_MeetingId(meetingId).stream().map(meetingMapper::toMeetingAppliListModel).collect(Collectors.toList());
    }

    @Override
    public void changeStatus(ChangeStatusRequestModel statusModel) {
        Accept accept = acceptRepository.findByAcceptId(statusModel.acceptId());
        accept.setStatus(statusModel.status());
    }


    @Override
    public void delete(Long acceptId) {
        acceptRepository.deleteById(acceptId);
    }
}
