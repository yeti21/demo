package com.example.demo.constant;


import lombok.Data;
import lombok.Getter;

@Getter
public enum Status {

    OK(200,"成功"),
    UNKNOWN_ERROR(500,"服务器出错");

    private Integer Code;
    private String meggage;

    Status(Integer code, String meggage) {
        Code = code;
        this.meggage = meggage;
    }

}
