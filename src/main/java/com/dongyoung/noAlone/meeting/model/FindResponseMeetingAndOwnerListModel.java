package com.dongyoung.noAlone.meeting.model;

import com.dongyoung.noAlone.owner.model.FindResponseOwnerwithMeetingListModel;
import com.dongyoung.noAlone.owner.model.FindResponseOwnerwithMeetingModel;

import java.time.LocalDate;

public record FindResponseMeetingAndOwnerListModel(
        Long meetingId,
        String name,
        String content,
        String rule,
        String location,
        String question,
        LocalDate inputDt,
        FindResponseOwnerwithMeetingListModel ownerListModel
) {
}
