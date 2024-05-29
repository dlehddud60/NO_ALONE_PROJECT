package com.dongyoung.noAlone.meeting.model.mapper;

import com.dongyoung.noAlone.meeting.entity.Meeting;
import com.dongyoung.noAlone.meeting.model.FindResponseMeetingListModel;
import com.dongyoung.noAlone.meeting.model.FindResponseMeetingModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MeetingMapper {

    @Mapping(source = "dateTime.inputDt", target = "inputDt")
    FindResponseMeetingListModel toMeetingListModel(Meeting meeting);
    @Mapping(source = "dateTime.inputDt", target = "inputDt")
    FindResponseMeetingModel toMeetingModel(Meeting meeting);
}
