package com.sparta.global.presentation;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class JSONErrorResponse {
    private HttpStatus status;
    private Object message;
}
