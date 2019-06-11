package top.dbon.blackandwhite.mapper;

import top.dbon.blackandwhite.domain.Cart;

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
     * 根据用户ID查找购物车列表
     * @param userId
     * @return 返回列表
     */
    List<Cart> selectByUserId(String userId);

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

}