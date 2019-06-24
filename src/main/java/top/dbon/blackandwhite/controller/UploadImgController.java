package top.dbon.blackandwhite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.dbon.blackandwhite.common.AjaxResult;

@Controller
@RequestMapping("/img")
public class UploadImgController {

    @PostMapping("/bookImg")
    @ResponseBody
    public AjaxResult uploadBookImg() {
        return AjaxResult.success();
    }

}
