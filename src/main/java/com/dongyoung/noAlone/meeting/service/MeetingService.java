package com.dongyoung.noAlone.meeting.service;

import com.dongyoung.noAlone.meeting.model.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MeetingService {
    List<FindResponseMeetingAndOwnerListModel> findAll();

    FindResponseMeetingViewModel find(Long meetingId);

    void save(InsertRequestMeetingModel meetingModel);

    void update(UpdateRequestMeetingModel meetingModel);

    void delete(Long meetingId);


    Page<FindResponseMeetingAndOwnerListModel> findAllByQueryDsl(SearchCondition search, Pageable pageable);
}

