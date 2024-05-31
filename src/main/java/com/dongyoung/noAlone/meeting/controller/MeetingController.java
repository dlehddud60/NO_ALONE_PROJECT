package com.dongyoung.noAlone.meeting.controller;

import com.dongyoung.noAlone.accept.model.FindRequestAcceptAppliModel;
import com.dongyoung.noAlone.meeting.model.FindRequestInsertMeetingModel;
import com.dongyoung.noAlone.meeting.model.FindRequestUpdateMeetingModel;
import com.dongyoung.noAlone.meeting.model.FindResponseMeetingAndOwnerModel;
import com.dongyoung.noAlone.meeting.service.MeetingService;
import com.dongyoung.noAlone.member.entity.Member;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j2
@Controller
@RequiredArgsConstructor
@RequestMapping("/meeting")
public class MeetingController {
    private final MeetingService meetingService;


    @GetMapping("/list")
    public String findAll(Model model) {
        model.addAttribute("list",meetingService.findAll());
        return "/meeting/list";
    }

    @GetMapping("/find/{meetingId}")
    public String find(@PathVariable Long meetingId,Model model) {
        FindResponseMeetingAndOwnerModel meetingAndOwnerModel = meetingService.find(meetingId);
        model.addAttribute("info",meetingAndOwnerModel);
        model.addAttribute("owner",meetingAndOwnerModel.ownerWithMeetingModel().memberModel());
        return "/meeting/view";
    }


    @GetMapping("/write")
    public String write() {
        return "/meeting/write";
    }

    @PostMapping("/save")
    public String save(FindRequestInsertMeetingModel meetingModel) {

        meetingService.save(meetingModel);
        return "redirect:/meeting/list";
    }

    @GetMapping("/update/{meetingId}")
    public String update(@PathVariable Long meetingId, Model model) {
        model.addAttribute("info",meetingService.find(meetingId));
        return "/meeting/update";
    }

    @PostMapping("/update")
    public String update(FindRequestUpdateMeetingModel meetingModel) {
        meetingService.update(meetingModel);
        return "redirect:/meeting/list";
    }

    @GetMapping("/delete/{meetingId}")
    public String delete(@PathVariable Long meetingId) {
        meetingService.delete(meetingId);
        return "redirect:/meeting/list";
    }


    @GetMapping("/meetAppli/{meetingId}")
    public String meetAppli(@PathVariable Long meetingId ,Model model) {
        model.addAttribute("meeting",meetingService.find(meetingId));

        return "/meeting/meetAppli";
    }

    @PostMapping("/meetAppli")
    public String meetAppli(FindRequestAcceptAppliModel appliModel) {
        meetingService.meetAppli(appliModel);
        return "redirect:/meeting/list";
    }




}
