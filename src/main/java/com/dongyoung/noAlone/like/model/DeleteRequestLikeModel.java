package com.dongyoung.noAlone.like.model;

import com.dongyoung.noAlone.like.entity.LikeDivision;

public record DeleteRequestLikeModel(
        Long commentId,
        Long commentReId,
        Long memberId,
        LikeDivision likeDivision

) {
}
