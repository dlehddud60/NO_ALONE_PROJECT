package com.dongyoung.noAlone.meeting.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMeeting is a Querydsl query type for Meeting
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMeeting extends EntityPathBase<Meeting> {

    private static final long serialVersionUID = 1318350942L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMeeting meeting = new QMeeting("meeting");

    public final com.dongyoung.noAlone.common.entity.QBaseTimeEntity _super = new com.dongyoung.noAlone.common.entity.QBaseTimeEntity(this);

    public final ListPath<com.dongyoung.noAlone.accept.entity.Accept, com.dongyoung.noAlone.accept.entity.QAccept> accepts = this.<com.dongyoung.noAlone.accept.entity.Accept, com.dongyoung.noAlone.accept.entity.QAccept>createList("accepts", com.dongyoung.noAlone.accept.entity.Accept.class, com.dongyoung.noAlone.accept.entity.QAccept.class, PathInits.DIRECT2);

    public final com.dongyoung.noAlone.category.entity.QCategory category;

    public final StringPath content = createString("content");

    //inherited
    public final DatePath<java.time.LocalDate> inputDt = _super.inputDt;

    public final StringPath location = createString("location");

    public final NumberPath<Long> meetingId = createNumber("meetingId", Long.class);

    public final StringPath name = createString("name");

    public final com.dongyoung.noAlone.owner.entity.QOwner owner;

    public final StringPath question = createString("question");

    public final StringPath rule = createString("rule");

    //inherited
    public final DatePath<java.time.LocalDate> updateDt = _super.updateDt;

    public QMeeting(String variable) {
        this(Meeting.class, forVariable(variable), INITS);
    }

    public QMeeting(Path<? extends Meeting> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMeeting(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMeeting(PathMetadata metadata, PathInits inits) {
        this(Meeting.class, metadata, inits);
    }

    public QMeeting(Class<? extends Meeting> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.category = inits.isInitialized("category") ? new com.dongyoung.noAlone.category.entity.QCategory(forProperty("category"), inits.get("category")) : null;
        this.owner = inits.isInitialized("owner") ? new com.dongyoung.noAlone.owner.entity.QOwner(forProperty("owner"), inits.get("owner")) : null;
    }

}

