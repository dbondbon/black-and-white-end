package top.dbon.blackandwhite.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.dbon.blackandwhite.domain.Message;
import top.dbon.blackandwhite.mapper.MessageMapper;
import top.dbon.blackandwhite.service.MsgService;
import top.dbon.blackandwhite.util.UUIDUtils;

@Service
public class MsgServiceImpl implements MsgService {

    @Autowired
    private MessageMapper messageMapper;

    @Override
    public Integer deleteByMsgId(String msgId) {
        return messageMapper.deleteByMsgId(msgId);
    }

    @Override
    public Integer insertMessage(Message msg) {
      msg.setMsgId(UUIDUtils.getInstance().nextId());
      return messageMapper.insertMessage(msg);
    }

    @Override
    public Message selectByMsgId(String msgId) {
        return messageMapper.selectByMsgId(msgId);
    }

    @Override
    public Integer updateMessage(Message msg) {
        return messageMapper.updateMessage(msg);
    }
}
