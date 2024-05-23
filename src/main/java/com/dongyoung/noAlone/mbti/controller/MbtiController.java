package com.dongyoung.noAlone.mbti.controller;

import com.dongyoung.noAlone.mbti.entity.Mbti;
import com.dongyoung.noAlone.mbti.model.FindRequestInsertModel;
import com.dongyoung.noAlone.mbti.model.FindRequestMbtiDataModel;
import com.dongyoung.noAlone.mbti.model.FindRequestUpdateModel;
import com.dongyoung.noAlone.mbti.model.FindResponseMbtiModel;
import com.dongyoung.noAlone.mbti.service.MbtiService;
import com.dongyoung.noAlone.member.repository.MemberRepository;
import com.dongyoung.noAlone.member.service.MemberService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
@RequestMapping("/mbti")
@Log4j2
public class MbtiController {
    private final MbtiService mbtiService;



    @GetMapping("/write")
    public String write() {
        return "/mbti/write";
    }
    @PostMapping("/save")
    public String save(FindRequestInsertModel insertModel) {
        mbtiService.save(insertModel);
        return "redirect:/mbti/list";
    }
    @GetMapping("/update/{mbtiId}")
    public String update(@PathVariable Long mbtiId,Model model) {
        model.addAttribute("info",mbtiService.find(mbtiId));
        return "/mbti/update";
    }

    @PostMapping("/update")
    public String update(FindRequestUpdateModel updateModel) {
        mbtiService.update(updateModel);
        return "redirect:/mbti/list";
    }
    @GetMapping("/list")
    public void findAll(Model model) {
        model.addAttribute("list", mbtiService.findAll());
    }
    @GetMapping("/find/{mbtiId}")
    public String find(@PathVariable Long mbtiId ,Model model) {
        model.addAttribute("info",mbtiService.find(mbtiId));
        return "/mbti/view";
    }
    @GetMapping("/delete/{mbtiId}")
    public String  delete(@PathVariable Long mbtiId) {
        mbtiService.delete(mbtiId);
        return "redirect:/mbti/list";
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
