package com.dongyoung.noAlone.meeting.model;

import com.dongyoung.noAlone.accept.entity.Status;
import com.dongyoung.noAlone.member.Model.FindResponseMemberWithAcceptListModel;

import java.time.LocalDate;

public record FindResponseMeetingAppliListModel(
        Long acceptId,
        Status status,
        String aboutMe,
        String companionReason,
        LocalDate inputDt,
    FindResponseMemberWithAcceptListModel memberWithAcceptListModel
) {
}
