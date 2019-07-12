package top.dbon.blackandwhite.controller;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.dbon.blackandwhite.common.AjaxResult;
import top.dbon.blackandwhite.domain.User;
import top.dbon.blackandwhite.service.UserService;
import top.dbon.blackandwhite.util.JwtUtils;

@RestController
@RequestMapping("/user")
public class UserController {

  private Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());

  @Autowired
  private UserService userService;

  @RequestMapping(value = "", method = RequestMethod.GET)
  public AjaxResult login(@RequestParam("username") String username, @RequestParam("password") String password) {
    User user = userService.checkLogin(username, password);
    if(user == null) {
      return AjaxResult.error();
    } else {
      logger.info("昵称为：{} 的用户登录成功，账号为：{}",user.getNickname(),user.getUsername());
      user.setPassword("*");
      String token = JwtUtils.createJWT(user.getUserId(),"admin" , "Service", 1000*60*60);
      return AjaxResult.success().put("user", user).put("token",token);
    }
  }

  @RequestMapping(value = "", method = RequestMethod.POST)
  public AjaxResult register(@RequestBody User userRegister) {
    if (userService.checkNickname(userRegister) > 0) {
      return AjaxResult.error();
    } else {
      userService.insertUser(userRegister);
      logger.info("昵称为：{} 的用户注册账号成功，账号为：{}",userRegister.getNickname(),userRegister.getUsername());
      return AjaxResult.success();
    }
  }

  @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
  public AjaxResult getUserInfo(@PathVariable("userId") String userId) {
    logger.debug("查找用户id为：{}的用户信息", userId);
    return AjaxResult.success().put("user", userService.getUser(userId));
  }

}
