package top.dbon.blackandwhite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.dbon.blackandwhite.common.AjaxResult;
import top.dbon.blackandwhite.domain.Goods;
import top.dbon.blackandwhite.domain.User;
import top.dbon.blackandwhite.service.GoodsService;

import java.util.List;

@Controller
@RequestMapping("/goods")
public class GoodsController {

  @Autowired
  private GoodsService goodsService;

  @PostMapping("/published")
  @ResponseBody
  public AjaxResult published(@RequestBody Goods goods) {
    goodsService.insertGoods(goods);
    return AjaxResult.success();
  }

  @PostMapping("/findGoods")
  @ResponseBody
  public AjaxResult defaultGoods(@RequestBody Goods goods) {
    List<Goods> list = goodsService.selectListByUserIDAndGoodsName(goods);
    return AjaxResult.success().put("list", list);
  }

  @PostMapping("/findCartGoods")
  @ResponseBody
  public AjaxResult cartGoods(@RequestBody User user) {
    List<Goods> list = goodsService.selectListByUser(user);
    return AjaxResult.success().put("list", list);
  }

  @PostMapping("/deleteGoods")
  @ResponseBody
  public AjaxResult deleteGoods(@RequestBody String goodsId) {
    goodsService.deleteByGoodsId(goodsId);
    return AjaxResult.success();
  }

}
