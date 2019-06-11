package top.dbon.blackandwhite.domain;

import lombok.Data;

import java.util.Date;
/**
 * 表 user
 */
@Data
public class User {
    private static final long serialVersionUID = 1L;

    /** 用户ID */
    private String userId;
    /** 昵称 */
    private String nickname;
    /** 账号 */
    private String username;
    /** 密码 */
    private String password;
    /** 学校 */
    private String school;
    /** 性别（0男 1女） */
    private String gender;
    /** 创建时间 */
    private Date createTime;
    /** 更新时间 */
    private Date updateTime;
    /** 创建人 */
    private String createBy;
    /** 更新人 */
    private String updateBy;
    /** 是否提交学生认证（0未提交 1已提交） */
    private String submitAudit;
    /** 学生认证状态（0等待认证 1认证成功 2认证失败） */
    private String auditStatus;
    /** 头像 */
    private String avatar;
    /** 真实姓名 */
    private String name;
    /** 学号 */
    private String stuId;
    /** 学生证正面照 */
    private String idcardImg;
    /** 学生证封面照 */
    private String idcardCoverImg;
    /** 手机号 */
    private String phone;
    /** 邮箱 */
    private String email;
    /** 验证码 */
    private String authCode;
    /** 角色组 */
    private String roleSet;
    /** 是否删除（0未删除 1已删除） */
    private String isDelete;
    /** 上次登陆时间 */
    private Date loginTime;

}