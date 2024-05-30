package com.dongyoung.noAlone.owner.model;

import com.dongyoung.noAlone.member.Model.FindResponseMemberWithOwnerModel;

public record FindResponseOwnerwithMeetingModel(
        FindResponseMemberWithOwnerModel memberModel
) {
}
