package com.dongyoung.noAlone.mbti.controller;

import com.dongyoung.noAlone.mbti.model.InsertRequestModel;
import com.dongyoung.noAlone.mbti.model.MbtiResultRequestModel;
import com.dongyoung.noAlone.mbti.model.UpdateRequestModel;
import com.dongyoung.noAlone.mbti.service.MbtiService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
@RequestMapping("/mbti")
@Log4j2
public class MbtiController {
    private final MbtiService mbtiService;

    @GetMapping("/save")
    public String write() {
        return "mbti/saveForm";
    }

    @PostMapping("/save")
    public String save(@Validated InsertRequestModel insertModel, BindingResult bindingResult, HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            log.info("MbtiController.save.errors={} ", bindingResult);
            return "redirect:" + request.getHeader("Referer");
        }
        mbtiService.save(insertModel);
        return "redirect:/mbti/list";
    }

    @GetMapping("/update/{mbtiId}")
    public String update(@PathVariable Long mbtiId, Model model) {
        model.addAttribute("info", mbtiService.find(mbtiId));
        return "/mbti/update";
    }

    @PostMapping("/update")
    public String update(@Validated UpdateRequestModel updateModel, BindingResult bindingResult, HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            log.info("MbtiController.update.errors={} ", bindingResult);
            return "redirect:" + request.getHeader("Referer");
        }
        mbtiService.update(updateModel);
        return "redirect:/mbti/list";
    }

    @GetMapping("/list")
    public void findAll(Model model) {
        model.addAttribute("list", mbtiService.findAll());
    }

    @GetMapping("/find/{mbtiId}")
    public String find(@PathVariable Long mbtiId, Model model) {
        model.addAttribute("info", mbtiService.find(mbtiId));
        return "/mbti/view";
    }

    @GetMapping("/delete/{mbtiId}")
    public String delete(@PathVariable Long mbtiId) {
        mbtiService.delete(mbtiId);
        return "redirect:/mbti/list";
    }

    @GetMapping("/mbtiCheckForm")
    public String mbtiCheckFrom() {
        return "/mbti/mbtiCheck";
    }

    @PostMapping("/mbtiCheck")
    public String mbtiCheck(@ModelAttribute @Validated MbtiResultRequestModel mbtiData, HttpSession session, RedirectAttributes rttr) {
        rttr.addFlashAttribute("mbtiResult", mbtiService.mbtiCheck(mbtiData, session));
        return "redirect:/member/myMbti";
    }
}
