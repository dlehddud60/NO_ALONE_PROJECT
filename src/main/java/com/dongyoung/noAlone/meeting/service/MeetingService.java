package com.dongyoung.noAlone.meeting.service;

import com.dongyoung.noAlone.accept.model.InsertRequestApplicationModel;
import com.dongyoung.noAlone.meeting.model.*;

import java.util.List;

public interface MeetingService {
    List<FindResponseMeetingAndOwnerListModel> findAll();

    FindResponseMeetingAndOwnerModel find(Long meetingId);

    void save(InsertRequestMeetingModel meetingModel);

    void update(UpdateRequestMeetingModel meetingModel);

    void delete(Long meetingId);

    void meetAppli(InsertRequestApplicationModel appliModel);

    List<FindResponseMeetingAppliListModel> applicationList(Long meetingId);

    void changeStatus(ChangeStatusRequestModel statusModel);
}
