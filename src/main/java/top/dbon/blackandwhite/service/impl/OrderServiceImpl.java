package top.dbon.blackandwhite.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import top.dbon.blackandwhite.domain.Order;
import top.dbon.blackandwhite.mapper.OrderMapper;
import top.dbon.blackandwhite.service.OrderService;
import top.dbon.blackandwhite.util.CodeUtils;
import top.dbon.blackandwhite.util.UUIDUtils;

public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public Integer deleteByOrderId(String orderId) {
        return orderMapper.deleteByOrderId(orderId);
    }

    @Override
    public Integer insertOrder(Order order) {
      order.setOrderId(UUIDUtils.getInstance().nextId());
      order.setCode(CodeUtils.getInstance().nextId());
      return orderMapper.insertOrder(order);
    }

    @Override
    public Order selectByOrderId(String orderId) {
        return orderMapper.selectByOrderId(orderId);
    }

    @Override
    public Integer updateOrder(Order order) {
        return orderMapper.updateOrder(order);
    }
}