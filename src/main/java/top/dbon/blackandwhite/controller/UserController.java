package top.dbon.blackandwhite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import top.dbon.blackandwhite.domain.User;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

  @PostMapping("/login")
  @ResponseBody
  public Map<String, Object> login(@RequestBody User user) {
    System.out.println(user);
    Map<String, Object> map = new HashMap<>();
    map.put("msg", "ok");
    map.put("username", "123456");
    return map;
  }

}
