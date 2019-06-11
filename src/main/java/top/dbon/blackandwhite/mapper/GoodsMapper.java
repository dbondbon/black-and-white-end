package top.dbon.blackandwhite.mapper;

import top.dbon.blackandwhite.domain.Goods;

public interface GoodsMapper {
    /**
     * 根据商品ID删除商品
     * @param goodsId
     * @return 结果
     */
    Integer deleteByGoodsId(String goodsId);

    /**
     * 新增商品
     * @param goods
     * @return
     */
    Integer insertGoods(Goods goods);

    /**
     * 根据商品ID查找商品
     * @param goodsId
     * @return 结果
     */
    Goods selectByGoodsId(String goodsId);

    /**
     * 更新商品信息
     * @param goods
     * @return
     */
    Integer updateGoods(Goods goods);
}