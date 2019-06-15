package top.dbon.blackandwhite.service;

import top.dbon.blackandwhite.domain.Cart;
import top.dbon.blackandwhite.domain.User;

import java.util.List;

public interface CartService {
    /**
     * 添加购物车
     * @param cart
     * @return 结果
     */
    Integer insertCart(Cart cart);

    /**
     * 根据用户查找购物车列表
     * @param user
     * @return 返回列表
     */
    List<Cart> selectByUser(User user);

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
