package com.dongyoung.noAlone.accept.model.mapper;

import com.dongyoung.noAlone.accept.entity.Accept;
import com.dongyoung.noAlone.accept.model.FindResponseAcceptModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AcceptMapper {
    @Mapping(source = "member",target = "member")
    @Mapping(source = "meeting",target = "meeting")
    FindResponseAcceptModel toAcceptModel(Accept accept);

}
