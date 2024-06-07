package com.dongyoung.noAlone.member.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMember is a Querydsl query type for Member
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMember extends EntityPathBase<Member> {

    private static final long serialVersionUID = -1421778228L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMember member = new QMember("member1");

    public final ListPath<com.dongyoung.noAlone.accept.entity.Accept, com.dongyoung.noAlone.accept.entity.QAccept> accepts = this.<com.dongyoung.noAlone.accept.entity.Accept, com.dongyoung.noAlone.accept.entity.QAccept>createList("accepts", com.dongyoung.noAlone.accept.entity.Accept.class, com.dongyoung.noAlone.accept.entity.QAccept.class, PathInits.DIRECT2);

    public final NumberPath<Integer> age = createNumber("age", Integer.class);

    public final StringPath birthday = createString("birthday");

    public final StringPath birthyear = createString("birthyear");

    public final ListPath<com.dongyoung.noAlone.board.entity.Board, com.dongyoung.noAlone.board.entity.QBoard> boards = this.<com.dongyoung.noAlone.board.entity.Board, com.dongyoung.noAlone.board.entity.QBoard>createList("boards", com.dongyoung.noAlone.board.entity.Board.class, com.dongyoung.noAlone.board.entity.QBoard.class, PathInits.DIRECT2);

    public final com.dongyoung.noAlone.common.entity.QDateTime dateTime;

    public final StringPath email = createString("email");

    public final StringPath gender = createString("gender");

    public final StringPath id = createString("id");

    public final com.dongyoung.noAlone.mbti.entity.QMbti mbti;

    public final NumberPath<Long> memberId = createNumber("memberId", Long.class);

    public final StringPath mobile = createString("mobile");

    public final StringPath name = createString("name");

    public final StringPath nickname = createString("nickname");

    public final ListPath<com.dongyoung.noAlone.owner.entity.Owner, com.dongyoung.noAlone.owner.entity.QOwner> owners = this.<com.dongyoung.noAlone.owner.entity.Owner, com.dongyoung.noAlone.owner.entity.QOwner>createList("owners", com.dongyoung.noAlone.owner.entity.Owner.class, com.dongyoung.noAlone.owner.entity.QOwner.class, PathInits.DIRECT2);

    public final StringPath password = createString("password");

    public final StringPath profileImage = createString("profileImage");

    public final EnumPath<Role> role = createEnum("role", Role.class);

    public QMember(String variable) {
        this(Member.class, forVariable(variable), INITS);
    }

    public QMember(Path<? extends Member> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMember(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMember(PathMetadata metadata, PathInits inits) {
        this(Member.class, metadata, inits);
    }

    public QMember(Class<? extends Member> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.dateTime = inits.isInitialized("dateTime") ? new com.dongyoung.noAlone.common.entity.QDateTime(forProperty("dateTime")) : null;
        this.mbti = inits.isInitialized("mbti") ? new com.dongyoung.noAlone.mbti.entity.QMbti(forProperty("mbti"), inits.get("mbti")) : null;
    }

}

