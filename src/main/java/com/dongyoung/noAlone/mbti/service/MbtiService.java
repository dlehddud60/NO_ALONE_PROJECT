package com.dongyoung.noAlone.mbti.service;

import com.dongyoung.noAlone.mbti.model.FindRequestMbtiDataModel;
import jakarta.servlet.http.HttpSession;

public interface MbtiService {
    void mbtiCheck(FindRequestMbtiDataModel mbtiData, HttpSession session);
}
