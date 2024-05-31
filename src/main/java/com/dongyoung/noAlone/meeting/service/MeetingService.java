package com.dongyoung.noAlone.meeting.service;

import com.dongyoung.noAlone.accept.model.FindRequestAcceptAppliModel;
import com.dongyoung.noAlone.meeting.model.*;
import com.dongyoung.noAlone.member.Model.FindResponseMemberWithAcceptListModel;
import jakarta.servlet.http.HttpSession;

import java.util.List;

public interface MeetingService {
    List<FindResponseMeetingAndOwnerListModel> findAll();

    FindResponseMeetingAndOwnerModel find(Long meetingId);

    void save(FindRequestInsertMeetingModel meetingModel);

    void update(FindRequestUpdateMeetingModel meetingModel);

    void delete(Long meetingId);

    void meetAppli(FindRequestAcceptAppliModel appliModel);

    List<FindResponseMeetingAppliListModel> meetAppliList();

    void changeStatus(FindRequestChangeStatusModel statusModel);
}
