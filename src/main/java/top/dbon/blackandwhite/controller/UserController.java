package top.dbon.blackandwhite.controller;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import top.dbon.blackandwhite.domain.Goods;
import top.dbon.blackandwhite.domain.User;
import top.dbon.blackandwhite.service.GoodsService;
import top.dbon.blackandwhite.service.UserService;

import java.util.HashMap;
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
    HashMap<String, Object> map = new HashMap<>();
    if(user == null) {
      map.put("code", "1");
    } else {
      map.put("code", "0");
      map.put("user", user);
      logger.info("昵称为：【"+user.getNickname()+"】的用户登录成功，账号为："+user.getUsername());
    }
    return map;
  }

  @PostMapping("/register")
  @ResponseBody
  public Map<String, Object> register(@RequestBody User userRegister) {
    HashMap<String, Object> map = new HashMap<>();
    if (userService.checkNickname(userRegister) > 0) {
      map.put("code", "1");
      return map;
    } else {
      userService.insertUser(userRegister);
      logger.info("昵称为：【"+userRegister.getNickname()+"】的用户注册账号成功，账号为："+userRegister.getUsername());
      map.put("code", "0");
      return map;
    }
  }

  @PostMapping("/getUsername")
  @ResponseBody
  public Map<String, Object> getUsername() {
    String userrname = userService.getUniqueUsername();
    HashMap<String, Object> map = new HashMap<>();
    map.put("code","0");
    map.put("username",userrname);
    return map;
  }

  @PostMapping("/getNickname")
  @ResponseBody
  public Map<String, Object> getNickname(@RequestBody User user) {
    HashMap<String, Object> map = new HashMap<>();
    map.put("code","0");
    map.put("nickname",userService.selectNickname(user));
    return map;
  }

  @PostMapping("/onSaleList")
  @ResponseBody
  public Map<String, Object> onSaleList(@RequestBody User user) {
    HashMap<String, Object> map = new HashMap<>();
    List<Goods> list = goodsService.selectOnSaleListByUser(user);
    if (list == null || list.size() == 0) {
      map.put("code","1");
    } else {
      map.put("code","0");
      map.put("goodsList",list);
    }
    return map;
  }

}
