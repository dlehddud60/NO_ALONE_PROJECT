package com.dongyoung.noAlone.like.controller;

import com.dongyoung.noAlone.like.model.CountRequestLikeModel;
import com.dongyoung.noAlone.like.model.DeleteRequestLikeModel;
import com.dongyoung.noAlone.like.model.FindRequestLikeModel;
import com.dongyoung.noAlone.like.model.InsertRequestLikeModel;
import com.dongyoung.noAlone.like.service.LikeService;
import com.dongyoung.noAlone.member.entity.Member;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/like")
@Log4j2
public class LikeController {
    private final LikeService likeService;


    @GetMapping("/myLike")
    public Boolean myLike(FindRequestLikeModel like, HttpSession session) {
        Member member = (Member) session.getAttribute("member");
        return likeService.myLike(like, member.getMemberId());
    }

    @GetMapping("/count")
    public Integer count(CountRequestLikeModel countRequestLikeModel) {
        return likeService.count(countRequestLikeModel);
    }

    @PostMapping("/save")
    public void like(InsertRequestLikeModel likeRequest, HttpSession session) { //requestBody
        Member member = (Member) session.getAttribute("member");
        likeService.save(likeRequest, member.getMemberId());
    }

    @DeleteMapping("/delete")
    public void delete(DeleteRequestLikeModel likeRequest, HttpSession session) {
        Member member = (Member) session.getAttribute("member");
        likeService.delete(likeRequest, member.getMemberId());
    }

}
