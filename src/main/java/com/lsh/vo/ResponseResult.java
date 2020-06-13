package com.lsh.vo;

import lombok.Data;

@Data
public class ResponseResult {
    private String code;
    private String message;

    public ResponseResult(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
