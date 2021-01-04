package com.example.demo.exception;

import com.example.demo.constant.Status;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Data
public class JsonException extends RuntimeException{

    private Status status;

    public JsonException(Status status) {
        this.status=status;

    }


}
