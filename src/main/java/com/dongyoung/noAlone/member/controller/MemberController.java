package com.dongyoung.noAlone.member.controller;

import com.dongyoung.noAlone.member.Model.FindRequestMemberModel;
import com.dongyoung.noAlone.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j2
@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/register")
    public String save() {
        return "member/register";
    }

    @PostMapping("/save11")
    public String save(FindRequestMemberModel findRequestMemberModel) {
        log.info("=================save=================");
        memberService.save(findRequestMemberModel);
        return "redirect:/member/register";
    }
}
