package com.dongyoung.noAlone.meeting.service;

import com.dongyoung.noAlone.meeting.model.*;
import jakarta.servlet.http.HttpSession;

import java.util.List;

public interface MeetingService {
    List<FindResponseMeetingAndOwnerListModel> findAll();

    FindResponseMeetingAndOwnerModel find(Long meetingId);

    void save(FindRequestInsertMeetingModel meetingModel);

    void update(FindRequestUpdateMeetingModel meetingModel);

    void delete(Long meetingId);
}
