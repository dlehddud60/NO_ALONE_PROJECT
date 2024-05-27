package com.dongyoung.noAlone.member.controller;

import com.dongyoung.noAlone.mbti.service.MbtiService;
import com.dongyoung.noAlone.member.Model.*;
import com.dongyoung.noAlone.member.entity.Member;
import com.dongyoung.noAlone.member.service.MemberService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Log4j2
@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;
    private final MbtiService mbtiService;

    @GetMapping("/")
    public String home() {
        return "/member/home";
    }

    @GetMapping("/register")
    public String save(@ModelAttribute("memberDTO") FindRequestRegisterMemberModel memberDTO) {
        return "member/register";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("memberDTO") @Validated  FindRequestRegisterMemberModel memberDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.info("errors={} ", bindingResult);
            return "/member/register";
        }
        memberService.save(memberDTO);
        return "redirect:/member/register";
    }

    @GetMapping("/login")
    public String loginForm() {
        return "/member/loginForm";
    }

    @PostMapping("/login")
    public String login(FindRequestLoginModel loginModel, HttpSession session) {
        return memberService.login(loginModel, session);
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/member/login";
    }

    @GetMapping("/update")
    public String update(Model model,HttpSession session) {

        Member member = (Member) session.getAttribute("member");
        FindResponseMemberWithMbtiModel memberWithMbtiModel = memberService.find(member.getId());
        model.addAttribute("memberDTO",memberWithMbtiModel);
        model.addAttribute("mbtiInfo",memberWithMbtiModel.mbtiWithMemberModel());
        model.addAttribute("mbtiList",mbtiService.findAll());


        return "/member/update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("memberDTO") @Validated FindRequestMemberUpdateModel memberUpdateModel, BindingResult bindingResult,Model model,HttpSession session) {
        Member member = (Member) session.getAttribute("member");
        if (bindingResult.hasErrors()) {
            log.info("errors={} ", bindingResult);
            model.addAttribute("mbtiInfo1",member.getMbti().getMbtiId());
            model.addAttribute("mbtiList1",mbtiService.findAll());
            return "/member/update";
        }
        memberService.update(memberUpdateModel,session);
        return "redirect:/member/update";
    }

    @GetMapping("/myMbti")
    public String myMbti(Model model,HttpSession session) {
        Member member = (Member) session.getAttribute("member");
        FindResponseMemberWithMbtiModel memberWithMbtiModel = memberService.find(member.getId());
        model.addAttribute("memberInfo",memberWithMbtiModel);
        return "/mbti/myMbti";
    }
}
