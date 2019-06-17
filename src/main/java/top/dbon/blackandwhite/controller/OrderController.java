package top.dbon.blackandwhite.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.dbon.blackandwhite.domain.Cart;
import top.dbon.blackandwhite.domain.Order;
import top.dbon.blackandwhite.domain.OrderVo;
import top.dbon.blackandwhite.service.CartService;
import top.dbon.blackandwhite.service.OrderService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private CartService cartService;

    @PostMapping("/add")
    @ResponseBody
    public Map<String, Object> add(@RequestBody Order order) {
        orderService.insertOrder(order);
        HashMap<String, Object> map = new HashMap<>();
        map.put("code", "0");
        return map;
    }

    @PostMapping("/addList")
    @ResponseBody
    public Map<String, Object> addList(@RequestBody OrderVo orderVo) {
        orderService.insertOrderList(orderVo);
        HashMap<String, Object> map = new HashMap<>();
        map.put("code", "0");
        return map;
    }
}
