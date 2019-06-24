package top.dbon.blackandwhite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.dbon.blackandwhite.common.AjaxResult;
import top.dbon.blackandwhite.domain.Cart;
import top.dbon.blackandwhite.domain.CartVo;
import top.dbon.blackandwhite.domain.User;
import top.dbon.blackandwhite.service.CartService;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/add")
    @ResponseBody
    public AjaxResult add(@RequestBody Cart cart) {
        cartService.insertCart(cart);
        return AjaxResult.success();
    }

    @PostMapping("/list")
    @ResponseBody
    public Map<String, Object> list(@RequestBody User user) {
        List<Cart> list = cartService.selectByUser(user);
        return AjaxResult.success().put("cartList", list);
    }

    @PostMapping("/delete")
    @ResponseBody
    public Map<String, Object> delete(@RequestBody Cart cart) {
        cartService.deleteByCart(cart);
        return AjaxResult.success();
    }

    @PostMapping("/price")
    @ResponseBody
    public Map<String, Object> price(@RequestBody CartVo cartVo) {
        HashMap<String, Object> map = new HashMap<>();
        BigDecimal totalPrice = cartService.getTotalPrice(cartVo.getGoodsIdList());
        return AjaxResult.success().put("totalPrice", totalPrice);
    }

}
