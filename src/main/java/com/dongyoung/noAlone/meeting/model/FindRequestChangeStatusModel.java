package com.dongyoung.noAlone.meeting.model;

import com.dongyoung.noAlone.accept.entity.Status;
import com.dongyoung.noAlone.member.Model.FindResponseMemberWithAcceptListModel;

import java.time.LocalDate;

public record FindRequestChangeStatusModel(
        Long acceptId,
        Status status
) {
}
