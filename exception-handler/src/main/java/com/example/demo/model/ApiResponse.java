package com.example.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ApiResponse {
    private Integer code;
    private String message;
    private Object data;

    public ApiResponse(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public  static ApiResponse a(Integer code, String message, Object data){
        return new ApiResponse(code,message,data);
    }

    public void b(){

    }


}
