package com.dongyoung.noAlone.mbti.service;

import com.dongyoung.noAlone.mbti.model.FindRequestMbtiDataModel;
import com.dongyoung.noAlone.mbti.model.FindRespnseMbtiModel;
import jakarta.servlet.http.HttpSession;

public interface MbtiService {
    FindRespnseMbtiModel mbtiCheck(FindRequestMbtiDataModel mbtiData, HttpSession session);
}
