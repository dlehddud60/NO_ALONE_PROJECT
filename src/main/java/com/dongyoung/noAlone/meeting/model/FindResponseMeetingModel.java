package com.dongyoung.noAlone.meeting.model;

import java.time.LocalDate;

public record FindResponseMeetingModel(
        Long meetingId,
        String name,
        String content,
        String rule,
        String location,
        String question,
        String owner,
        LocalDate inputDt

) {
}
