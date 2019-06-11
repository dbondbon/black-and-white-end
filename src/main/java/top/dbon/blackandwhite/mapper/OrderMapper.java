package top.dbon.blackandwhite.mapper;

import top.dbon.blackandwhite.domain.Order;

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
     * 更新订单
     * @param order
     * @return
     */
    Integer updateOrder(Order order);

}