package top.dbon.blackandwhite.domain;

import lombok.Data;

import java.util.Date;
/**
 * 表 message
 */
@Data
public class Message {
    private static final long serialVersionUID = 1L;

    /** 消息ID */
    private String msgId;
    /** 发送者ID */
    private String senderId;
    /** 接收者ID */
    private String receiverId;
    /** 发送者昵称 */
    private String senderNickname;
    /** 接受者昵称 */
    private String receiverNickname;
    /** 消息内容 */
    private String msgContent;
    /** 发送时间 */
    private Date sendTime;
    /** 接收时间 */
    private Date receiveTime;
    /** 发送状态（0等待发送 1发送成功 2发送失败） */
    private String sendStatus;
    /** 接收状态（0等待接收 1接收成功 2接收失败） */
    private String receiveStatus;
    /** 发送者是否显示（0显示 1不显示） */
    private String senderIsShow;
    /** 接收者是否显示（0显示 1不显示） */
    private String receiverIsShow;

}