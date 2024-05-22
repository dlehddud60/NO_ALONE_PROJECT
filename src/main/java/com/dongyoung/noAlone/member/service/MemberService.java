package com.dongyoung.noAlone.member.service;

import com.dongyoung.noAlone.mbti.model.FindRequestMbtiDataModel;
import com.dongyoung.noAlone.member.Model.FindRequestLoginModel;
import com.dongyoung.noAlone.member.Model.FindRequestMemberModel;
import jakarta.servlet.http.HttpSession;

public interface MemberService {
    void save(FindRequestMemberModel findRequestMemberModel);

    String login(FindRequestLoginModel loginModel, HttpSession session);


}


