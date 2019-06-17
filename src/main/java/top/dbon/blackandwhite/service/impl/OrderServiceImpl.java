package top.dbon.blackandwhite.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.dbon.blackandwhite.domain.Cart;
import top.dbon.blackandwhite.domain.Goods;
import top.dbon.blackandwhite.domain.Order;
import top.dbon.blackandwhite.domain.OrderVo;
import top.dbon.blackandwhite.mapper.CartMapper;
import top.dbon.blackandwhite.mapper.GoodsMapper;
import top.dbon.blackandwhite.mapper.OrderMapper;
import top.dbon.blackandwhite.service.OrderService;
import top.dbon.blackandwhite.util.CodeUtils;
import top.dbon.blackandwhite.util.UUIDUtils;

import java.util.Date;
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
      //2、删除购物车信息
      Cart cart = new Cart();
      cart.setUserId(order.getBuyerId());
      cart.setGoodsId(order.getGoodsId());
      cartMapper.deleteByCart(cart);
      //3、删除在售商品信息
      Goods goods = new Goods();
      goods.setGoodsId(order.getGoodsId());
      goods.setIsDelete("1");
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
        goods.setIsDelete("1");
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
    public Integer updateOrder(Order order) {
        return orderMapper.updateOrder(order);
    }
}
