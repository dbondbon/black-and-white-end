package top.dbon.blackandwhite.service;

import top.dbon.blackandwhite.domain.Goods;
import top.dbon.blackandwhite.domain.Order;
import top.dbon.blackandwhite.domain.OrderVo;
import top.dbon.blackandwhite.domain.User;

import java.util.HashMap;
import java.util.List;

public interface OrderService {
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
     * 新增批量订单
     * @param orderVo
     * @return
     */
    Integer insertOrderList(OrderVo orderVo);

    /**
     * 查找订单
     * @param orderId
     * @return
     */
    Order selectByOrderId(String orderId);

    /**
     * 查找订单
     * @param orderCode
     * @return
     */
    Order selectByOrderCode(String orderCode);

    /**
     * 查找用户所有购买订单
     * @param userId
     * @return 结果集
     */
    HashMap<String, Goods> selectBuyListByUserId(String userId);

    /**
     * 查找用户所有出售订单
     * @param userId
     * @return 结果集
     */
    HashMap<String, Goods> selectSellListByUserId(String userId);

    /**
     * 更新订单
     * @param order
     * @return
     */
    Integer updateOrder(Order order);
}
