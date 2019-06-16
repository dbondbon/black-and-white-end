package top.dbon.blackandwhite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.dbon.blackandwhite.domain.Cart;
import top.dbon.blackandwhite.domain.CartVo;
import top.dbon.blackandwhite.domain.Goods;
import top.dbon.blackandwhite.domain.User;
import top.dbon.blackandwhite.mapper.GoodsMapper;
import top.dbon.blackandwhite.service.CartService;
import top.dbon.blackandwhite.service.GoodsService;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private GoodsService goodsService;

    @PostMapping("/add")
    @ResponseBody
    public Map<String, Object> add(@RequestBody Cart cart) {
        cartService.insertCart(cart);
        HashMap<String, Object> map = new HashMap<>();
        map.put("code", "0");
        return map;
    }

    @PostMapping("/list")
    @ResponseBody
    public Map<String, Object> list(@RequestBody User user) {
        List<Cart> list = cartService.selectByUser(user);
        HashMap<String, Object> map = new HashMap<>();
        map.put("code", "0");
        map.put("cartList", list);
        return map;
    }

    @PostMapping("/delete")
    @ResponseBody
    public Map<String, Object> delete(@RequestBody Cart cart) {
        cartService.deleteByCart(cart);
        HashMap<String, Object> map = new HashMap<>();
        map.put("code", "0");
        return map;
    }

    @PostMapping("/price")
    @ResponseBody
    public Map<String, Object> price(@RequestBody CartVo cartVo) {
        HashMap<String, Object> map = new HashMap<>();
        BigDecimal totalPrice = cartService.getTotalPrice(cartVo.getGoodsIdList());
        map.put("code", "0");
        map.put("totalPrice", totalPrice);
        return map;
    }

}
