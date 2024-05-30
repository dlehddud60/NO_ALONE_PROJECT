package com.dongyoung.noAlone.meeting.service;

import com.dongyoung.noAlone.meeting.model.FindRequestInsertMeetingModel;
import com.dongyoung.noAlone.meeting.model.FindRequestUpdateMeetingModel;
import com.dongyoung.noAlone.meeting.model.FindResponseMeetingListModel;
import com.dongyoung.noAlone.meeting.model.FindResponseMeetingModel;
import jakarta.servlet.http.HttpSession;

import java.util.List;

public interface MeetingService {
    List<FindResponseMeetingListModel> findAll();

    FindResponseMeetingModel find(Long meetingId);

    void save(FindRequestInsertMeetingModel meetingModel);

    void update(FindRequestUpdateMeetingModel meetingModel);

    void delete(Long meetingId);
}
