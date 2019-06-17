package top.dbon.blackandwhite.mapper;

import top.dbon.blackandwhite.domain.Order;
import top.dbon.blackandwhite.domain.User;

import java.util.List;

public interface OrderMapper {
    /**
     * 删除订单
     * @param orderId
     * @return
     */
    Integer deleteByOrderId(String orderId);

    /**
     * 新增订单
     * @param order
     * @return
     */
    Integer insertOrder(Order order);

    /**
     * 查找订单
     * @param orderId
     * @return
     */
    Order selectByOrderId(String orderId);

    /**
     * 查找用户所有购买订单
     * @param user
     * @return 结果集
     */
    List<Order> selectBuyListByUser(User user);

    /**
     * 查找用户所有出售订单
     * @param user
     * @return 结果集
     */
    List<Order> selectSellListByUser(User user);

    /**
     * 更新订单
     * @param order
     * @return
     */
    Integer updateOrder(Order order);

}