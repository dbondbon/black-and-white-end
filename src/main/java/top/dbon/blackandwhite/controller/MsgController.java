package top.dbon.blackandwhite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.dbon.blackandwhite.common.AjaxResult;
import top.dbon.blackandwhite.domain.Message;
import top.dbon.blackandwhite.domain.MsgVo;
import top.dbon.blackandwhite.domain.User;
import top.dbon.blackandwhite.service.MsgService;

import java.util.List;

@Controller
@RequestMapping("/msg")
public class MsgController {

    @Autowired
    private MsgService msgService;

    @PostMapping("/add")
    @ResponseBody
    public AjaxResult published(@RequestBody Message message) {
        msgService.insertMessage(message);
        return AjaxResult.success();
    }

    @PostMapping("/getAll")
    @ResponseBody
    public AjaxResult get(@RequestBody User user) {
        List<Message> list =  msgService.selectListByUser(user);
        if(list == null) {
            return AjaxResult.error();
        } else {
            return AjaxResult.success().put("msgList", list);
        }
    }

    @PostMapping("/getOne")
    @ResponseBody
    public AjaxResult get(@RequestBody MsgVo msgVo) {
        List<Message> list =  msgService.selectMsgVo(msgVo);
        return AjaxResult.success().put("msgList", list);
    }
}
