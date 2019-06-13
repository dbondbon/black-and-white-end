package top.dbon.blackandwhite.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.dbon.blackandwhite.domain.Cart;
import top.dbon.blackandwhite.mapper.CartMapper;
import top.dbon.blackandwhite.service.CartService;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartMapper cartMapper;

    @Override
    public Integer insertCart(Cart cart) {
      return cartMapper.insertCart(cart);
    }

    @Override
    public List<Cart> selectByUserId(String userId) {
        return cartMapper.selectByUserId(userId);
    }

    @Override
    public Integer updateByCart(Cart cart) {
        return cartMapper.updateByCart(cart);
    }

    @Override
    public Integer deleteByCart(Cart cart) {
        return cartMapper.deleteByCart(cart);
    }
}
