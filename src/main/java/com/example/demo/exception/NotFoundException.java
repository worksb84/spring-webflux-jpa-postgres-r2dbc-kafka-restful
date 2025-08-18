package com.example.demo.exception;

import com.example.demo.helper.ErrorCode;

import lombok.Getter;

@Getter
public class NotFoundException extends BaseException {

    private String value;

    public NotFoundException(String value) {
        this(value, ErrorCode.NOT_FOUND);
        this.value = value;
    }

    public NotFoundException(String message, ErrorCode errorCode) {
        super(message, errorCode);
        this.value = value;
    }

}
