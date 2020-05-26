package com.qdu.mall.controller.mall;

import com.qdu.mall.common.Constants;
import com.qdu.mall.common.MallException;
import com.qdu.mall.common.ServiceResultEnum;
import com.qdu.mall.controller.vo.GoodsDetailVO;
import com.qdu.mall.controller.vo.SearchPageCategoryVO;
import com.qdu.mall.entity.Goods;
import com.qdu.mall.service.CategoryService;
import com.qdu.mall.service.GoodsService;
import com.qdu.mall.util.BeanUtil;
import com.qdu.mall.util.PageQueryUtil;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @ClassName: com.qdu.mall.controller.mall.GoodsController.java
 * @Description:
 * @author: ZhangJunqing
 * @date:  2020-04-12 11:42
 * @version V1.0
 */
@Controller
public class GoodsController {

    @Resource
    private GoodsService goodsService;
    @Resource
    private CategoryService categoryService;

    @GetMapping({"/search", "/search.html"})
    public String searchPage(@RequestParam Map<String, Object> params, HttpServletRequest request) {
        if (StringUtils.isEmpty(params.get("page"))) {
            params.put("page", 1);
        }
        params.put("limit", Constants.GOODS_SEARCH_PAGE_LIMIT);
        //封装分类数据
        if (params.containsKey("goodsCategoryId") && !StringUtils.isEmpty(params.get("goodsCategoryId") + "")) {
            Long categoryId = Long.valueOf(params.get("goodsCategoryId") + "");
            SearchPageCategoryVO searchPageCategoryVO = categoryService.getCategoriesForSearch(categoryId);
            if (searchPageCategoryVO != null) {
                request.setAttribute("goodsCategoryId", categoryId);
                request.setAttribute("searchPageCategoryVO", searchPageCategoryVO);
            }
        }
        //封装参数供前端回显
        if (params.containsKey("orderBy") && !StringUtils.isEmpty(params.get("orderBy") + "")) {
            request.setAttribute("orderBy", params.get("orderBy") + "");
        }
        String keyword = "";
        //对keyword做过滤 去掉空格
        if (params.containsKey("keyword") && !StringUtils.isEmpty((params.get("keyword") + "").trim())) {
            keyword = params.get("keyword") + "";
        }
        request.setAttribute("keyword", keyword);
        params.put("keyword", keyword);
        //封装商品数据
        PageQueryUtil pageUtil = new PageQueryUtil(params);
        request.setAttribute("pageResult", goodsService.searchGoods(pageUtil));
        return "mall/search";
    }

    @GetMapping("/goods/detail/{goodsId}")
    public String detailPage(@PathVariable("goodsId") Long goodsId, HttpServletRequest request) {
        if (goodsId < 1) {
            return "error/error_5xx";
        }
        Goods goods = goodsService.getGoodsById(goodsId);
        if (goods == null) {
            MallException.fail(ServiceResultEnum.GOODS_NOT_EXIST.getResult());
        }
        if (Constants.SELL_STATUS_UP != goods.getGoodsSellStatus()){
            MallException.fail(ServiceResultEnum.GOODS_PUT_DOWN.getResult());
        }
        GoodsDetailVO goodsDetailVO = new GoodsDetailVO();
        BeanUtil.copyProperties(goods, goodsDetailVO);
        goodsDetailVO.setGoodsCarouselList(goods.getGoodsCarousel().split(","));
        request.setAttribute("goodsDetail", goodsDetailVO);
        return "mall/detail";
    }

}
