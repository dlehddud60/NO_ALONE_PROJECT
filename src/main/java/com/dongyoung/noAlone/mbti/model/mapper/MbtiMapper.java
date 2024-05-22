package com.dongyoung.noAlone.mbti.model.mapper;

import com.dongyoung.noAlone.mbti.entity.Mbti;
import com.dongyoung.noAlone.mbti.model.FindResponseMbtiListModel;
import com.dongyoung.noAlone.mbti.model.FindResponseMbtiModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MbtiMapper {
    FindResponseMbtiModel toMbtiModel(Mbti mbti);
    FindResponseMbtiListModel toMbtiListModel(Mbti mbti);
}
