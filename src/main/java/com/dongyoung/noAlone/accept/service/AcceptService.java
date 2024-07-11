package com.dongyoung.noAlone.accept.service;

import com.dongyoung.noAlone.accept.entity.Accept;
import com.dongyoung.noAlone.accept.model.FindResponseAcceptModel;
import com.dongyoung.noAlone.accept.model.InsertRequestApplicationModel;
import com.dongyoung.noAlone.meeting.model.ChangeStatusRequestModel;
import com.dongyoung.noAlone.meeting.model.FindResponseMeetingAppliListModel;

import java.util.List;

public interface AcceptService {
    FindResponseAcceptModel findByMeeting_MeetingIdAndMember_MemberId(Long meetingId,Long memberId);

    void application(InsertRequestApplicationModel appliModel);

    List<FindResponseMeetingAppliListModel> applicationList(Long meetingId);

    void changeStatus(ChangeStatusRequestModel statusModel);

    void delete(Long acceptId);
}
