package top.dbon.blackandwhite.domain;

import lombok.Data;

import java.util.List;

/**
 * 购物车页面
 */
@Data
public class OrderVo {
    private static final long serialVersionUID = 1L;

    /** 买家ID */
    private String buyerId;
    /**
     * 选定的商品id列表
     */
    private List<String> goodsIdList;

}
