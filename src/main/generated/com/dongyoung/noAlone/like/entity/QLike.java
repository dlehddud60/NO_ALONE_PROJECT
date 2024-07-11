package com.dongyoung.noAlone.like.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QLike is a Querydsl query type for Like
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QLike extends EntityPathBase<Like> {

    private static final long serialVersionUID = -448728954L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QLike like = new QLike("like1");

    public final com.dongyoung.noAlone.common.entity.QBaseTimeEntity _super = new com.dongyoung.noAlone.common.entity.QBaseTimeEntity(this);

    public final com.dongyoung.noAlone.comment.entity.QComment comment;

    public final com.dongyoung.noAlone.commentRe.entity.QCommentRe commentRe;

    //inherited
    public final DatePath<java.time.LocalDate> inputDt = _super.inputDt;

    public final NumberPath<Long> likesId = createNumber("likesId", Long.class);

    public final com.dongyoung.noAlone.member.entity.QMember member;

    //inherited
    public final DatePath<java.time.LocalDate> updateDt = _super.updateDt;

    public QLike(String variable) {
        this(Like.class, forVariable(variable), INITS);
    }

    public QLike(Path<? extends Like> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QLike(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QLike(PathMetadata metadata, PathInits inits) {
        this(Like.class, metadata, inits);
    }

    public QLike(Class<? extends Like> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.comment = inits.isInitialized("comment") ? new com.dongyoung.noAlone.comment.entity.QComment(forProperty("comment"), inits.get("comment")) : null;
        this.commentRe = inits.isInitialized("commentRe") ? new com.dongyoung.noAlone.commentRe.entity.QCommentRe(forProperty("commentRe"), inits.get("commentRe")) : null;
        this.member = inits.isInitialized("member") ? new com.dongyoung.noAlone.member.entity.QMember(forProperty("member"), inits.get("member")) : null;
    }

}

