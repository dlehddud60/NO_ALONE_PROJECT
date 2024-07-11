package com.dongyoung.noAlone.like.model;

import com.dongyoung.noAlone.like.entity.LikeDivision;

public record FindRequestLikeModel(
        Long commentId,
        Long commentReId,
        LikeDivision likeDivision
) {
}
