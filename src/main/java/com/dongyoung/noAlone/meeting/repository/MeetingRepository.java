package com.dongyoung.noAlone.meeting.repository;

import com.dongyoung.noAlone.meeting.entity.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeetingRepository extends JpaRepository<Meeting, Long>, MeetingQueryRepository {
    Meeting findByMeetingId(Long meetingId);
}
