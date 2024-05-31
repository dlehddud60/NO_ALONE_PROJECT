package com.dongyoung.noAlone.meeting.service.impl;

import com.dongyoung.noAlone.accept.entity.Accept;
import com.dongyoung.noAlone.accept.entity.Status;
import com.dongyoung.noAlone.accept.model.FindRequestAcceptAppliModel;
import com.dongyoung.noAlone.accept.repository.AcceptRepository;
import com.dongyoung.noAlone.common.entity.DateTime;
import com.dongyoung.noAlone.meeting.entity.Meeting;
import com.dongyoung.noAlone.meeting.model.*;
import com.dongyoung.noAlone.meeting.model.mapper.MeetingMapper;
import com.dongyoung.noAlone.meeting.repository.MeetingRepository;
import com.dongyoung.noAlone.meeting.service.MeetingService;
import com.dongyoung.noAlone.member.repository.MemberRepository;
import com.dongyoung.noAlone.owner.entity.Owner;
import com.dongyoung.noAlone.owner.repository.OwnerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Log4j2
@RequiredArgsConstructor
@Service
public class MeetingServiceImpl implements MeetingService {
    private final MeetingRepository meetingRepository;
    private final MemberRepository memberRepository;
    private final OwnerRepository ownerRepository;
    private final MeetingMapper meetingMapper;
    private final AcceptRepository acceptRepository;

    @Override
    public List<FindResponseMeetingAndOwnerListModel> findAll() {
        return meetingRepository.findAll().stream().map(meetingMapper::toMeetingListModel).collect(Collectors.toList());
    }

    @Override
    public FindResponseMeetingAndOwnerModel find(Long meetingId) {
        return meetingMapper.toMeetingModel(meetingRepository.findByMeetingId(meetingId));
    }

    @Override
    public void save(FindRequestInsertMeetingModel meetingService) {
        Meeting meeting = Meeting.builder()
                .content(meetingService.content())
                .name(meetingService.name())
                .rule(meetingService.rule())
                .question(meetingService.question())
                .location(meetingService.location())
                .dateTime(
                        DateTime.builder()
                                .inputDt(LocalDate.now())
                                .build())
                .build();
        meetingRepository.save(meeting);

        Owner owner = Owner.builder()
                .member(memberRepository.findByMemberId(meetingService.memberId()))
                .meeting(meeting)
                .dateTime(DateTime.builder()
                        .inputDt(LocalDate.now())
                        .build())
                .build();
        ownerRepository.save(owner);
    }

    @Override
    public void update(FindRequestUpdateMeetingModel meetingModel) {
        Meeting meeting = meetingRepository.findByMeetingId(meetingModel.meetingId());
        meeting.setContent(meetingModel.content());
        meeting.setName(meetingModel.name());
        meeting.setRule(meetingModel.rule());
        meeting.setLocation(meetingModel.location());
        meeting.setQuestion(meetingModel.question());
        meeting.getDateTime().setUpdateDt(LocalDate.now());
    }

    @Override
    public void delete(Long meetingId) {
        ownerRepository.deleteById(meetingRepository.findByMeetingId(meetingId).getOwner().getOwnerId());
        meetingRepository.deleteById(meetingId);
    }

    @Override
    public void meetAppli(FindRequestAcceptAppliModel appliModel) {

        Accept accept = Accept.builder()
                .meeting(meetingRepository.findByMeetingId(appliModel.meetingId()))
                .member(memberRepository.findByMemberId(appliModel.memberId()))
                .aboutMe(appliModel.aboutMe())
                .companionReason(appliModel.companionReason())
                .status(Status.APPLY)
                .dateTime(DateTime.builder()
                        .inputDt(LocalDate.now())
                        .build())
                .build();
        acceptRepository.save(accept);
    }

    @Override
    public List<FindResponseMeetingAppliListModel> meetAppliList() {
        return acceptRepository.findAll().stream().map(meetingMapper::toMeetingAppliListModel).collect(Collectors.toList());
    }

    @Override
    public void changeStatus( FindRequestChangeStatusModel statusModel) {
        Accept accept = acceptRepository.findByAcceptId(statusModel.acceptId());
        accept.setStatus(statusModel.status());
    }
}
