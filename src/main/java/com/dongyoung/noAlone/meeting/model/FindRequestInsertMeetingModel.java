package com.dongyoung.noAlone.meeting.model;

public record FindRequestInsertMeetingModel(
        String name,
        String content,
        String rule,
        String location,
        String question,
        Long memberId
) {
}
