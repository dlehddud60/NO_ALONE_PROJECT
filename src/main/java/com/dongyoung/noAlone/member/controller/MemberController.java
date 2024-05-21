package com.dongyoung.noAlone.member.controller;

import com.dongyoung.noAlone.member.Model.FindRequestLoginModel;
import com.dongyoung.noAlone.member.Model.FindRequestMemberModel;
import com.dongyoung.noAlone.member.service.MemberService;
import jakarta.servlet.http.HttpSession;
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

    @GetMapping("/")
    public String home() {
        return "/member/home";
    }

    @GetMapping("/register")
    public String save() {
        return "member/register";
    }

    @PostMapping("/save")
    public String save(FindRequestMemberModel findRequestMemberModel) {
        log.info("=================save=================");
        memberService.save(findRequestMemberModel);
        return "redirect:/member/register";
    }

    @GetMapping("/login")
    public String loginForm() {
        return "/member/loginForm";
    }

    @PostMapping("/login")
    public String login(FindRequestLoginModel loginModel, HttpSession session) {
        return memberService.login(loginModel,session);
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        log.info("============로그아웃==============");
        session.invalidate();
        return "redirect:/member/";
    }
}
