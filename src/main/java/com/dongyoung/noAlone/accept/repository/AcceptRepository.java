package com.dongyoung.noAlone.accept.repository;

import com.dongyoung.noAlone.accept.entity.Accept;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AcceptRepository extends JpaRepository<Accept,Long> {
    Accept findByAcceptId(Long acceptId);
    Accept findByMeetingMeetingIdAndMemberMemberId(Long meetingId, Long memberId);
    List<Accept> findAllByMeeting_MeetingId(Long meetingId); //언더바 수정
}
