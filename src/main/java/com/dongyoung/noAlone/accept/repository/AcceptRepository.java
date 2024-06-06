package com.dongyoung.noAlone.accept.repository;

import com.dongyoung.noAlone.accept.entity.Accept;
import com.dongyoung.noAlone.accept.model.FindResponseAcceptModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AcceptRepository extends JpaRepository<Accept,Long> {
    Accept findByAcceptId(Long acceptId);
    Accept findByMeeting_MeetingIdAndMember_MemberId(Long meetingId,Long memberId);
    List<Accept> findAllByMeeting_MeetingId(Long meetingId);
}
