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

    public static final QMbti mbti = new QMbti("mbti");

    public final com.dongyoung.noAlone.common.entity.QBaseTimeEntity _super = new com.dongyoung.noAlone.common.entity.QBaseTimeEntity(this);

    public final StringPath description = createString("description");

    //inherited
    public final DatePath<java.time.LocalDate> inputDt = _super.inputDt;

    public final NumberPath<Long> mbtiId = createNumber("mbtiId", Long.class);

    public final ListPath<com.dongyoung.noAlone.member.entity.Member, com.dongyoung.noAlone.member.entity.QMember> members = this.<com.dongyoung.noAlone.member.entity.Member, com.dongyoung.noAlone.member.entity.QMember>createList("members", com.dongyoung.noAlone.member.entity.Member.class, com.dongyoung.noAlone.member.entity.QMember.class, PathInits.DIRECT2);

    public final StringPath name = createString("name");

    //inherited
    public final DatePath<java.time.LocalDate> updateDt = _super.updateDt;

    public QMbti(String variable) {
        super(Mbti.class, forVariable(variable));
    }

    public QMbti(Path<? extends Mbti> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMbti(PathMetadata metadata) {
        super(Mbti.class, metadata);
    }

}

