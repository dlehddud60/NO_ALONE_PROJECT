package com.dongyoung.noAlone.mbti.controller;

import com.dongyoung.noAlone.mbti.model.FindRequestMbtiDataModel;
import com.dongyoung.noAlone.mbti.service.MbtiService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
@RequestMapping("/mbti")
@Log4j2
public class MbtiController {
    private final MbtiService mbtiService;

    @GetMapping("/mbtiTestForm")
    public String mbtiTestFrom() {
        return null;
    }

    @GetMapping("/mbtiCheckForm")
    public String mbtiCheckFrom() {
        return "/mbti/mbtiCheck";
    }

    @PostMapping("/mbtiCheck")
    public String mbtiCheck(@ModelAttribute @Validated FindRequestMbtiDataModel mbtiData, HttpSession session, RedirectAttributes rttr) {
        rttr.addFlashAttribute("mbtiResult", mbtiService.mbtiCheck(mbtiData,session));
        return "redirect:/mbti/mbtiCheckForm";
    }
}
