package com.example.demo.exception;

import com.example.demo.helper.ErrorCode;

import lombok.Getter;

@Getter
public class DuplicateException extends BaseException {

    private String value;

    public DuplicateException(String value) {
        this(value, ErrorCode.DUPLICATE);
        this.value = value;
    }

    public DuplicateException(String message, ErrorCode errorCode) {
        super(message, errorCode);
        this.value = value;
    }

}
