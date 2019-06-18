package top.dbon.blackandwhite.service;

import top.dbon.blackandwhite.domain.Message;

public interface MsgService {
    /**
     * 删除消息
     * @param msgId
     * @return
     */
    Integer deleteByMsgId(String msgId);

    /**
     * 新增消息
     * @param msg
     * @return
     */
    Integer insertMessage(Message msg);

    /**
     * 查找消息
     * @param msgId
     * @return
     */
    Message selectByMsgId(String msgId);

    /**
     * 更新信息
     * @param msg
     * @return
     */
    Integer updateMessage(Message msg);
}
