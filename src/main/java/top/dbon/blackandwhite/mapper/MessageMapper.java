package top.dbon.blackandwhite.mapper;

import top.dbon.blackandwhite.domain.Message;

public interface MessageMapper {
    int deleteByPrimaryKey(String msgId);

    int insert(Message record);

    int insertSelective(Message record);

    Message selectByPrimaryKey(String msgId);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKey(Message record);
}