package com.dongyoung.noAlone.board.controller;

import com.dongyoung.noAlone.board.entity.Board;
import com.dongyoung.noAlone.board.model.*;
import com.dongyoung.noAlone.board.service.BoardService;
import com.dongyoung.noAlone.category.service.CategoryService;
import com.dongyoung.noAlone.member.entity.Member;
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

    @GetMapping("/list")
    public String findAll(Model model, SearchCondition search, @PageableDefault(size = 10) Pageable pageable, FindCategorySort category) {
        if (category.categoryId() == null || category.categoryId() == 0) {
            return "redirect:/board/list?categoryId=1";
        }
        model.addAttribute("maxPage", 10);
        model.addAttribute("list", boardService.findAllByQueryDsl(search, pageable, category));
        return "board/list";
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
        return "redirect:/board/list?categoryId=" + boardModel.categoryId();
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
