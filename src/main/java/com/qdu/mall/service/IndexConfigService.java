package com.qdu.mall.service;

import com.qdu.mall.entity.IndexConfig;
import com.qdu.mall.util.PageQueryUtil;
import com.qdu.mall.util.PageResult;
import com.qdu.mall.controller.vo.IndexConfigGoodsVO;

import java.util.List;

public interface IndexConfigService {
    /**
     * 后台分页
     *
     * @param pageUtil
     * @return
     */
    PageResult getConfigsPage(PageQueryUtil pageUtil);

    String saveIndexConfig(IndexConfig indexConfig);

    String updateIndexConfig(IndexConfig indexConfig);

    IndexConfig getIndexConfigById(Long id);

    /**
     * 返回固定数量的首页配置商品对象(首页调用)
     *
     * @param number
     * @return
     */
    List<IndexConfigGoodsVO> getConfigGoodsesForIndex(int configType, int number);

    Boolean deleteBatch(Long[] ids);
}
