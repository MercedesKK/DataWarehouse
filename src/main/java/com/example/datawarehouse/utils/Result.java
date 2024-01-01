package com.example.datawarehouse.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {
    private boolean IsSuccess;
    private T result;
    private String msg;
    private long runtime;
    private int listNum;

    public static <T> Result<T> success(T res,String message,long time,int num) {
        return new Result<>(true, res, message,time,num);
    }

    public static <T> Result<T> fail( String message) {
        return new Result<>(false, null ,message,0,0);
    }
}
