package com.qdu.mall.dao;

import com.qdu.mall.entity.ShoppingCartItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShoppingCartItemMapper {
    int deleteByPrimaryKey(Long cartItemId);

    int insert(ShoppingCartItem record);

    int insertSelective(ShoppingCartItem record);

    ShoppingCartItem selectByPrimaryKey(Long cartItemId);

    ShoppingCartItem selectByUserIdAndGoodsId(@Param("userId") Long userId, @Param("goodsId") Long goodsId);

    List<ShoppingCartItem> selectByUserId(@Param("userId") Long userId, @Param("number") int number);

    int selectCountByUserId(Long userId);

    int updateByPrimaryKeySelective(ShoppingCartItem record);

    int updateByPrimaryKey(ShoppingCartItem record);

    int deleteBatch(List<Long> ids);
}