package com.dongyoung.noAlone.accept.controller;

import com.dongyoung.noAlone.accept.service.AcceptService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/accept")
public class AcceptController {
    private final AcceptService acceptService;

    @GetMapping("/delete/{acceptId}")
    public String delete(@PathVariable(value = "acceptId") Long acceptId) {
        acceptService.delete(acceptId);
        return "redirect:/meeting/list";
    }
}
