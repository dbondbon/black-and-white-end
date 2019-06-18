package top.dbon.blackandwhite.mapper;

import top.dbon.blackandwhite.domain.Message;
import top.dbon.blackandwhite.domain.MsgVo;
import top.dbon.blackandwhite.domain.User;

import java.util.List;

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
     * 查找用户所有消息
     * @param user
     * @return
     */
    List<Message> selectListByUser(User user);

    /**
     * 查找用户与用户消息记录
     * @param msgVo
     * @return
     */
    List<Message> selectMsgVo(MsgVo msgVo);

    /**
     * 更新信息
     * @param message
     * @return
     */
    Integer updateMessage(Message message);
}