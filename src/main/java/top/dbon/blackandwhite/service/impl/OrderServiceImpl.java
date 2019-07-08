package top.dbon.blackandwhite.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.dbon.blackandwhite.domain.*;
import top.dbon.blackandwhite.mapper.CartMapper;
import top.dbon.blackandwhite.mapper.GoodsMapper;
import top.dbon.blackandwhite.mapper.OrderMapper;
import top.dbon.blackandwhite.service.OrderService;
import top.dbon.blackandwhite.util.CodeUtils;
import top.dbon.blackandwhite.util.UUIDUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public Integer deleteByOrderId(String orderId) {
        return orderMapper.deleteByOrderId(orderId);
    }

    @Override
    public Integer insertOrder(Order order) {
      //1、添加订单信息
      order.setOrderId(UUIDUtils.getInstance().nextId());
      order.setCode(CodeUtils.getInstance().nextId());
      order.setCreateTime(new Date());
      orderMapper.insertOrder(order);
      //2、删除自己和他人的购物车信息
      Cart cart = new Cart();
      cart.setUserId(order.getBuyerId());
      cart.setGoodsId(order.getGoodsId());
      cartMapper.deleteByCart(cart);
      //3、修改商品状态
      Goods goods = new Goods();
      goods.setGoodsId(order.getGoodsId());
      goods.setGoodsStatus("2");
      goodsMapper.updateGoods(goods);

      return 0;
    }

    @Override
    public Integer insertOrderList(OrderVo orderVo) {
        Order order = new Order();
        order.setBuyerId(orderVo.getBuyerId());
        Cart cart = new Cart();
        cart.setUserId(orderVo.getBuyerId());
        Goods goods = new Goods();
        goods.setGoodsStatus("2");
        for (String goodsId : orderVo.getGoodsIdList()) {
            //1、添加订单信息
            order.setOrderId(UUIDUtils.getInstance().nextId());
            order.setCode(CodeUtils.getInstance().nextId());
            order.setCreateTime(new Date());
            order.setGoodsId(goodsId);
            order.setSellerId(goodsMapper.selectByGoodsId(goodsId).getUserId());
            orderMapper.insertOrder(order);
            //2、删除购物车信息
            cart.setGoodsId(goodsId);
            cartMapper.deleteByCart(cart);
            //3、删除商品信息
            goods.setGoodsId(order.getGoodsId());
            goodsMapper.updateGoods(goods);
        }
        return 0;
    }

    @Override
    public Order selectByOrderId(String orderId) {
        return orderMapper.selectByOrderId(orderId);
    }

    @Override
    public Order selectByOrderCode(String orderCode) {
        return orderMapper.selectByOrderCode(orderCode);
    }

    @Override
    public HashMap<String, Goods> selectBuyListByUserId(String userId) {
        User user = new User();
        user.setUserId(userId);
        List<Order> orderList =  orderMapper.selectBuyListByUser(user);
        HashMap<String, Goods> orderMap = new HashMap<>();
        for (Order order : orderList) {
            orderMap.put(order.getCode(), goodsMapper.selectByGoodsId(order.getGoodsId()));
        }
        return orderMap;
    }

    @Override
    public HashMap<String, Goods> selectSellListByUserId(String userId) {
        User user = new User();
        user.setUserId(userId);
        List<Order> orderList = orderMapper.selectSellListByUser(user);
        HashMap<String, Goods> orderMap = new HashMap<>();
        for (Order order : orderList) {
            orderMap.put(order.getCode(), goodsMapper.selectByGoodsId(order.getGoodsId()));
        }
        return orderMap;
    }

    @Override
    public Integer updateOrder(Order order) {
        return orderMapper.updateOrder(order);
    }
}
