package com.dongyoung.noAlone.board.controller;

import com.dongyoung.noAlone.accept.model.FindResponseAcceptModel;
import com.dongyoung.noAlone.accept.service.AcceptService;
import com.dongyoung.noAlone.board.entity.Board;
import com.dongyoung.noAlone.board.model.*;
import com.dongyoung.noAlone.board.service.BoardService;
import com.dongyoung.noAlone.category.service.CategoryService;
import com.dongyoung.noAlone.member.entity.Member;
import com.dongyoung.noAlone.owner.model.FindResponseOwnerModel;
import com.dongyoung.noAlone.owner.service.OwnerService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
@Log4j2
public class BoardController {
    private final BoardService boardService;
    private final CategoryService categoryService;
    private final AcceptService acceptService;
    private final OwnerService ownerService;

    @GetMapping("/list")
    public String findAll(Model model, SearchCondition search, @PageableDefault(size = 10) Pageable pageable, FindCategorySort category, HttpSession session) {
        Member member = (Member) session.getAttribute("member"); //필터에서 거르기 white리스트 onwer리스트 만들기
        if ((category.categoryId() == null || category.categoryId() == 0) ||
                (!isValidCategory(category.categoryId()) && (category.meetingId() == null || category.meetingId() == 0))) {
            return "redirect:/board/list?categoryId=1";
        }

        if(!isValidCategory(category.categoryId())) {
            FindResponseAcceptModel acceptModel = acceptService.findByMeeting_MeetingIdAndMember_MemberId(category.meetingId(), member.getMemberId());
            FindResponseOwnerModel ownerModel = ownerService.find(category.meetingId(), member.getMemberId());
            log.info("==============ownerModel=============={}", ownerModel);
            if (ownerModel == null && (acceptModel == null || !acceptModel.status().name().equals("GRANT"))) {
                return "redirect:/board/list?categoryId=1";
            }
        }
        model.addAttribute("maxPage", 10);
        model.addAttribute("list", boardService.findAllByQueryDsl(search, pageable, category));
        return "board/list";
    }

    private boolean isValidCategory(Long categoryId) {
        return categoryId == 1 || categoryId == 2 || categoryId == 3;
    }

    @GetMapping("/find/{boardId}")
    public String find(@PathVariable(value = "boardId") Long boardId, Model model) {
        boardService.updateCount(boardId);
        model.addAttribute("info", boardService.find(boardId));
        return "board/view";
    }

    @GetMapping("/save")
    public String saveForm(Model model) {
        model.addAttribute("categoryList", categoryService.findAll());
        return "board/saveForm";
    }

    @PostMapping("/save")
    public String save(InsertRequestBoardModel boardModel, HttpSession session) {
        Member member = (Member) session.getAttribute("member"); //필터에서 거르기 white리스트 onwer리스트 만들기
        boardService.save(boardModel, member);
        return "redirect:/board/list?categoryId=" + boardModel.categoryId() + "&meetingId=" + boardModel.meetingId();
    }

    @GetMapping("/update/{boardId}")
    public String updateForm(@PathVariable(value = "boardId") Long boardId, Model model) {
        model.addAttribute("info", boardService.find(boardId));
        return "board/updateForm";
    }

    @PostMapping("/update")
    public String update(UpdateRequestBoardModel boardModel) {
        boardService.update(boardModel);
        return "redirect:/board/list";
    }

    @GetMapping("/delete/{boardId}")
    public String delete(@PathVariable(value = "boardId") Long boardId) {
        boardService.delete(boardId);
        return "redirect:/board/list";
    }
}