package com.dongyoung.noAlone.meeting.service.impl;

import com.dongyoung.noAlone.common.entity.DateTime;
import com.dongyoung.noAlone.meeting.entity.Meeting;
import com.dongyoung.noAlone.meeting.model.FindRequestInsertMeetingModel;
import com.dongyoung.noAlone.meeting.model.FindRequestUpdateMeetingModel;
import com.dongyoung.noAlone.meeting.model.FindResponseMeetingListModel;
import com.dongyoung.noAlone.meeting.model.FindResponseMeetingModel;
import com.dongyoung.noAlone.meeting.model.mapper.MeetingMapper;
import com.dongyoung.noAlone.meeting.repository.MeetingRepository;
import com.dongyoung.noAlone.meeting.service.MeetingService;
import com.dongyoung.noAlone.member.entity.Member;
import jakarta.servlet.http.HttpSession;
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
    private final MeetingMapper meetingMapper;

    @Override
    public List<FindResponseMeetingListModel> findAll() {
        return meetingRepository.findAll().stream().map(meetingMapper::toMeetingListModel).collect(Collectors.toList());
    }

    @Override
    public FindResponseMeetingModel find(Long meetingId) {
        return meetingMapper.toMeetingModel(meetingRepository.findByMeetingId(meetingId));
    }

    @Override
    public void save(FindRequestInsertMeetingModel meetingService, HttpSession session) {
        Member member = (Member) session.getAttribute("member");
        Meeting meeting = Meeting.builder()
                .content(meetingService.content())
                .name(meetingService.name())
                .rule(meetingService.rule())
                .question(meetingService.question())
                .location(meetingService.location())
                .owner(member.getMemberId())
                .dateTime(
                        DateTime.builder()
                                .inputDt(LocalDate.now())
                                .build())
                .build();

        meetingRepository.save(meeting);
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
        meetingRepository.deleteById(meetingId);
    }
}