package com.dongyoung.noAlone.accept.model;

import com.dongyoung.noAlone.accept.entity.Status;
import com.dongyoung.noAlone.common.entity.DateTime;
import com.dongyoung.noAlone.meeting.entity.Meeting;
import com.dongyoung.noAlone.meeting.model.FindResponseMeetingAndAcceptModel;
import com.dongyoung.noAlone.member.Model.FindResponseLoginMemberModel;
import com.dongyoung.noAlone.member.entity.Member;
import jakarta.persistence.*;

public record FindResponseAcceptModel(
        Long acceptId,
        Status status,
        String aboutMe,
        String companionReason,
        DateTime dateTime,
        FindResponseLoginMemberModel member,
        FindResponseMeetingAndAcceptModel meeting

) {
}
