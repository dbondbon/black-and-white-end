package top.dbon.blackandwhite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.dbon.blackandwhite.domain.Goods;
import top.dbon.blackandwhite.domain.User;
import top.dbon.blackandwhite.service.GoodsService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/goods")
public class GoodsController {

  @Autowired
  private GoodsService goodsService;

  @PostMapping("/published")
  @ResponseBody
  public Map<String, Object> published(@RequestBody Goods goods) {
    goodsService.insertGoods(goods);
    HashMap<String, Object> map = new HashMap<>();
    map.put("code", "0");
    return map;
  }

  @PostMapping("/findGoods")
  @ResponseBody
  public Map<String, Object> defaultGoods(@RequestBody Goods goods) {
    List<Goods> list = goodsService.selectListByUserIDAndGoodsName(goods);
    HashMap<String, Object> map = new HashMap<>();
    map.put("code", "0");
    map.put("list",list);
    return map;
  }

  @PostMapping("/findCartGoods")
  @ResponseBody
  public Map<String, Object> cartGoods(@RequestBody User user) {
    List<Goods> list = goodsService.selectListByUser(user);
    HashMap<String, Object> map = new HashMap<>();
    map.put("code", "0");
    map.put("list",list);
    return map;
  }

}
