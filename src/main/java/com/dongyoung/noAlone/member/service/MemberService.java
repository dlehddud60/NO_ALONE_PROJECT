package com.dongyoung.noAlone.member.service;

import com.dongyoung.noAlone.mbti.model.FindRequestMbtiDataModel;
import com.dongyoung.noAlone.member.Model.FindRequestLoginModel;
import com.dongyoung.noAlone.member.Model.FindRequestMemberModel;
import com.dongyoung.noAlone.member.Model.FindRequestMemberUpdateModel;
import com.dongyoung.noAlone.member.Model.FindResponseMemberWithMbtiModel;
import jakarta.servlet.http.HttpSession;

public interface MemberService {
    void save(FindRequestMemberModel findRequestMemberModel);

    String login(FindRequestLoginModel loginModel, HttpSession session);


    void update(FindRequestMemberUpdateModel id);

    FindResponseMemberWithMbtiModel find(String id);
}


