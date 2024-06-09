package com.dongyoung.noAlone.category.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCategory is a Querydsl query type for Category
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCategory extends EntityPathBase<Category> {

    private static final long serialVersionUID = 1199102036L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCategory category = new QCategory("category");

    public final ListPath<com.dongyoung.noAlone.board.entity.Board, com.dongyoung.noAlone.board.entity.QBoard> boards = this.<com.dongyoung.noAlone.board.entity.Board, com.dongyoung.noAlone.board.entity.QBoard>createList("boards", com.dongyoung.noAlone.board.entity.Board.class, com.dongyoung.noAlone.board.entity.QBoard.class, PathInits.DIRECT2);

    public final NumberPath<Long> categoryId = createNumber("categoryId", Long.class);

    public final com.dongyoung.noAlone.common.entity.QDateTime dateTime;

    public final StringPath description = createString("description");

    public final com.dongyoung.noAlone.meeting.entity.QMeeting meeting;

    public final StringPath name = createString("name");

    public QCategory(String variable) {
        this(Category.class, forVariable(variable), INITS);
    }

    public QCategory(Path<? extends Category> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCategory(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCategory(PathMetadata metadata, PathInits inits) {
        this(Category.class, metadata, inits);
    }

    public QCategory(Class<? extends Category> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.dateTime = inits.isInitialized("dateTime") ? new com.dongyoung.noAlone.common.entity.QDateTime(forProperty("dateTime")) : null;
        this.meeting = inits.isInitialized("meeting") ? new com.dongyoung.noAlone.meeting.entity.QMeeting(forProperty("meeting"), inits.get("meeting")) : null;
    }

}

