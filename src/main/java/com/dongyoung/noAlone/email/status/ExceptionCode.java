package com.dongyoung.noAlone.email.status;

public enum ExceptionCode {
    CODE_ISSUANCE_UNAVAILABLE("CODE_ISSUANCE_UNAVAILABLE", "Code issuance is currently unavailable."),
    MAIL_SEND_ERROR("MAIL_SEND_ERROR", "An error occurred while sending email.");


    private final String code;
    private final String message;

    ExceptionCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
