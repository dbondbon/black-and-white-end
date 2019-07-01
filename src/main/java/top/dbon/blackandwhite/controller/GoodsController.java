package top.dbon.blackandwhite.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.dbon.blackandwhite.common.AjaxResult;
import top.dbon.blackandwhite.domain.Goods;
import top.dbon.blackandwhite.service.GoodsService;

import java.util.List;

@RestController
@RequestMapping("/goods")
public class GoodsController {

  @Autowired
  private GoodsService goodsService;

  @RequestMapping(value = "", method = RequestMethod.POST)
  public AjaxResult insertGoods(@RequestBody Goods goods) {
    goodsService.insertGoods(goods);
    return AjaxResult.success();
  }

  @RequestMapping(value = "", method = RequestMethod.GET)
  public AjaxResult findAllGoods(@RequestParam("userId") String userId, @RequestParam("name") String name,
                                @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize, @RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum) {
    PageHelper.startPage(pageNum,pageSize);
    PageInfo<Goods> pageInfo = new PageInfo<>(goodsService.selectListByUserIDAndGoodsName(userId, name));
    return AjaxResult.success().put("pageInfo", pageInfo);
  }

  @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
  public AjaxResult onSaleList(@PathVariable("userId") String userId) {
    List<Goods> list = goodsService.selectOnSaleListByUser(userId);
    if (list == null || list.size() == 0) {
      return AjaxResult.success().put("goodsList", null);
    } else {
      return AjaxResult.success().put("goodsList", list);
    }
  }

  @RequestMapping(value = "/{goodsId}", method = RequestMethod.DELETE)
  public AjaxResult deleteGoods(@PathVariable("goodsId") String goodsId) {
    goodsService.deleteByGoodsId(goodsId);
    return AjaxResult.success();
  }

}
