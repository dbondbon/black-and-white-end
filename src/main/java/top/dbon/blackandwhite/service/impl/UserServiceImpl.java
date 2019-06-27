package top.dbon.blackandwhite.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.dbon.blackandwhite.domain.User;
import top.dbon.blackandwhite.mapper.UserMapper;
import top.dbon.blackandwhite.service.UserService;
import top.dbon.blackandwhite.util.UUIDUtils;
import top.dbon.blackandwhite.util.UsernameUtils;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Integer deleteByUserId(String userId) {
        return userMapper.deleteByUserId(userId);
    }

    @Override
    public Integer insertUser(User user) {
      user.setUserId(UUIDUtils.getInstance().nextId());
      user.setCreateTime(new Date());
      return userMapper.insertUser(user);
    }

    @Override
    public User selectByUserId(String userId) {
        return userMapper.selectByUserId(userId);
    }

    @Override
    public String selectNickname(User user) {
      return userMapper.selectByUserId(user.getUserId()).getNickname();
    }

    @Override
    public Integer updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public User checkLogin(User userLogin) {
      User user = userMapper.selectByUser(userLogin);
      return user;
    }

    @Override
    public String getUniqueUsername() {
      String username = UsernameUtils.getNextUsername();
      while (userMapper.selectByUsername(username)!=null) {
        username = UsernameUtils.getNextUsername();
      }
      return username;
    }

    @Override
    public Integer checkNickname(User user) {
      String nickname = user.getNickname();
      if (userMapper.selectByNickname(nickname)!=null) {
        return 1;
      }
      return 0;
    }

    @Override
    public User getUser(String id) {
        if (id != null && "1".equals(id)) {
            //没有账号，新注册用户
            String username = UsernameUtils.getNextUsername();
            while (userMapper.selectByUsername(username)!=null) {
                username = UsernameUtils.getNextUsername();
            }
            User user = new User();
            user.setUsername(username);
            return user;
        } else {
            //登录用户
            User user = userMapper.selectByUserId(id);
            return user;
        }
    }
}
