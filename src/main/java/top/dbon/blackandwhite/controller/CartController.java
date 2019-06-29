package top.dbon.blackandwhite.controller;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.dbon.blackandwhite.common.AjaxResult;
import top.dbon.blackandwhite.domain.Cart;
import top.dbon.blackandwhite.domain.Goods;
import top.dbon.blackandwhite.service.CartService;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class CartController {

    private Logger logger = (Logger) LoggerFactory.getLogger(CartController.class);

    @Autowired
    private CartService cartService;

    @RequestMapping(value = "/cart", method = RequestMethod.POST)
    public AjaxResult addCart(@RequestBody Cart cart) {
        cartService.insertCart(cart);
        return AjaxResult.success();
    }

    @RequestMapping(value = "/cart/{userId}", method = RequestMethod.GET)
    public AjaxResult listCart(@PathVariable String userId) {
        logger.debug("接收到查询购物车请求，查询的用户ID为：{}", userId);
        List<Goods> list = cartService.selectByUserId(userId);
        return AjaxResult.success().put("cartGoodsList", list);
    }

    @RequestMapping(value = "/cart", method = RequestMethod.DELETE)
    public AjaxResult delete(@RequestParam("userId") String userId, @RequestParam("goodsId") String goodsId) {
        cartService.deleteByUserIdAndGoodsId(userId, goodsId);
        return AjaxResult.success();
    }

    @RequestMapping(value = "/cart/price", method = RequestMethod.POST)
    public AjaxResult price(@RequestBody List<String> goodsIdList) {
        BigDecimal totalPrice = cartService.getTotalPrice(goodsIdList);
        return AjaxResult.success().put("totalPrice", totalPrice);
    }

}
