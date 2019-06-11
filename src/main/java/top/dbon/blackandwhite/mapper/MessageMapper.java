package top.dbon.blackandwhite.mapper;

import top.dbon.blackandwhite.domain.Message;

public interface MessageMapper {
    /**
     * 删除消息
     * @param msgId
     * @return
     */
    Integer deleteByMsgId(String msgId);

    /**
     * 新增消息
     * @param record
     * @return
     */
    Integer insertMessage(Message record);

    /**
     * 查找消息
     * @param msgId
     * @return
     */
    Message selectByMsgId(String msgId);

    /**
     * 更新信息
     * @param message
     * @return
     */
    Integer updateMessage(Message message);
}