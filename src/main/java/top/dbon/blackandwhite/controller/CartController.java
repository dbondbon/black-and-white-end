package top.dbon.blackandwhite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.dbon.blackandwhite.common.AjaxResult;
import top.dbon.blackandwhite.domain.Cart;
import top.dbon.blackandwhite.domain.CartVo;
import top.dbon.blackandwhite.domain.User;
import top.dbon.blackandwhite.service.CartService;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/add")
    public AjaxResult add(@RequestBody Cart cart) {
        cartService.insertCart(cart);
        return AjaxResult.success();
    }

    @PostMapping("/list")
    public AjaxResult list(@RequestBody User user) {
        List<Cart> list = cartService.selectByUser(user);
        return AjaxResult.success().put("cartList", list);
    }

    @PostMapping("/delete")
    public AjaxResult delete(@RequestBody Cart cart) {
        cartService.deleteByCart(cart);
        return AjaxResult.success();
    }

    @PostMapping("/price")
    public AjaxResult price(@RequestBody CartVo cartVo) {
        HashMap<String, Object> map = new HashMap<>();
        BigDecimal totalPrice = cartService.getTotalPrice(cartVo.getGoodsIdList());
        return AjaxResult.success().put("totalPrice", totalPrice);
    }

}
