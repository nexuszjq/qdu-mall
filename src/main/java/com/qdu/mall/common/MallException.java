package com.qdu.mall.common;

public class MallException extends RuntimeException {

    public MallException() {
    }

    public MallException(String message) {
        super(message);
    }

    /**
     * 抛出异常
     */
    public static void fail(String message) {
        throw new MallException(message);
    }

}
