package com.dummynode.cryptotrackingbackend.service;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiResponse<T> {
    private int code;
    private String message;
    private T data;
    private String error;
    private long timestamp;

    public ApiResponse(int code, String message, T data, String error) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.error = error;
        this.timestamp = System.currentTimeMillis();
    }
}
