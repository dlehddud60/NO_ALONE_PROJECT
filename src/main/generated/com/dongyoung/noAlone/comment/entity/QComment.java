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

    public final com.dongyoung.noAlone.common.entity.QBaseTimeEntity _super = new com.dongyoung.noAlone.common.entity.QBaseTimeEntity(this);

    public final com.dongyoung.noAlone.board.entity.QBoard board;

    public final NumberPath<Long> commentId = createNumber("commentId", Long.class);

    public final ListPath<com.dongyoung.noAlone.commentRe.entity.CommentRe, com.dongyoung.noAlone.commentRe.entity.QCommentRe> commentRes = this.<com.dongyoung.noAlone.commentRe.entity.CommentRe, com.dongyoung.noAlone.commentRe.entity.QCommentRe>createList("commentRes", com.dongyoung.noAlone.commentRe.entity.CommentRe.class, com.dongyoung.noAlone.commentRe.entity.QCommentRe.class, PathInits.DIRECT2);

    public final StringPath content = createString("content");

    //inherited
    public final DatePath<java.time.LocalDate> inputDt = _super.inputDt;

    public final com.dongyoung.noAlone.member.entity.QMember member;

    //inherited
    public final DatePath<java.time.LocalDate> updateDt = _super.updateDt;

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
        this.member = inits.isInitialized("member") ? new com.dongyoung.noAlone.member.entity.QMember(forProperty("member"), inits.get("member")) : null;
    }

}

