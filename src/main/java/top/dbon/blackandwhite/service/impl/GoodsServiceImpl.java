package top.dbon.blackandwhite.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.dbon.blackandwhite.domain.Goods;
import top.dbon.blackandwhite.mapper.GoodsMapper;
import top.dbon.blackandwhite.service.GoodsService;
import top.dbon.blackandwhite.util.CodeUtils;
import top.dbon.blackandwhite.util.UUIDUtils;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public Integer deleteByGoodsId(String goodsId) {
        return goodsMapper.deleteByGoodsId(goodsId);
    }

    @Override
    public Integer insertGoods(Goods goods) {
      goods.setGoodsId(UUIDUtils.getInstance().nextId());
      goods.setCode(CodeUtils.getInstance().nextId());
      return goodsMapper.insertGoods(goods);
    }

    @Override
    public Goods selectByGoodsId(String goodsId) {
        return goodsMapper.selectByGoodsId(goodsId);
    }

    @Override
    public Integer updateGoods(Goods goods) {
        return goodsMapper.updateGoods(goods);
    }
}
