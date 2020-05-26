package com.qdu.mall.entity;

/**
 * @ClassName: com.qdu.mall.entity.StockNum.java
 * @Description: 库存修改所需实体
 * @author: ZhangJunqing
 * @date:  2020-04-25 19:27
 * @version V1.0
 */
public class StockNum {
    private Long goodsId;

    private Integer goodsCount;

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(Integer goodsCount) {
        this.goodsCount = goodsCount;
    }
}
