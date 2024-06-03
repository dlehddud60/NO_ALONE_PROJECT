package com.dongyoung.noAlone.mbti.service;

import com.dongyoung.noAlone.mbti.model.*;
import jakarta.servlet.http.HttpSession;

import java.util.List;

public interface MbtiService {
    FindResponseMbtiModel mbtiCheck(MbtiResultRequestModel mbtiData, HttpSession session);

    void save(InsertRequestModel insertModel);

    void update(UpdateRequestModel updateModel);

    List<FindResponseMbtiListModel> findAll();

    void delete(Long mbtiId);

    FindResponseMbtiModel find(Long mbtiId);
}
