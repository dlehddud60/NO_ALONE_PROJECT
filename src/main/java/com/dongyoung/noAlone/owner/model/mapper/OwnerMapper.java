package com.dongyoung.noAlone.owner.model.mapper;

import com.dongyoung.noAlone.owner.entity.Owner;
import com.dongyoung.noAlone.owner.model.FindResponseOwnerModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")

public interface OwnerMapper {
    @Mapping(source = "member", target = "memberModel")
    @Mapping(source = "meeting", target = "meetingModel")
    FindResponseOwnerModel toOwnerModel(Owner owner);
}
