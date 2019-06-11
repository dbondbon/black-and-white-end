package top.dbon.blackandwhite.domain;

import lombok.Data;

import java.util.Date;
/**
 * 表 cart
 */
@Data
public class Cart {
    private static final long serialVersionUID = 1L;

    /** 用户ID */
    private String userId;
    /** 商品ID */
    private String goodsId;
    /** 更新时间 */
    private Date updateTime;
    /** 购买数量 */
    private Integer count;

}