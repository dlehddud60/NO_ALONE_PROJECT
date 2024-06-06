package com.dongyoung.noAlone.mbti.model.mapper;

import com.dongyoung.noAlone.mbti.entity.Mbti;
import com.dongyoung.noAlone.mbti.model.FindResponseMbtiListModel;
import com.dongyoung.noAlone.mbti.model.FindResponseMbtiModel;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-06T20:43:42+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class MbtiMapperImpl implements MbtiMapper {

    @Override
    public FindResponseMbtiModel toMbtiModel(Mbti mbti) {
        if ( mbti == null ) {
            return null;
        }

        Long mbtiId = null;
        String name = null;
        String description = null;

        mbtiId = mbti.getMbtiId();
        name = mbti.getName();
        description = mbti.getDescription();

        FindResponseMbtiModel findResponseMbtiModel = new FindResponseMbtiModel( mbtiId, name, description );

        return findResponseMbtiModel;
    }

    @Override
    public FindResponseMbtiListModel toMbtiListModel(Mbti mbti) {
        if ( mbti == null ) {
            return null;
        }

        Long mbtiId = null;
        String name = null;
        String description = null;

        mbtiId = mbti.getMbtiId();
        name = mbti.getName();
        description = mbti.getDescription();

        FindResponseMbtiListModel findResponseMbtiListModel = new FindResponseMbtiListModel( mbtiId, name, description );

        return findResponseMbtiListModel;
    }
}
