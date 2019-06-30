package top.dbon.blackandwhite.controller;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.dbon.blackandwhite.common.AjaxResult;
import top.dbon.blackandwhite.domain.User;
import top.dbon.blackandwhite.service.UserService;

@RestController
public class UserController {

  private Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());

  @Autowired
  private UserService userService;

  @RequestMapping(value = "/user", method = RequestMethod.GET)
  public AjaxResult login(@RequestParam("username") String username, @RequestParam("password") String password) {
    User user = userService.checkLogin(username, password);
    if(user == null) {
      return AjaxResult.error();
    } else {
      logger.info("昵称为：【"+user.getNickname()+"】的用户登录成功，账号为："+user.getUsername());
      return AjaxResult.success().put("user", user);
    }
  }

  @RequestMapping(value = "/user", method = RequestMethod.POST)
  public AjaxResult register(@RequestBody User userRegister) {
    if (userService.checkNickname(userRegister) > 0) {
      return AjaxResult.error();
    } else {
      userService.insertUser(userRegister);
      logger.info("昵称为：【"+userRegister.getNickname()+"】的用户注册账号成功，账号为："+userRegister.getUsername());
      return AjaxResult.success();
    }
  }

  @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
  public AjaxResult getUsername(@PathVariable("id") String id) {
    return AjaxResult.success().put("user", userService.getUser(id));
  }

  @PostMapping("/user/getNickname")
  public AjaxResult getNickname(@RequestBody User user) {
    return AjaxResult.success().put("nickname",userService.selectNickname(user));
  }

}
