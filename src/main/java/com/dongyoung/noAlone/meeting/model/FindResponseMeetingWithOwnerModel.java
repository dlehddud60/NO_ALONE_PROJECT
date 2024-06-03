package com.dongyoung.noAlone.meeting.model;

import java.time.LocalDate;

public record FindResponseMeetingWithOwnerModel(
        Long meetingId,
        String name,
        String content,
        String rule,
        String location,
        String question,
        LocalDate inputDt

) {
}
