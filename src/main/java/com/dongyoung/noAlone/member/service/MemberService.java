package com.dongyoung.noAlone.member.service;

import com.dongyoung.noAlone.member.Model.LoginRequestModel;
import com.dongyoung.noAlone.member.Model.InsertRequestMemberModel;
import com.dongyoung.noAlone.member.Model.UpdateRequestMemberModel;
import com.dongyoung.noAlone.member.Model.FindResponseMemberWithMbtiModel;
import jakarta.servlet.http.HttpSession;

public interface MemberService {
    void save(InsertRequestMemberModel insertRequestMemberModel, HttpSession session);

    String login(LoginRequestModel loginModel, HttpSession session);


    void update(UpdateRequestMemberModel id, HttpSession session);

    FindResponseMemberWithMbtiModel find(String id);

    boolean verifyExistEmail(String email);
}


