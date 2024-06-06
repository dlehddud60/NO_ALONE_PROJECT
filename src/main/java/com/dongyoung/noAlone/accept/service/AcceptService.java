package com.dongyoung.noAlone.accept.service;

import com.dongyoung.noAlone.accept.entity.Accept;
import com.dongyoung.noAlone.accept.model.FindResponseAcceptModel;

public interface AcceptService {
    FindResponseAcceptModel findByMeeting_MeetingIdAndMember_MemberId(Long meetingId,Long memberId);

    void delete(Long acceptId);
}
