package com.dongyoung.noAlone.meeting.service.impl;

import com.dongyoung.noAlone.category.entity.Category;
import com.dongyoung.noAlone.category.repository.CategoryRepository;
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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    private final CategoryRepository categoryRepository;

    @Override
    public List<FindResponseMeetingAndOwnerListModel> findAll() {
        return meetingRepository.findAll().stream().map(meetingMapper::toMeetingListModel).collect(Collectors.toList());
    }

    @Override
    public Page<FindResponseMeetingAndOwnerListModel> findAllByQueryDsl(SearchCondition search, Pageable pageable) {
        return meetingRepository.findAllByQueryDsl(search, pageable);
    }

    @Override
    public FindResponseMeetingViewModel find(Long meetingId) {
        return meetingMapper.toMeetingModel(meetingRepository.findByMeetingId(meetingId));
    }

    @Override
    public void save(InsertRequestMeetingModel meetingModel) {
        Category category = Category.builder()
                .name(meetingModel.name())
                .description(meetingModel.name())
                .build();
        categoryRepository.save(category);

        Meeting meeting = Meeting.builder()
                .content(meetingModel.content())
                .name(meetingModel.name())
                .rule(meetingModel.rule())
                .question(meetingModel.question())
                .location(meetingModel.location())
                .category(category)
                .build();
        meetingRepository.save(meeting);

        Owner owner = Owner.builder()
                .member(memberRepository.findByMemberId(meetingModel.memberId()))
                .meeting(meeting)
                .build();
        ownerRepository.save(owner);
    }

    @Override
    public void update(UpdateRequestMeetingModel meetingModel) {
        Meeting meeting = meetingRepository.findByMeetingId(meetingModel.meetingId());

        //memberID 세션을 받아서 owner조회하고 meetingId나온 결과와 컨트롤러 에서 넘겨온 id와 비교해여
        meeting.setContent(meetingModel.content());
        meeting.setName(meetingModel.name());
        meeting.setRule(meetingModel.rule());
        meeting.setLocation(meetingModel.location());
        meeting.setQuestion(meetingModel.question());
    }

    @Override
    public void delete(Long meetingId) {
        ownerRepository.deleteById(meetingRepository.findByMeetingId(meetingId).getOwner().getOwnerId());
        meetingRepository.deleteById(meetingId);
    }


}
