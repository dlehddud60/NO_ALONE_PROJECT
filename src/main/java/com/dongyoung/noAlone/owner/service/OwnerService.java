package com.dongyoung.noAlone.owner.service;

import com.dongyoung.noAlone.owner.entity.Owner;
import com.dongyoung.noAlone.owner.model.FindResponseOwnerModel;

public interface OwnerService {
    FindResponseOwnerModel find(Long meetingId, Long memberId);
}
