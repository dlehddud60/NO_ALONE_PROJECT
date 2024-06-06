package com.dongyoung.noAlone.accept.service.impl;

import com.dongyoung.noAlone.accept.model.FindResponseAcceptModel;
import com.dongyoung.noAlone.accept.model.mapper.AcceptMapper;
import com.dongyoung.noAlone.accept.repository.AcceptRepository;
import com.dongyoung.noAlone.accept.service.AcceptService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class AcceptServiceImpl implements AcceptService {
    private final AcceptRepository acceptRepository;
    private final AcceptMapper acceptMapper;

    @Override
    public FindResponseAcceptModel findByMeeting_MeetingIdAndMember_MemberId(Long meetingId, Long memberId) {
        return acceptMapper.toAcceptModel(acceptRepository.findByMeeting_MeetingIdAndMember_MemberId(meetingId, memberId));
    }

    @Override
    public void delete(Long acceptId) {
        acceptRepository.deleteById(acceptId);
    }
}
