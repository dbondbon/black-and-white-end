package top.dbon.blackandwhite.service;

import top.dbon.blackandwhite.domain.Message;

import java.util.List;

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
     * 查找用户所有消息
     * @param userId
     * @return
     */
    List<Message> selectListByUserId(String userId);

    /**
     * 查找用户与用户消息记录
     * @param userId
     * @param otherId
     * @return 消息列表
     */
    List<Message> selectRecords(String userId, String otherId);

    /**
     * 更新信息
     * @param msg
     * @return
     */
    Integer updateMessage(Message msg);
}
