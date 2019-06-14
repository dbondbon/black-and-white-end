package top.dbon.blackandwhite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import top.dbon.blackandwhite.domain.User;
import top.dbon.blackandwhite.service.UserService;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

  @Autowired
  private UserService userService;

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

}