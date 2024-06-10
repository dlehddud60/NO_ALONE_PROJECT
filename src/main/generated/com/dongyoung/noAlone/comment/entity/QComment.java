package com.dongyoung.noAlone.comment.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QComment is a Querydsl query type for Comment
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QComment extends EntityPathBase<Comment> {

    private static final long serialVersionUID = -1956961314L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QComment comment = new QComment("comment");

    public final com.dongyoung.noAlone.board.entity.QBoard board;

    public final NumberPath<Long> commentId = createNumber("commentId", Long.class);

    public final StringPath content = createString("content");

    public final com.dongyoung.noAlone.common.entity.QDateTime dateTime;

    public final com.dongyoung.noAlone.member.entity.QMember member;

    public QComment(String variable) {
        this(Comment.class, forVariable(variable), INITS);
    }

    public QComment(Path<? extends Comment> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QComment(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QComment(PathMetadata metadata, PathInits inits) {
        this(Comment.class, metadata, inits);
    }

    public QComment(Class<? extends Comment> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.board = inits.isInitialized("board") ? new com.dongyoung.noAlone.board.entity.QBoard(forProperty("board"), inits.get("board")) : null;
        this.dateTime = inits.isInitialized("dateTime") ? new com.dongyoung.noAlone.common.entity.QDateTime(forProperty("dateTime")) : null;
        this.member = inits.isInitialized("member") ? new com.dongyoung.noAlone.member.entity.QMember(forProperty("member"), inits.get("member")) : null;
    }

}

