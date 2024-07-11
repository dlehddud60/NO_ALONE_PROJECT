package com.dongyoung.noAlone.like.service;

import com.dongyoung.noAlone.like.model.CountRequestLikeModel;
import com.dongyoung.noAlone.like.model.DeleteRequestLikeModel;
import com.dongyoung.noAlone.like.model.FindRequestLikeModel;
import com.dongyoung.noAlone.like.model.InsertRequestLikeModel;

public interface LikeService {
    void save(InsertRequestLikeModel likeRequest, Long member);


    void delete(DeleteRequestLikeModel likeRequest, Long member);


    Integer count(CountRequestLikeModel countRequestLikeModel);

    Boolean myLike(FindRequestLikeModel like, Long memberId);
}
