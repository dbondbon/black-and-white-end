package top.dbon.blackandwhite.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.dbon.blackandwhite.domain.Cart;
import top.dbon.blackandwhite.domain.Goods;
import top.dbon.blackandwhite.domain.User;
import top.dbon.blackandwhite.mapper.CartMapper;
import top.dbon.blackandwhite.mapper.GoodsMapper;
import top.dbon.blackandwhite.service.CartService;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public Integer insertCart(Cart cart) {
        if(cartMapper.selectCart(cart) == null) {
            cart.setUpdateTime(new Date());
            return cartMapper.insertCart(cart);
        } else {
            return 0;
        }
    }

    @Override
    public List<Goods> selectByUserId(String userId) {
        User user = new User();
        user.setUserId(userId);
        return cartMapper.selectByUser(user);
    }

    @Override
    public Integer updateByCart(Cart cart) {
        return cartMapper.updateByCart(cart);
    }

    @Override
    public Integer deleteByCart(Cart cart) {
        return cartMapper.deleteByCart(cart);
    }

    @Override
    public BigDecimal getTotalPrice(List<String> goodsIdlist) {
        List<Goods> goodsList = goodsMapper.selectByGoodsIdList(goodsIdlist);
        BigDecimal totalPrice = new BigDecimal(0);
        for (Goods goods : goodsList) {
            totalPrice = totalPrice.add(goods.getPrice());
        }
        return totalPrice;
    }
}
