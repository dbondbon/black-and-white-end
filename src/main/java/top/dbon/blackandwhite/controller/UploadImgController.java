package top.dbon.blackandwhite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import top.dbon.blackandwhite.common.AjaxResult;
import top.dbon.blackandwhite.service.GoodsService;
import top.dbon.blackandwhite.util.UUIDUtils;

import java.io.*;

/**
 * 接收图片控制器
 */
@Controller
@RequestMapping("/img")
public class UploadImgController {

    @PostMapping("/bookImg")
    @ResponseBody
    public AjaxResult uploadBookImg(@RequestParam("file") MultipartFile file) {
        BufferedOutputStream out = null;
        try {
            out = new BufferedOutputStream(new FileOutputStream(new File("G:\\black-and-white\\black-and-white-end\\img",
                    UUIDUtils.getInstance().nextId() +
                            file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf('.')))));
            out.write(file.getBytes());
            out.flush();
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return AjaxResult.error(1, "上传失败");
        } catch (IOException e) {
            e.printStackTrace();
            return AjaxResult.error(1, "上传失败");
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
                return AjaxResult.error(1, "上传失败");
            }
        }
        return AjaxResult.success();
    }
}
