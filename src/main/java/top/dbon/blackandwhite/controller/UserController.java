package top.dbon.blackandwhite.controller;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import top.dbon.blackandwhite.common.AjaxResult;
import top.dbon.blackandwhite.domain.Goods;
import top.dbon.blackandwhite.domain.User;
import top.dbon.blackandwhite.service.GoodsService;
import top.dbon.blackandwhite.service.UserService;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

  private Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());

  @Autowired
  private UserService userService;

  @Autowired
  private GoodsService goodsService;

  @PostMapping("/login")
  @ResponseBody
  public Map<String, Object> login(@RequestBody User userLogin) {
    User user = userService.checkLogin(userLogin);
    if(user == null) {
      return AjaxResult.error();
    } else {
      logger.info("昵称为：【"+user.getNickname()+"】的用户登录成功，账号为："+user.getUsername());
      return AjaxResult.success().put("user", user);
    }
  }

  @PostMapping("/register")
  @ResponseBody
  public Map<String, Object> register(@RequestBody User userRegister) {
    if (userService.checkNickname(userRegister) > 0) {
      return AjaxResult.error();
    } else {
      userService.insertUser(userRegister);
      logger.info("昵称为：【"+userRegister.getNickname()+"】的用户注册账号成功，账号为："+userRegister.getUsername());
      return AjaxResult.success();
    }
  }

  @PostMapping("/getUsername")
  @ResponseBody
  public Map<String, Object> getUsername() {
    String username = userService.getUniqueUsername();
    return AjaxResult.success().put("username", username);
  }

  @PostMapping("/getNickname")
  @ResponseBody
  public Map<String, Object> getNickname(@RequestBody User user) {
    return AjaxResult.success().put("nickname",userService.selectNickname(user));
  }

  @PostMapping("/onSaleList")
  @ResponseBody
  public Map<String, Object> onSaleList(@RequestBody User user) {
    List<Goods> list = goodsService.selectOnSaleListByUser(user);
    if (list == null || list.size() == 0) {
      return AjaxResult.error();
    } else {
      return AjaxResult.success().put("goodsList", list);
    }
  }

}
