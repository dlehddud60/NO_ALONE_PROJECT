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

    public final ListPath<com.dongyoung.noAlone.accept.entity.Accept, com.dongyoung.noAlone.accept.entity.QAccept> accepts = this.<com.dongyoung.noAlone.accept.entity.Accept, com.dongyoung.noAlone.accept.entity.QAccept>createList("accepts", com.dongyoung.noAlone.accept.entity.Accept.class, com.dongyoung.noAlone.accept.entity.QAccept.class, PathInits.DIRECT2);

    public final StringPath content = createString("content");

    public final com.dongyoung.noAlone.common.entity.QDateTime dateTime;

    public final StringPath location = createString("location");

    public final NumberPath<Long> meetingId = createNumber("meetingId", Long.class);

    public final StringPath name = createString("name");

    public final com.dongyoung.noAlone.owner.entity.QOwner owner;

    public final StringPath question = createString("question");

    public final StringPath rule = createString("rule");

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
        this.dateTime = inits.isInitialized("dateTime") ? new com.dongyoung.noAlone.common.entity.QDateTime(forProperty("dateTime")) : null;
        this.owner = inits.isInitialized("owner") ? new com.dongyoung.noAlone.owner.entity.QOwner(forProperty("owner"), inits.get("owner")) : null;
    }

}

