package com.dongyoung.noAlone.comment.controller;

import com.dongyoung.noAlone.comment.model.FindResponseCommentListModel;
import com.dongyoung.noAlone.comment.model.InsertRequestCommentModel;
import com.dongyoung.noAlone.comment.model.UpdateRequestCommentModel;
import com.dongyoung.noAlone.comment.service.CommentService;
import com.dongyoung.noAlone.member.entity.Member;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
@Log4j2
public class CommentController {
    private final CommentService commentService;

    @GetMapping("/list/{boardId}")
    public List<FindResponseCommentListModel> list(@PathVariable("boardId") Long boardId) {
        return commentService.findAll(boardId);
    }

    @PostMapping("/save")
    public void save(InsertRequestCommentModel comment, HttpSession session) {//requestBody
        Member member = (Member) session.getAttribute("member");
        commentService.save(comment, member.getMemberId());
    }

    @PutMapping("/update/{commentId}")
    public void update(UpdateRequestCommentModel comment, @PathVariable("commentId") Long commentId) {
        commentService.update(comment, commentId);
    }

    @DeleteMapping("/delete/{commentId}")
    public void delete(@PathVariable("commentId") Long commentId) {
        commentService.delete(commentId);
    }
}
