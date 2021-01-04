package com.example.demo.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class PageException extends RuntimeException{
    private Integer code;
    private String message;

    public PageException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
