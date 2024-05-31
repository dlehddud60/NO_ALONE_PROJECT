package com.dongyoung.noAlone.accept.model;

import com.dongyoung.noAlone.accept.entity.Status;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public record FindRequestAcceptAppliModel(
        String aboutMe,
        String companionReason,
        Long memberId,
        Long meetingId
) {
}
