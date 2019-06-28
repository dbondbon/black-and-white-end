package top.dbon.blackandwhite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.dbon.blackandwhite.common.AjaxResult;
import top.dbon.blackandwhite.domain.Goods;
import top.dbon.blackandwhite.service.GoodsService;

import java.util.List;

@RestController
public class GoodsController {

  @Autowired
  private GoodsService goodsService;

  @RequestMapping(value = "/goods", method = RequestMethod.POST)
  public AjaxResult insertGoods(@RequestBody Goods goods) {
    goodsService.insertGoods(goods);
    return AjaxResult.success();
  }

  @RequestMapping(value = "/goods", method = RequestMethod.GET)
  public AjaxResult findAllGoods(@RequestParam("userId") String userId, @RequestParam("name") String name) {
    List<Goods> list = goodsService.selectListByUserIDAndGoodsName(userId, name);
    return AjaxResult.success().put("list", list);
  }

  @RequestMapping(value = "/goods/{userId}", method = RequestMethod.GET)
  public AjaxResult onSaleList(@PathVariable("userId") String userId) {
    List<Goods> list = goodsService.selectOnSaleListByUser(userId);
    if (list == null || list.size() == 0) {
      return AjaxResult.success().put("goodsList", null);
    } else {
      return AjaxResult.success().put("goodsList", list);
    }
  }

  @RequestMapping(value = "/goods/{goodsId}", method = RequestMethod.DELETE)
  public AjaxResult deleteGoods(@PathVariable("goodsId") String goodsId) {
    goodsService.deleteByGoodsId(goodsId);
    return AjaxResult.success();
  }

}
