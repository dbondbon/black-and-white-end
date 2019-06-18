package top.dbon.blackandwhite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.dbon.blackandwhite.domain.Message;
import top.dbon.blackandwhite.domain.MsgVo;
import top.dbon.blackandwhite.domain.User;
import top.dbon.blackandwhite.service.MsgService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/msg")
public class MsgController {

    @Autowired
    private MsgService msgService;

    @PostMapping("/add")
    @ResponseBody
    public Map<String, Object> published(@RequestBody Message message) {
        msgService.insertMessage(message);
        HashMap<String, Object> map = new HashMap<>();
        map.put("code", "0");
        return map;
    }

    @PostMapping("/getAll")
    @ResponseBody
    public Map<String, Object> get(@RequestBody User user) {
        List<Message> list =  msgService.selectListByUser(user);
        HashMap<String, Object> map = new HashMap<>();
        if(list == null) {
            map.put("code", "1");
        } else {
            map.put("code", "0");
            map.put("msgList",list);
        }
        return map;
    }

    @PostMapping("/getOne")
    @ResponseBody
    public Map<String, Object> get(@RequestBody MsgVo msgVo) {
        List<Message> list =  msgService.selectMsgVo(msgVo);
        HashMap<String, Object> map = new HashMap<>();
        map.put("code", "0");
        map.put("msgList",list);
        return map;
    }
}
