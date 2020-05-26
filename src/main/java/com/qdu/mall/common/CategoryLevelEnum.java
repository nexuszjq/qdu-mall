package com.qdu.mall.common;

/**
 * @ClassName: com.qdu.mall.common.CategoryLevelEnum.java
 * @Description: 分类级别
 * @author: ZhangJunqing
 * @date:  2020-04-12 11:34
 * @version V1.0
 */
public enum CategoryLevelEnum {

    DEFAULT(0, "ERROR"),
    LEVEL_ONE(1, "一级分类"),
    LEVEL_TWO(2, "二级分类"),
    LEVEL_THREE(3, "三级分类");

    private int level;

    private String name;

    CategoryLevelEnum(int level, String name) {
        this.level = level;
        this.name = name;
    }

    public static CategoryLevelEnum getOrderStatusEnumByLevel(int level) {
        for (CategoryLevelEnum categoryLevelEnum : CategoryLevelEnum.values()) {
            if (categoryLevelEnum.getLevel() == level) {
                return categoryLevelEnum;
            }
        }
        return DEFAULT;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
