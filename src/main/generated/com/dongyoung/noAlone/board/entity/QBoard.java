package com.dongyoung.noAlone.board.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBoard is a Querydsl query type for Board
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBoard extends EntityPathBase<Board> {

    private static final long serialVersionUID = -1770549826L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QBoard board = new QBoard("board");

    public final com.dongyoung.noAlone.common.entity.QBaseTimeEntity _super = new com.dongyoung.noAlone.common.entity.QBaseTimeEntity(this);

    public final NumberPath<Long> boardId = createNumber("boardId", Long.class);

    public final com.dongyoung.noAlone.category.entity.QCategory category;

    public final ListPath<com.dongyoung.noAlone.comment.entity.Comment, com.dongyoung.noAlone.comment.entity.QComment> comments = this.<com.dongyoung.noAlone.comment.entity.Comment, com.dongyoung.noAlone.comment.entity.QComment>createList("comments", com.dongyoung.noAlone.comment.entity.Comment.class, com.dongyoung.noAlone.comment.entity.QComment.class, PathInits.DIRECT2);

    public final StringPath content = createString("content");

    //inherited
    public final DatePath<java.time.LocalDate> inputDt = _super.inputDt;

    public final com.dongyoung.noAlone.member.entity.QMember member;

    public final StringPath title = createString("title");

    //inherited
    public final DatePath<java.time.LocalDate> updateDt = _super.updateDt;

    public final NumberPath<Integer> views = createNumber("views", Integer.class);

    public QBoard(String variable) {
        this(Board.class, forVariable(variable), INITS);
    }

    public QBoard(Path<? extends Board> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QBoard(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QBoard(PathMetadata metadata, PathInits inits) {
        this(Board.class, metadata, inits);
    }

    public QBoard(Class<? extends Board> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.category = inits.isInitialized("category") ? new com.dongyoung.noAlone.category.entity.QCategory(forProperty("category"), inits.get("category")) : null;
        this.member = inits.isInitialized("member") ? new com.dongyoung.noAlone.member.entity.QMember(forProperty("member"), inits.get("member")) : null;
    }

}

