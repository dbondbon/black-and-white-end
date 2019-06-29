package top.dbon.blackandwhite.mapper;

import top.dbon.blackandwhite.domain.Cart;
import top.dbon.blackandwhite.domain.Goods;
import top.dbon.blackandwhite.domain.User;

import java.util.List;

/**
 * 数据层
 *
 */
public interface CartMapper {
    /**
     * 添加购物车
     * @param cart
     * @return 结果
     */
    Integer insertCart(Cart cart);

    /**
     * 根据用户ID查找购物车商品列表
     * @param user
     * @return 返回列表
     */
    List<Goods> selectByUser(User user);

    /**
     * 根据物品信息更新购物车信息
     * @param cart
     * @return 结果
     */
    Integer updateByCart(Cart cart);

    /**
     * 根据购物车物品信息删除该物品
     * @param cart
     * @return 结果
     */
    Integer deleteByCart(Cart cart);

    /**
     * 查找购物车中是否存在该记录
     * @param cart
     * @return
     */
    Cart selectCart(Cart cart);

}