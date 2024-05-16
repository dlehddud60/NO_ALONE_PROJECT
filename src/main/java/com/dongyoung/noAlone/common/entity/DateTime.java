package com.dongyoung.noAlone.common.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class DateTime {

    @Column(name = "INPUT_DT", updatable = false)
    private LocalDate inputDt;

    @Column(name = "UPDATE_DT",insertable = false)
    private LocalDate updateDt;
}
