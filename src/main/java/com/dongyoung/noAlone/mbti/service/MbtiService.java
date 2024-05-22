package com.dongyoung.noAlone.mbti.service;

import com.dongyoung.noAlone.mbti.model.*;
import jakarta.servlet.http.HttpSession;

import java.util.List;

public interface MbtiService {
    FindResponseMbtiModel mbtiCheck(FindRequestMbtiDataModel mbtiData, HttpSession session);

    void save(FindRequestInsertModel insertModel);

    void update(FindRequestUpdateModel updateModel);

    List<FindResponseMbtiListModel> findAll();

    void delete(Long mbtiId);

    FindResponseMbtiModel find(Long mbtiId);
}
