package com.dongyoung.noAlone.accept.model;

import com.dongyoung.noAlone.accept.entity.Status;
import com.dongyoung.noAlone.meeting.model.FindResponseMeetingAndAcceptModel;
import com.dongyoung.noAlone.member.Model.FindResponseLoginMemberModel;

public record FindResponseAcceptModel(
        Long acceptId,
        Status status,
        String aboutMe,
        String companionReason,
        FindResponseLoginMemberModel member,
        FindResponseMeetingAndAcceptModel meeting

) {
}
