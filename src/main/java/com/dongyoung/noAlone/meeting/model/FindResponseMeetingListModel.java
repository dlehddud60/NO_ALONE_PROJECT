package com.dongyoung.noAlone.meeting.model;

import com.dongyoung.noAlone.common.entity.DateTime;

import java.time.LocalDate;

public record FindResponseMeetingListModel(
        Long meetingId,
        String name,
        String content,
        String rule,
        String location,
        String question,
        LocalDate inputDt
) {
}
