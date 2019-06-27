package top.dbon.blackandwhite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.dbon.blackandwhite.common.AjaxResult;
import top.dbon.blackandwhite.domain.Goods;
import top.dbon.blackandwhite.domain.User;
import top.dbon.blackandwhite.service.GoodsService;

import java.util.List;

@RestController
@RequestMapping("/goods")
public class GoodsController {

  @Autowired
  private GoodsService goodsService;

  @PostMapping("/published")
  public AjaxResult published(@RequestBody Goods goods) {
    goodsService.insertGoods(goods);
    return AjaxResult.success();
  }

  @PostMapping("/findGoods")
  public AjaxResult defaultGoods(@RequestBody Goods goods) {
    List<Goods> list = goodsService.selectListByUserIDAndGoodsName(goods);
    return AjaxResult.success().put("list", list);
  }

  @PostMapping("/findCartGoods")
  public AjaxResult cartGoods(@RequestBody User user) {
    List<Goods> list = goodsService.selectListByUser(user);
    return AjaxResult.success().put("list", list);
  }

  @PostMapping("/deleteGoods")
  public AjaxResult deleteGoods(@RequestBody String goodsId) {
    goodsService.deleteByGoodsId(goodsId);
    return AjaxResult.success();
  }

}
