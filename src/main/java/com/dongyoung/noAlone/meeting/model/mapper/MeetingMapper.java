package com.dongyoung.noAlone.meeting.model.mapper;

import com.dongyoung.noAlone.accept.entity.Accept;
import com.dongyoung.noAlone.meeting.entity.Meeting;
import com.dongyoung.noAlone.meeting.model.FindResponseMeetingAndOwnerListModel;
import com.dongyoung.noAlone.meeting.model.FindResponseMeetingViewModel;
import com.dongyoung.noAlone.meeting.model.FindResponseMeetingAppliListModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MeetingMapper {

    @Mapping(source = "dateTime.inputDt", target = "inputDt")
    @Mapping(source = "owner", target = "ownerListModel")
    @Mapping(source = "owner.member", target = "ownerListModel.memberListModel")
    FindResponseMeetingAndOwnerListModel toMeetingListModel(Meeting meeting);

    @Mapping(source = "dateTime.inputDt", target = "inputDt")
    @Mapping(source = "owner", target = "ownerWithMeetingModel")
    @Mapping(source = "owner.member", target = "ownerWithMeetingModel.memberModel")
    FindResponseMeetingViewModel toMeetingModel(Meeting meeting);


    @Mapping(source = "dateTime.inputDt", target = "inputDt")
    @Mapping(source = "member", target = "memberWithAcceptListModel")
    @Mapping(source = "member.mbti", target = "memberWithAcceptListModel.mbtiWithMemberModel")
    FindResponseMeetingAppliListModel toMeetingAppliListModel(Accept accept);


}
