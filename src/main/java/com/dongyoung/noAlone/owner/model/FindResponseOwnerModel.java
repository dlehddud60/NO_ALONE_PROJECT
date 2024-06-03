package com.dongyoung.noAlone.owner.model;

import com.dongyoung.noAlone.meeting.model.FindResponseMeetingWithOwnerModel;
import com.dongyoung.noAlone.member.Model.FindResponseMemberWithOwnerModel;

public record FindResponseOwnerModel(
        Long ownerId,
        FindResponseMemberWithOwnerModel memberModel,
        FindResponseMeetingWithOwnerModel meetingModel

) {
}
