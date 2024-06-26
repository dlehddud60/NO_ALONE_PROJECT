package com.dongyoung.noAlone.owner.repository;

import com.dongyoung.noAlone.owner.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner,Long> {
    Owner findByMeeting_MeetingIdAndMember_MemberId(Long meetingId, Long memberId);

}
