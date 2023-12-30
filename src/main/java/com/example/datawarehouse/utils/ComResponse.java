package com.example.datawarehouse.utils;

import com.example.datawarehouse.common.ResponseCode;
import lombok.Builder;
import lombok.Data;

/**
 * @author sty
 */
@Data
@Builder
public class ComResponse<T> {

    public static <T> ComResponse success(T data, Long runTime) {
        return ComResponse.builder()
                .code(ResponseCode.SUCCESS.getCode())
                .msg(ResponseCode.SUCCESS.getMessage())
                .runTime(runTime)
                .data(data).build();
    }

    public static <T> ComResponse success() {
        return ComResponse.builder()
                .code(ResponseCode.SUCCESS.getCode())
                .msg(ResponseCode.SUCCESS.getMessage())
                .data("").build();
    }

    public static <T> ComResponse error() {
        return ComResponse.builder()
                .code(ResponseCode.SYSTEM_ERROR.getCode())
                .msg(ResponseCode.SYSTEM_ERROR.getMessage())
                .build();
    }

    public static <T> ComResponse error(String code, String msg) {
        return ComResponse.builder()
                .code(Integer.parseInt(code))
                .msg(msg)
                .build();
    }

    public static <T> ComResponse error(String msg) {
        return ComResponse.builder()
                .code(ResponseCode.SYSTEM_ERROR.getCode())
                .msg(msg)
                .build();
    }

    public static <T> ComResponse invalid(String message) {
        return ComResponse.builder()
                .code(ResponseCode.BAD_REQUEST.getCode())
                .msg(message)
                .build();
    }

    public static <T> ComResponse authFaild( String message ) {
        return ComResponse.builder()
                .code(ResponseCode.NOT_LOGIN.getCode())
                .msg(message)
                .build();
    }

    public static <T> ComResponse authFaild() {
        return ComResponse.builder()
                .code( ResponseCode.NOT_LOGIN.getCode() )
                .msg( ResponseCode.NOT_LOGIN.getMessage() )
                .build();
    }

    public static <T> ComResponse invalid() {
        return invalid(ResponseCode.BAD_REQUEST.getMessage());
    }

    private Integer code;

    private String msg;

    private T data;

    private Long runTime;

    public ComResponse(Integer code, String msg, T data, Long runTime) {
        this.code  = code;
        this.msg   = msg;
        this.data  = data;
        this.runTime = runTime;
    }

    public ComResponse(){}

}


