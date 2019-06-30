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
public class MsgController {

    @Autowired
    private MsgService msgService;

    @RequestMapping(value = "/msg", method = RequestMethod.POST)
    public AjaxResult published(@RequestBody Message message) {
        msgService.insertMessage(message);
        return AjaxResult.success();
    }

    @RequestMapping(value = "/msg/{userId}", method = RequestMethod.GET)
    public AjaxResult getAll(@PathVariable("userId") String userId) {
        List<Message> list =  msgService.selectListByUserId(userId);
        if(list == null) {
            return AjaxResult.error();
        } else {
            return AjaxResult.success().put("msgList", list);
        }
    }

    @RequestMapping(value = "/msg", method = RequestMethod.GET)
    public AjaxResult get(@RequestParam("userId") String userId, @RequestParam("otherId") String otherId) {
        List<Message> list =  msgService.selectRecords(userId, otherId);
        return AjaxResult.success().put("msgList", list);
    }
}
