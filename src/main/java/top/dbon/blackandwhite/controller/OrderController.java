package top.dbon.blackandwhite.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.dbon.blackandwhite.common.AjaxResult;
import top.dbon.blackandwhite.domain.Order;
import top.dbon.blackandwhite.domain.OrderVo;
import top.dbon.blackandwhite.domain.User;
import top.dbon.blackandwhite.service.OrderService;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/add")
    @ResponseBody
    public AjaxResult add(@RequestBody Order order) {
        orderService.insertOrder(order);
        return AjaxResult.success();
    }

    @PostMapping("/addList")
    @ResponseBody
    public AjaxResult addList(@RequestBody OrderVo orderVo) {
        orderService.insertOrderList(orderVo);
        return AjaxResult.success();
    }

    @PostMapping("/buyList")
    @ResponseBody
    public AjaxResult buyList(@RequestBody User user) {
        List<Order> list = orderService.selectBuyListByUser(user);
        if(list == null) {
            return AjaxResult.error();
        } else {
            return AjaxResult.success().put("orderList", list);
        }
    }

    @PostMapping("/sellList")
    @ResponseBody
    public AjaxResult sellList(@RequestBody User user) {
        List<Order> list = orderService.selectSellListByUser(user);
        if(list == null) {
            return AjaxResult.error();
        } else {
            return AjaxResult.success().put("orderList", list);
        }
    }

}
