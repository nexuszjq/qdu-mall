package com.qdu.mall.common;

/**
 * @ClassName: com.qdu.mall.common.PayStatusEnum.java
 * @Description: 订单状态
 * @author: ZhangJunqing
 * @date:  2020-04-12 11:35
 * @version V1.0
 */
public enum PayStatusEnum {

    DEFAULT(-1, "支付失败"),
    PAY_ING(0, "支付中"),
    PAY_SUCCESS(1, "支付成功");

    private int payStatus;

    private String name;

    PayStatusEnum(int payStatus, String name) {
        this.payStatus = payStatus;
        this.name = name;
    }

    public static PayStatusEnum getPayStatusEnumByStatus(int payStatus) {
        for (PayStatusEnum payStatusEnum : PayStatusEnum.values()) {
            if (payStatusEnum.getPayStatus() == payStatus) {
                return payStatusEnum;
            }
        }
        return DEFAULT;
    }

    public int getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(int payStatus) {
        this.payStatus = payStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
