package com.dongyoung.noAlone.accept.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAccept is a Querydsl query type for Accept
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAccept extends EntityPathBase<Accept> {

    private static final long serialVersionUID = -922624216L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAccept accept = new QAccept("accept");

    public final StringPath aboutMe = createString("aboutMe");

    public final NumberPath<Long> acceptId = createNumber("acceptId", Long.class);

    public final StringPath companionReason = createString("companionReason");

    public final com.dongyoung.noAlone.common.entity.QDateTime dateTime;

    public final com.dongyoung.noAlone.meeting.entity.QMeeting meeting;

    public final com.dongyoung.noAlone.member.entity.QMember member;

    public final EnumPath<Status> status = createEnum("status", Status.class);

    public QAccept(String variable) {
        this(Accept.class, forVariable(variable), INITS);
    }

    public QAccept(Path<? extends Accept> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAccept(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAccept(PathMetadata metadata, PathInits inits) {
        this(Accept.class, metadata, inits);
    }

    public QAccept(Class<? extends Accept> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.dateTime = inits.isInitialized("dateTime") ? new com.dongyoung.noAlone.common.entity.QDateTime(forProperty("dateTime")) : null;
        this.meeting = inits.isInitialized("meeting") ? new com.dongyoung.noAlone.meeting.entity.QMeeting(forProperty("meeting"), inits.get("meeting")) : null;
        this.member = inits.isInitialized("member") ? new com.dongyoung.noAlone.member.entity.QMember(forProperty("member"), inits.get("member")) : null;
    }

}

