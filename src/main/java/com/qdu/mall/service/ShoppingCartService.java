package com.qdu.mall.service;

import com.qdu.mall.entity.ShoppingCartItem;
import com.qdu.mall.controller.vo.ShoppingCartItemVO;

import java.util.List;

public interface ShoppingCartService {

    /**
     * 保存商品至购物车中
     *
     * @param shoppingCartItem
     * @return
     */
    String saveCartItem(ShoppingCartItem shoppingCartItem);

    /**
     * 修改购物车中的属性
     *
     * @param shoppingCartItem
     * @return
     */
    String updateCartItem(ShoppingCartItem shoppingCartItem);

    /**
     * 获取购物项详情
     *
     * @param shoppingCartItemId
     * @return
     */
    ShoppingCartItem getCartItemById(Long shoppingCartItemId);

    /**
     * 删除购物车中的商品
     *
     * @param shoppingCartItemId
     * @return
     */
    Boolean deleteById(Long shoppingCartItemId);

    /**
     * 获取我的购物车中的列表数据
     *
     * @param userId
     * @return
     */
    List<ShoppingCartItemVO> getMyShoppingCartItems(Long userId);
}
