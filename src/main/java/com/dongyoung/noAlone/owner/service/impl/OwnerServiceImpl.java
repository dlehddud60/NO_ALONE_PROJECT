package com.dongyoung.noAlone.owner.service.impl;

import com.dongyoung.noAlone.owner.entity.Owner;
import com.dongyoung.noAlone.owner.model.FindResponseOwnerModel;
import com.dongyoung.noAlone.owner.model.mapper.OwnerMapper;
import com.dongyoung.noAlone.owner.repository.OwnerRepository;
import com.dongyoung.noAlone.owner.service.OwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class OwnerServiceImpl implements OwnerService {

    private final OwnerRepository ownerRepository;
    private final OwnerMapper ownerMapper;

    @Override
    public FindResponseOwnerModel find(Long meetingId, Long memberId) {

        return ownerMapper.toOwnerModel(ownerRepository.findByMeeting_MeetingIdAndMember_MemberId(meetingId,memberId));
    }
}
