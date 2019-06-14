package top.dbon.blackandwhite.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
/**
 * 表 goods
 */
@Data
public class Goods {
    private static final long serialVersionUID = 1L;

    /** 商品ID */
    private String goodsId;
    /** 商品编号 */
    private String code;
    /** 商品名称 */
    private String name;
    /** 数量 */
    private Integer count;
    /** 商品单价 */
    private BigDecimal price;
    /** 商品描述信息 */
    private String description;
    /** 商品图片ID */
    private String imgId;
    /** 商品状态（0待售 1已预订 2已售） */
    private String goodsStatus;
    /** 卖家用户ID */
    private String userId;
    /** 创建时间 */
    private Date createTime;
    /** 更新时间 */
    private Date updateTime;
    /** 创建人 */
    private String createBy;
    /** 更新人 */
    private String updateBy;
    /** 是否删除（0未删除 1 已删除） */
    private String isDelete;
    /** 出版社 */
    private String publisher;
    /** 作者 */
    private String author;

}
