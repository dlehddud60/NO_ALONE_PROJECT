package com.dongyoung.noAlone.meeting.controller;

import com.dongyoung.noAlone.accept.model.FindResponseAcceptModel;
import com.dongyoung.noAlone.accept.model.InsertRequestApplicationModel;
import com.dongyoung.noAlone.accept.service.AcceptService;
import com.dongyoung.noAlone.meeting.model.*;
import com.dongyoung.noAlone.meeting.service.MeetingService;
import com.dongyoung.noAlone.member.entity.Member;
import com.dongyoung.noAlone.owner.model.FindResponseOwnerModel;
import com.dongyoung.noAlone.owner.service.OwnerService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Log4j2
@Controller
@RequiredArgsConstructor
@RequestMapping("/meeting")
public class MeetingController {
    private final MeetingService meetingService;
    private final OwnerService ownerService;
    private final AcceptService acceptService;


    @GetMapping("/list")
    public String findAll(Model model, SearchCondition search, @PageableDefault(size = 5) Pageable pageable) {
        Page<FindResponseMeetingAndOwnerListModel> allByQueryDsl = meetingService.findAllByQueryDsl(search, pageable);
        model.addAttribute("list", allByQueryDsl);
        model.addAttribute("maxPage", 10);
        return "/meeting/list";
    }

    @GetMapping("/find/{meetingId}")
    public String find(@PathVariable(value = "meetingId") Long meetingId, Model model, HttpSession session) {
        FindResponseMeetingAndOwnerModel meetingAndOwnerModel = meetingService.find(meetingId);
        Member member = (Member) session.getAttribute("member");
        FindResponseOwnerModel owner = ownerService.find(meetingId, member.getMemberId());

        model.addAttribute("info", meetingAndOwnerModel);
        model.addAttribute("ownerInfo", meetingAndOwnerModel.ownerWithMeetingModel().memberModel());
        model.addAttribute("acceptDTO", acceptService.findByMeeting_MeetingIdAndMember_MemberId(meetingId, member.getMemberId()));
        model.addAttribute("ownerDTO", owner);
        return "/meeting/view";
    }

    @GetMapping("/save")
    public String saveForm() {
        return "/meeting/saveForm";
    }

    @PostMapping("/save")
    public String save(@Validated InsertRequestMeetingModel meetingModel, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.info("errors={} ", bindingResult);
            return "/meeting/saveForm";
        }
        meetingService.save(meetingModel);
        return "redirect:/meeting/list";
    }

    @GetMapping("/update/{meetingId}")
    public String update(@PathVariable(value = "meetingId") Long meetingId, Model model,HttpSession session) {
        FindResponseMeetingAndOwnerModel owner = meetingService.find(meetingId);
        Member member = (Member) session.getAttribute("member");
        if(!owner.ownerWithMeetingModel().memberModel().memberId().equals(member.getMemberId())) {
            return "redirect:/meeting/list";
        }
        model.addAttribute("info", owner);
        return "/meeting/update";
    }

    @PostMapping("/update")
    public String update(@Validated UpdateRequestMeetingModel meetingModel, BindingResult bindingResult, HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            log.info("errors={} ", bindingResult);
            return "redirect:" + request.getHeader("Referer");
        }
        meetingService.update(meetingModel);
        return "redirect:/meeting/list";
    }

    @GetMapping("/delete/{meetingId}")
    public String delete(@PathVariable(value = "meetingId") Long meetingId) {
        meetingService.delete(meetingId);
        return "redirect:/meeting/list";
    }


    @GetMapping("/application/{meetingId}")
    public String application(@PathVariable(value = "meetingId") Long meetingId, Model model, HttpSession session, RedirectAttributes rttr) {
        Member member = (Member) session.getAttribute("member");
        FindResponseAcceptModel accept = acceptService.findByMeeting_MeetingIdAndMember_MemberId(meetingId, member.getMemberId());
        FindResponseOwnerModel owner = ownerService.find(meetingId, member.getMemberId());
        if (accept != null || owner != null) {
            return "redirect:/meeting/list";
        }
        model.addAttribute("meeting", meetingService.find(meetingId));
        return "meeting/application";
    }

    @PostMapping("/application")
    public String application(@ModelAttribute @Validated InsertRequestApplicationModel applicationModel, BindingResult bindingResult, HttpServletRequest request, RedirectAttributes rttr) {
        if (bindingResult.hasErrors()) {
            log.info("errors={} ", bindingResult);
            rttr.addFlashAttribute("aboutMe", applicationModel.aboutMe());
            rttr.addFlashAttribute("companionReason", applicationModel.companionReason());
            //검증 시 데이터 유지위한 코드
            return "redirect:" + request.getHeader("Referer");
        }
        rttr.addFlashAttribute("insertMsg", "이미 가입하셨습니다.");
        meetingService.application(applicationModel);
        return "redirect:/meeting/list";
    }

    @GetMapping("/applicationList/{meetingId}")
    public String applicationList(Model model, @PathVariable(value = "meetingId") Long meetingId, HttpSession session) {
        Member member = (Member) session.getAttribute("member"); //필터에서 거르기 white리스트 onwer리스트 만들기
        FindResponseOwnerModel owner = ownerService.find(meetingId, member.getMemberId());
        model.addAttribute("list", meetingService.applicationList(meetingId));

        if (owner != null) {
            return "meeting/applicationList";
        } else {
            return "redirect:/meeting/list";
        }
    }

    @PostMapping("/changeStatus")
    public String changeStatus(@Validated ChangeStatusRequestModel statusModel, BindingResult bindingResult, HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            return "redirect:" + request.getHeader("Referer");
        }
        meetingService.changeStatus(statusModel);
        return "redirect:" + request.getHeader("Referer");
    }
}
