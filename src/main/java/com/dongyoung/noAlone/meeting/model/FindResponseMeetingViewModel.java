package com.dongyoung.noAlone.meeting.model;

import com.dongyoung.noAlone.category.model.FindResponseCategoryModel;
import com.dongyoung.noAlone.owner.model.FindResponseOwnerwithMeetingModel;

import java.time.LocalDate;

public record FindResponseMeetingViewModel(
        Long meetingId,
        String name,
        String content,
        String rule,
        String location,
        String question,
        LocalDate inputDt,
        FindResponseOwnerwithMeetingModel ownerWithMeetingModel,
        FindResponseCategoryModel category
) {
}
