package com.dongyoung.noAlone.member.service;

import com.dongyoung.noAlone.member.Model.FindRequestLoginModel;
import com.dongyoung.noAlone.member.Model.FindRequestRegisterMemberModel;
import com.dongyoung.noAlone.member.Model.FindRequestMemberUpdateModel;
import com.dongyoung.noAlone.member.Model.FindResponseMemberWithMbtiModel;
import jakarta.servlet.http.HttpSession;

public interface MemberService {
    void save(FindRequestRegisterMemberModel findRequestRegisterMemberModel , HttpSession session);

    String login(FindRequestLoginModel loginModel, HttpSession session);


    void update(FindRequestMemberUpdateModel id,HttpSession session);

    FindResponseMemberWithMbtiModel find(String id);

    boolean verifyExistEmail(String email);
}


