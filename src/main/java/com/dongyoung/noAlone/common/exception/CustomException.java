package com.dongyoung.noAlone.common.exception;

import com.dongyoung.noAlone.email.status.ExceptionCode;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


public class CustomException extends RuntimeException {
    public CustomException(ExceptionCode codeIssuanceUnavailable) {
    }
}

