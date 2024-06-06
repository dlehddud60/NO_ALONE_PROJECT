package com.dongyoung.noAlone.common.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QDateTime is a Querydsl query type for DateTime
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QDateTime extends BeanPath<DateTime> {

    private static final long serialVersionUID = -266166114L;

    public static final QDateTime dateTime = new QDateTime("dateTime");

    public final DatePath<java.time.LocalDate> inputDt = createDate("inputDt", java.time.LocalDate.class);

    public final DatePath<java.time.LocalDate> updateDt = createDate("updateDt", java.time.LocalDate.class);

    public QDateTime(String variable) {
        super(DateTime.class, forVariable(variable));
    }

    public QDateTime(Path<? extends DateTime> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDateTime(PathMetadata metadata) {
        super(DateTime.class, metadata);
    }

}

