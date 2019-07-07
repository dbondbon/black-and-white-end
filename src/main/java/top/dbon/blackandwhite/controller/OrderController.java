package top.dbon.blackandwhite.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.dbon.blackandwhite.common.AjaxResult;
import top.dbon.blackandwhite.common.Constant;
import top.dbon.blackandwhite.domain.Goods;
import top.dbon.blackandwhite.domain.Order;
import top.dbon.blackandwhite.domain.OrderVo;
import top.dbon.blackandwhite.service.OrderService;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public AjaxResult add(@RequestBody Order order) {
        orderService.insertOrder(order);
        return AjaxResult.success();
    }

    @PostMapping("/addList")
    public AjaxResult addList(@RequestBody OrderVo orderVo) {
        orderService.insertOrderList(orderVo);
        return AjaxResult.success();
    }

    @RequestMapping("/{type}/{userId}")
    public AjaxResult buyList(@PathVariable("type") String type, @PathVariable("userId") String userId) {
        if (Constant.BUY_LIST.equals(type)) {
            HashMap<String, Goods> orderMap = orderService.selectBuyListByUserId(userId);
            return AjaxResult.success().put("orderMap", orderMap);
        }
        if (Constant.SELL_LIST.equals(type)) {
            HashMap<String, Goods> orderMap = orderService.selectSellListByUserId(userId);
            return AjaxResult.success().put("orderMap", orderMap);
        }
        return AjaxResult.error();
    }
}
