package com.sparta.global.domain.exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends CommonException {
    public NotFoundException() {
        this("NotFound");
        setErrorCode(true); // 메세지로 관리되는 메세지
    }

    public NotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }

}
