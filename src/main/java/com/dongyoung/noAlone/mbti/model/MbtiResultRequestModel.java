package com.dongyoung.noAlone.mbti.model;


import jakarta.validation.constraints.*;

// E,I / N,S / T,F / P,J
public record MbtiResultRequestModel(
        @Max(value = 3, message = "잘못된 값이 선택되었습니다.")
        @NotNull(message = "MBTI의 질문이 정상적으로 선택되지 않았습니다.")
        Integer E,
        @Max(value = 3, message = "잘못된 값이 선택되었습니다.")
        @NotNull(message = "MBTI의 질문이 정상적으로 선택되지 않았습니다.")
        Integer I,
        @Max(value = 3, message = "잘못된 값이 선택되었습니다.")
        @NotNull(message = "MBTI의 질문이 정상적으로 선택되지 않았습니다.")
        Integer N,
        @Max(value = 3, message = "잘못된 값이 선택되었습니다.")
        @NotNull(message = "MBTI의 질문이 정상적으로 선택되지 않았습니다.")
        Integer S,
        @Max(value = 3, message = "잘못된 값이 선택되었습니다.")
        @NotNull(message = "MBTI의 질문이 정상적으로 선택되지 않았습니다.")
        Integer T,
        @Max(value = 3, message = "잘못된 값이 선택되었습니다.")
        @NotNull(message = "MBTI의 질문이 정상적으로 선택되지 않았습니다.")
        Integer F,
        @Max(value = 3, message = "잘못된 값이 선택되었습니다.")
        @NotNull(message = "MBTI의 질문이 정상적으로 선택되지 않았습니다.")
        Integer P,
        @Max(value = 3, message = "잘못된 값이 선택되었습니다.")
        @NotNull(message = "MBTI의 질문이 정상적으로 선택되지 않았습니다.")
        Integer J) {
}
