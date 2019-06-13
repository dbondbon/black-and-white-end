package top.dbon.blackandwhite.mapper;

import top.dbon.blackandwhite.domain.User;

public interface UserMapper {
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
     * 根据登录信息查找用户
     * @param user
     * @return
     */
    User selectByUser(User user);

    /**
     * 更新用户
     * @param user
     * @return
     */
    Integer updateUser(User user);

    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    User selectByUsername(String username);

    /**
     * 根据昵称查找用户
     * @param nickname
     * @return
     */
    User selectByNickname(String nickname);
}
