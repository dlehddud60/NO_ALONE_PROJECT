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

    public final NumberPath<Long> commentReId = createNumber("commentReId", Long.class);

    public final StringPath content = createString("content");

    public final com.dongyoung.noAlone.common.entity.QDateTime dateTime;

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
        this.dateTime = inits.isInitialized("dateTime") ? new com.dongyoung.noAlone.common.entity.QDateTime(forProperty("dateTime")) : null;
    }

}

