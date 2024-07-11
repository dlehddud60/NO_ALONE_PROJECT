package com.dongyoung.noAlone.meeting.repository;

import com.dongyoung.noAlone.meeting.model.FindResponseMeetingAndOwnerListModel;
import com.dongyoung.noAlone.meeting.model.SearchCondition;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MeetingQueryRepository {
    Page<FindResponseMeetingAndOwnerListModel> findAllByQueryDsl(SearchCondition search, Pageable pageable);
}
