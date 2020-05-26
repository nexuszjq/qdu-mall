package com.qdu.mall.dao;

import com.qdu.mall.entity.Goods;
import com.qdu.mall.entity.StockNum;
import com.qdu.mall.util.PageQueryUtil;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsMapper {
    int deleteByPrimaryKey(Long goodsId);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(Long goodsId);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKeyWithBLOBs(Goods record);

    int updateByPrimaryKey(Goods record);

    List<Goods> findGoodsList(PageQueryUtil pageUtil);

    int getTotalGoods(PageQueryUtil pageUtil);

    List<Goods> selectByPrimaryKeys(List<Long> goodsIds);

    List<Goods> findGoodsListBySearch(PageQueryUtil pageUtil);

    int getTotalGoodsBySearch(PageQueryUtil pageUtil);

    int batchInsert(@Param("goodsList") List<Goods> goodsList);

    int updateStockNum(@Param("stockNums") List<StockNum> stockNums);

    int batchUpdateSellStatus(@Param("orderIds")Long[] orderIds, @Param("sellStatus") int sellStatus);
}