package top.dbon.blackandwhite.service;

import top.dbon.blackandwhite.domain.User;

public interface UserService {
    /**
     * 删除用户
     * @param userId
     * @return
     */
    Integer deleteByUserId(String userId);

    /**
     * 新增用户
     * @param user
     * @return
     */
    Integer insertUser(User user);

    /**
     * 查找用户
     * @param userId
     * @return
     */
    User selectByUserId(String userId);

    /**
     * 查找用户昵称
     * @param user
     * @return 昵称
     */
    String selectNickname(User user);

    /**
     * 更新用户
     * @param user
     * @return
     */
    Integer updateUser(User user);

    /**
     * 检查用户登录
     * @param user
     * @return
     */
    User checkLogin(User user);

    /**
     * 生成唯一用户名
     * @return
     */
    String getUniqueUsername();

    /**
     * 检查昵称是否重复
     * @return
     */
    Integer checkNickname(User user);


}
