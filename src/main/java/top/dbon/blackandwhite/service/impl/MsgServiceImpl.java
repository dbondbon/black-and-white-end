package top.dbon.blackandwhite.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.dbon.blackandwhite.domain.Message;
import top.dbon.blackandwhite.domain.MsgVo;
import top.dbon.blackandwhite.domain.User;
import top.dbon.blackandwhite.mapper.MessageMapper;
import top.dbon.blackandwhite.mapper.UserMapper;
import top.dbon.blackandwhite.service.MsgService;
import top.dbon.blackandwhite.util.UUIDUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MsgServiceImpl implements MsgService {

    @Autowired
    private MessageMapper messageMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public Integer deleteByMsgId(String msgId) {
        return messageMapper.deleteByMsgId(msgId);
    }

    @Override
    public Integer insertMessage(Message msg) {
      msg.setMsgId(UUIDUtils.getInstance().nextId());
      msg.setSenderNickname(userMapper.selectByUserId(msg.getSenderId()).getNickname());
      msg.setReceiverNickname(userMapper.selectByUserId(msg.getReceiverId()).getNickname());
      msg.setSendTime(new Date());
      return messageMapper.insertMessage(msg);
    }

    @Override
    public Message selectByMsgId(String msgId) {
        return messageMapper.selectByMsgId(msgId);
    }

    @Override
    public List<Message> selectListByUserId(String userId) {
        User user = new User();
        user.setUserId(userId);
        List<Message> list =  messageMapper.selectListByUser(user);
        //去重
        for (int i = 0;i<list.size();i++) {
            for (int j = 0;j<list.size()-1;j++) {
                if((list.get(i).getSenderId()).equals(list.get(j).getReceiverId()) &&
                        (list.get(i).getReceiverId().equals(list.get(j).getSenderId()))) {
                    list.remove(j);
                }
            }
        }
        return list;
    }

    @Override
    public List<Message> selectRecords(String userId, String otherId) {
        Map<String, Object> map = new HashMap<>();
        map.put("userId", userId);
        map.put("otherId", otherId);
        return  messageMapper.selectRecords(map);
    }

    @Override
    public Integer updateMessage(Message msg) {
        return messageMapper.updateMessage(msg);
    }
}
