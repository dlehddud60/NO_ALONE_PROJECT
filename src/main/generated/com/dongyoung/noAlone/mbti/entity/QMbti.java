package com.dongyoung.noAlone.mbti.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMbti is a Querydsl query type for Mbti
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMbti extends EntityPathBase<Mbti> {

    private static final long serialVersionUID = -55872916L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMbti mbti = new QMbti("mbti");

    public final com.dongyoung.noAlone.common.entity.QDateTime dateTime;

    public final StringPath description = createString("description");

    public final NumberPath<Long> mbtiId = createNumber("mbtiId", Long.class);

    public final ListPath<com.dongyoung.noAlone.member.entity.Member, com.dongyoung.noAlone.member.entity.QMember> members = this.<com.dongyoung.noAlone.member.entity.Member, com.dongyoung.noAlone.member.entity.QMember>createList("members", com.dongyoung.noAlone.member.entity.Member.class, com.dongyoung.noAlone.member.entity.QMember.class, PathInits.DIRECT2);

    public final StringPath name = createString("name");

    public QMbti(String variable) {
        this(Mbti.class, forVariable(variable), INITS);
    }

    public QMbti(Path<? extends Mbti> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMbti(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMbti(PathMetadata metadata, PathInits inits) {
        this(Mbti.class, metadata, inits);
    }

    public QMbti(Class<? extends Mbti> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.dateTime = inits.isInitialized("dateTime") ? new com.dongyoung.noAlone.common.entity.QDateTime(forProperty("dateTime")) : null;
    }

}

