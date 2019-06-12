package top.dbon.blackandwhite.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.dbon.blackandwhite.domain.Goods;
import top.dbon.blackandwhite.mapper.GoodsMapper;
import top.dbon.blackandwhite.service.GoodsService;

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
