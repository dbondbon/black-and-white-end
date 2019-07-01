package top.dbon.blackandwhite.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.dbon.blackandwhite.common.AjaxResult;
import top.dbon.blackandwhite.domain.Order;
import top.dbon.blackandwhite.domain.OrderVo;
import top.dbon.blackandwhite.service.OrderService;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public AjaxResult add(@RequestBody Order order) {
        orderService.insertOrder(order);
        return AjaxResult.success();
    }

    @PostMapping("/order/addList")
    public AjaxResult addList(@RequestBody OrderVo orderVo) {
        orderService.insertOrderList(orderVo);
        return AjaxResult.success();
    }

    @RequestMapping("/order/{userId}")
    public AjaxResult buyList(@PathVariable("userId") String userId) {
        List<Order> list = orderService.selectBuyListByUserId(userId);
        if(list == null) {
            return AjaxResult.error();
        } else {
            return AjaxResult.success().put("orderList", list);
        }
    }

    @PostMapping("/order/{userId}")
    public AjaxResult sellList(@PathVariable("userId") String userId) {
        List<Order> list = orderService.selectSellListByUserId(userId);
        if(list == null) {
            return AjaxResult.error();
        } else {
            return AjaxResult.success().put("orderList", list);
        }
    }

}
