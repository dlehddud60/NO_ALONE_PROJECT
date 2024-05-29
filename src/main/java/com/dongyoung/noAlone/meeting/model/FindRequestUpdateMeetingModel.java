package com.dongyoung.noAlone.meeting.model;

public record FindRequestUpdateMeetingModel(
        Long meetingId,
        String name,
        String content,
        String rule,
        String location,
        String question,
        String owner
) {
}
