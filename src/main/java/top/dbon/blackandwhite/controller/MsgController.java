package top.dbon.blackandwhite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.dbon.blackandwhite.common.AjaxResult;
import top.dbon.blackandwhite.domain.Message;
import top.dbon.blackandwhite.domain.MsgVo;
import top.dbon.blackandwhite.domain.User;
import top.dbon.blackandwhite.service.MsgService;

import java.util.List;

@RestController
@RequestMapping("/msg")
public class MsgController {

    @Autowired
    private MsgService msgService;

    @PostMapping("/add")
    public AjaxResult published(@RequestBody Message message) {
        msgService.insertMessage(message);
        return AjaxResult.success();
    }

    @PostMapping("/getAll")
    public AjaxResult get(@RequestBody User user) {
        List<Message> list =  msgService.selectListByUser(user);
        if(list == null) {
            return AjaxResult.error();
        } else {
            return AjaxResult.success().put("msgList", list);
        }
    }

    @PostMapping("/getOne")
    public AjaxResult get(@RequestBody MsgVo msgVo) {
        List<Message> list =  msgService.selectMsgVo(msgVo);
        return AjaxResult.success().put("msgList", list);
    }
}
