package com.example.demo.helper;

import lombok.Getter;

@Getter
public enum ErrorCode {
    DUPLICATE("err-001", "duplicate"),
    NOT_FOUND("err-002", "not found"),
    INTERNAL_SERVER_ERROR("err-999", "server error");

    private final String code;
    private final String message;

    ErrorCode(final String code, final String message) {
        this.code = code;
        this.message = message;
    }
}
