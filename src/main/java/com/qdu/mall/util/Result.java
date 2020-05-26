package com.qdu.mall.util;

import java.io.Serializable;

/**
 * @ClassName: com.qdu.mall.util.Result.java
 * @Description: 封装返回参数
 * @author: ZhangJunqing
 * @date:  2020-04-12 15:42
 * @version V1.0
 */
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    //状态码
    private int resultCode;
    //返回信息
    private String message;
    //返回的数据结果
    private T data;

    public Result() {
    }

    public Result(int resultCode, String message) {
        this.resultCode = resultCode;
        this.message = message;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "resultCode=" + resultCode +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
