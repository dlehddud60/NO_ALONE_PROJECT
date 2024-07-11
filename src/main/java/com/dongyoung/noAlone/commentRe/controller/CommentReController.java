package com.dongyoung.noAlone.commentRe.controller;

import com.dongyoung.noAlone.comment.model.UpdateRequestCommentModel;
import com.dongyoung.noAlone.commentRe.model.FindResponseCommentReListModel;
import com.dongyoung.noAlone.commentRe.model.InsertRequestCommentReModel;
import com.dongyoung.noAlone.commentRe.service.CommentReService;
import com.dongyoung.noAlone.common.entity.BaseTimeEntity;
import com.dongyoung.noAlone.member.entity.Member;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/commentRe")
@Log4j2
public class CommentReController extends BaseTimeEntity {

    private final CommentReService commentReService;

    @GetMapping("/list/{commentId}")
    public List<FindResponseCommentReListModel> list(@PathVariable("commentId") Long commentId) {
        return commentReService.findAll(commentId);
    }

    @PostMapping("/save")
    public void save(InsertRequestCommentReModel commentRe, HttpSession session) {
        Member member = (Member) session.getAttribute("member"); //필터에서 거르기 white리스트 onwer리스트 만들기
        commentReService.save(commentRe, member.getMemberId());
    }

    @PutMapping("/update/{commentReId}")
    public void update(UpdateRequestCommentModel comment, @PathVariable("commentReId") Long commentReId) {
        commentReService.update(comment, commentReId);
    }

    @DeleteMapping("/delete/{commentReId}")
    public void delete(@PathVariable("commentReId") Long commentReId) {
        commentReService.delete(commentReId);
    }

}
