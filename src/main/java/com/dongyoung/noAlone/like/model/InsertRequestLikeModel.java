package com.dongyoung.noAlone.like.model;

import com.dongyoung.noAlone.like.entity.LikeDivision;

public record InsertRequestLikeModel(
        Long commentId,
        Long commentReId,
        LikeDivision likeDivision
) {
}
