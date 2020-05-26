package com.qdu.mall.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: com.qdu.mall.util.PageQueryUtil.java
 * @Description: 分页查询参数
 * @author: ZhangJunqing
 * @date:  2020-04-12 15:41
 * @version V1.0
 */
public class PageQueryUtil extends HashMap<String, Object> {
    //当前页码
    private int page;
    //每页条数
    private int limit;

    public PageQueryUtil(Map<String, Object> params) {
        this.putAll(params);

        //分页参数
        this.page = Integer.parseInt(params.get("page").toString());
        this.limit = Integer.parseInt(params.get("limit").toString());
        this.put("start", (page - 1) * limit);
        this.put("page", page);
        this.put("limit", limit);
    }


    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    @Override
    public String toString() {
        return "PageUtil{" +
                "page=" + page +
                ", limit=" + limit +
                '}';
    }
}
