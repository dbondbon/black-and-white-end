package top.dbon.blackandwhite.domain;

import lombok.Data;

import java.util.Date;
/**
 * 表 order
 */
@Data
public class Order {
    private static final long serialVersionUID = 1L;

    /** 订单ID */
    private String orderId;
    /** 订单编号 */
    private String code;
    /** 商品ID */
    private String goodsId;
    /** 卖家ID */
    private String sellerId;
    /** 买家ID */
    private String buyerId;
    /** 创建时间 */
    private Date createTime;
    /** 更新时间 */
    private Date updateTime;
    /** 创建人 */
    private String createBy;
    /** 更新人 */
    private String updateBy;
    /** 交易状态（0待交易 1交易成功 2交易失败） */
    private String tradingStatus;
    /** 卖方是否显示（0显示 1不显示） */
    private String sellerIsShow;
    /** 买方是否显示（0显示 1不显示） */
    private String buyerIsShow;
    /** 卖家认为交易失败的原因 */
    private String sellerFailureReasons;
    /** 买家认为交易失败的原因 */
    private String buyerFailureReasons;

}