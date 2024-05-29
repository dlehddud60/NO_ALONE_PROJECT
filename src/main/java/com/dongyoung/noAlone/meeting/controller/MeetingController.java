package com.dongyoung.noAlone.meeting.controller;

import com.dongyoung.noAlone.meeting.model.FindRequestInsertMeetingModel;
import com.dongyoung.noAlone.meeting.model.FindRequestUpdateMeetingModel;
import com.dongyoung.noAlone.meeting.service.MeetingService;
import com.dongyoung.noAlone.member.entity.Member;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
        model.addAttribute("info",meetingService.find(meetingId));
        return "/meeting/view";
    }


    @GetMapping("/write")
    public String write() {
        return "/meeting/write";
    }

    @PostMapping("/save")
    public String save(FindRequestInsertMeetingModel meetingModel, HttpSession session) {

        meetingService.save(meetingModel,session);
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




}
