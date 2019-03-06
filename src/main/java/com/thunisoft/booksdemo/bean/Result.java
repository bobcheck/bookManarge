package com.thunisoft.booksdemo.bean;

import lombok.Data;

@Data
public class Result {
    private Integer code;
    private String message;

    private Result() {

    }

    public Result(Integer code, String message){
        this.code = code;
        this.message = message;
    }
}
