package top.dbon.blackandwhite.domain;

import lombok.Data;

import java.util.List;

/**
 * 聊天记录页面
 */
@Data
public class MsgVo {
    private static final long serialVersionUID = 1L;

    /** 当前用户Id */
    private String  userId;

    /** 对象用户Id */
    private String  otherId;

    /** 聊天记录列表 */
    private List<Message> msgList;
}
