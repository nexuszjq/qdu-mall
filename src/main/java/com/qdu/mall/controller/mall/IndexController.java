package com.qdu.mall.controller.mall;

import com.qdu.mall.common.Constants;
import com.qdu.mall.common.IndexConfigTypeEnum;
import com.qdu.mall.controller.vo.IndexCarouselVO;
import com.qdu.mall.controller.vo.IndexCategoryVO;
import com.qdu.mall.service.CarouselService;
import com.qdu.mall.service.CategoryService;
import com.qdu.mall.service.IndexConfigService;
import com.qdu.mall.controller.vo.IndexConfigGoodsVO;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @ClassName: com.qdu.mall.controller.mall.IndexController.java
 * @Description:
 * @author: ZhangJunqing
 * @date:  2020-04-12 11:42
 * @version V1.0
 */
@Controller
public class IndexController {

    @Resource
    private CarouselService carouselService;

    @Resource
    private IndexConfigService indexConfigService;

    @Resource
    private CategoryService categoryService;

    @GetMapping({"/index", "/", "/index.html"})
    public String indexPage(HttpServletRequest request) {
        //查询商品分类
        List<IndexCategoryVO> categories = categoryService.getCategoriesForIndex();
        //未查询到商品分类则跳转异常页面
        if (CollectionUtils.isEmpty(categories)) {
            return "error/error_5xx";
        }
        //查询轮播图
        List<IndexCarouselVO> carousels = carouselService.getCarouselsForIndex(Constants.INDEX_CAROUSEL_NUMBER);
        //查询热销商品
        List<IndexConfigGoodsVO> hotGoodses = indexConfigService
                .getConfigGoodsesForIndex(IndexConfigTypeEnum.INDEX_GOODS_HOT.getType(), Constants.INDEX_GOODS_HOT_NUMBER);
        //查询新品
        List<IndexConfigGoodsVO> newGoodses = indexConfigService
                .getConfigGoodsesForIndex(IndexConfigTypeEnum.INDEX_GOODS_NEW.getType(), Constants.INDEX_GOODS_NEW_NUMBER);
        //查询推荐商品
        List<IndexConfigGoodsVO> recommendGoodses = indexConfigService
                .getConfigGoodsesForIndex(IndexConfigTypeEnum.INDEX_GOODS_RECOMMOND.getType(), Constants.INDEX_GOODS_RECOMMOND_NUMBER);

        //将获取到参数传入请求中
        request.setAttribute("categories", categories);//分类数据
        request.setAttribute("carousels", carousels);//轮播图
        request.setAttribute("hotGoodses", hotGoodses);//热销商品
        request.setAttribute("newGoodses", newGoodses);//新品
        request.setAttribute("recommendGoodses", recommendGoodses);//推荐商品
        return "mall/index";
    }
}
