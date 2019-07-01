package top.dbon.blackandwhite.service;

import com.github.pagehelper.Page;
import top.dbon.blackandwhite.domain.Goods;
import top.dbon.blackandwhite.domain.User;

import java.util.List;

public interface GoodsService {
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

    /**
     * 根据用户id和商品名查找商品列表
     * @param userId
     * @param name
     * @return
     */
    Page<Goods> selectListByUserIDAndGoodsName(String userId, String name);


    /**
     * 根据用户ID查找待售商品列表
     * @param userId
     * @return 结果集
     */
    List<Goods> selectOnSaleListByUser(String userId);
}
