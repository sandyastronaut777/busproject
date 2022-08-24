package com.busproject.busproject.util;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class APIResponse {

    private int statusCode;

    private String status;

    private String message;

    private Object object;

    public APIResponse(int statusCode, String status, String message, Object object) {
        this.statusCode = statusCode;
        this.status = status;
        this.message = message;
        this.object = object;
    }
}
