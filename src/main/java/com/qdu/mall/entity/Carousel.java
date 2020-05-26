package com.qdu.mall.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @ClassName: com.qdu.mall.entity.Carousel.java
 * @Description: 轮播图
 * @author: ZhangJunqing
 * @date:  2020-04-25 17:38
 * @version V1.0
 */
public class Carousel {
    //轮播图ID
    private Integer carouselId;
    //轮播图图片url
    private String carouselUrl;
    //轮播图跳转
    private String redirectUrl;
    //排序值
    private Integer carouselRank;
    //是否被删除
    private Byte isDeleted;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    private Integer createUser;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    private Integer updateUser;

    public Integer getCarouselId() {
        return carouselId;
    }

    public void setCarouselId(Integer carouselId) {
        this.carouselId = carouselId;
    }

    public String getCarouselUrl() {
        return carouselUrl;
    }

    public void setCarouselUrl(String carouselUrl) {
        this.carouselUrl = carouselUrl == null ? null : carouselUrl.trim();
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl == null ? null : redirectUrl.trim();
    }

    public Integer getCarouselRank() {
        return carouselRank;
    }

    public void setCarouselRank(Integer carouselRank) {
        this.carouselRank = carouselRank;
    }

    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Integer updateUser) {
        this.updateUser = updateUser;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", carouselId=").append(carouselId);
        sb.append(", carouselUrl=").append(carouselUrl);
        sb.append(", redirectUrl=").append(redirectUrl);
        sb.append(", carouselRank=").append(carouselRank);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", createTime=").append(createTime);
        sb.append(", createUser=").append(createUser);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", updateUser=").append(updateUser);
        sb.append("]");
        return sb.toString();
    }
}