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
     * 更新用户
     * @param user
     * @return
     */
    Integer updateUser(User user);
}
