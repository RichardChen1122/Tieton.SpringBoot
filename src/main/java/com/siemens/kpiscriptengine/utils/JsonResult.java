package com.siemens.kpiscriptengine.utils;

import java.io.Serializable;

public class JsonResult<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer code; // 状态码 0 表示成功，1表示处理中，-1表示失败
    private T data; // 数据
    private String msg;// 描述

    public JsonResult() {
    }

    public JsonResult(Integer code, T data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    // 成功，传入数据
    public static <TResult> JsonResult<TResult> buildSuccess() {
        return new JsonResult<TResult>(0, null, null);
    }

    // 成功，传入数据
    public static <TResult> JsonResult<TResult> buildSuccess(TResult data) {
        return new JsonResult<TResult>(0, data, null);
    }

    // 失败，传入描述信息
    public static JsonResult<String> buildError(String msg) {
        return new JsonResult<String>(-1, null, msg);
    }

    // 失败，传入描述信息,状态码
    public static <TResult> JsonResult<TResult> buildError(String msg, Integer code) {
        return new JsonResult<TResult>(code, null, msg);
    }

    // 成功，传入数据,及描述信息
    public static <TResult> JsonResult<TResult> buildSuccess(TResult data, String msg) {
        return new JsonResult<TResult>(0, data, msg);
    }

    // 成功，传入数据,及状态码
    public static <TResult> JsonResult<TResult> buildSuccess(TResult data, int code) {
        return new JsonResult<TResult>(code, data, null);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "JsonResult [code=" + code + ", data=" + data + ", msg=" + msg + "]";
    }

}
