package com.example.demo.exception;

import com.example.demo.helper.ErrorCode;

import lombok.Getter;

@Getter
public class BaseException extends RuntimeException {  
  
  private final ErrorCode errorCode;  
  
  public BaseException(String message, ErrorCode errorCode) {  
    super(message);  
    this.errorCode = errorCode;  
  }  
  
  @Override  
  public synchronized Throwable fillInStackTrace() {  
    return this;  
  }  
}