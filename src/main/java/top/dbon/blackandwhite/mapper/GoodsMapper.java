package top.dbon.blackandwhite.mapper;

import com.github.pagehelper.Page;
import top.dbon.blackandwhite.domain.Goods;
import top.dbon.blackandwhite.domain.User;

import java.util.HashMap;
import java.util.List;

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
     * 根据商品ID列表查找商品
     * @param goodsIdList
     * @return 结果集
     */
    List<Goods> selectByGoodsIdList(List<String> goodsIdList);

    /**
     * 更新商品信息
     * @param goods
     * @return
     */
    Integer updateGoods(Goods goods);

    /**
     * 根据用户id和商品名查找商品列表
     * @param goods
     * @return 结果集
     */
    Page<Goods> selectListByUserIDAndGoodsName(Goods goods);

    /**
     * 根据用户查找购物车商品列表
     * @param user
     * @return 结果集
     */
    List<Goods> selectCartListByUser(User user);

    /**
     * 查找用户所有待售订单
     * @param user
     * @return 结果集
     */
    List<Goods> selectOnSaleListByUser(User user);

}
