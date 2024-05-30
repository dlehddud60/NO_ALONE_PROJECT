package com.dongyoung.noAlone.owner.model;

import com.dongyoung.noAlone.member.Model.FindResponseMemberWithOwnerListModel;
import com.dongyoung.noAlone.member.Model.FindResponseMemberWithOwnerModel;

public record FindResponseOwnerwithMeetingListModel(
        FindResponseMemberWithOwnerListModel memberListModel
) {
}
