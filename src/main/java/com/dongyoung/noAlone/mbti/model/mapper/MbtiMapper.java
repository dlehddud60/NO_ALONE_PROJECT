package com.dongyoung.noAlone.mbti.model.mapper;

import com.dongyoung.noAlone.mbti.entity.Mbti;
import com.dongyoung.noAlone.mbti.model.FindRespnseMbtiModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MbtiMapper {
    FindRespnseMbtiModel toMbtiModel(Mbti mbti);
}
