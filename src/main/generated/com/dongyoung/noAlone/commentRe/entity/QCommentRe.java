package com.dongyoung.noAlone.commentRe.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCommentRe is a Querydsl query type for CommentRe
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCommentRe extends EntityPathBase<CommentRe> {

    private static final long serialVersionUID = 1608885694L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCommentRe commentRe = new QCommentRe("commentRe");

    public final com.dongyoung.noAlone.comment.entity.QComment comment;

    public final NumberPath<Long> commentReId = createNumber("commentReId", Long.class);

    public final StringPath content = createString("content");

    public final com.dongyoung.noAlone.common.entity.QDateTime dateTime;

    public final com.dongyoung.noAlone.member.entity.QMember member;

    public QCommentRe(String variable) {
        this(CommentRe.class, forVariable(variable), INITS);
    }

    public QCommentRe(Path<? extends CommentRe> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCommentRe(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCommentRe(PathMetadata metadata, PathInits inits) {
        this(CommentRe.class, metadata, inits);
    }

    public QCommentRe(Class<? extends CommentRe> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.comment = inits.isInitialized("comment") ? new com.dongyoung.noAlone.comment.entity.QComment(forProperty("comment"), inits.get("comment")) : null;
        this.dateTime = inits.isInitialized("dateTime") ? new com.dongyoung.noAlone.common.entity.QDateTime(forProperty("dateTime")) : null;
        this.member = inits.isInitialized("member") ? new com.dongyoung.noAlone.member.entity.QMember(forProperty("member"), inits.get("member")) : null;
    }

}

