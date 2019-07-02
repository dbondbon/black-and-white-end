package top.dbon.blackandwhite.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.dbon.blackandwhite.common.AjaxResult;
import top.dbon.blackandwhite.util.UUIDUtils;

import java.io.*;

/**
 * 接收图片控制器
 */
@RestController
@RequestMapping("/img")
public class ImgController {

    @RequestMapping(value = "", method = RequestMethod.POST)
    public AjaxResult add(@RequestParam("file") MultipartFile file) {
        BufferedOutputStream out = null;
        String imgId = UUIDUtils.getInstance().nextId();
        try {
            out = new BufferedOutputStream(new FileOutputStream(new File("G:\\black-and-white\\black-and-white-end\\img",
                    imgId +
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
        return AjaxResult.success().put("imgId", imgId);
    }

    @RequestMapping(value = "/{imgId}", produces = MediaType.IMAGE_JPEG_VALUE, method = RequestMethod.GET)
    public byte[] get(@PathVariable("imgId") String imgId) {
        String imgPath = "G:\\black-and-white\\black-and-white-end\\img\\" + imgId + ".jpg";
        File file = new File(imgPath);
        if (!file.exists()) {
            imgPath = "G:\\black-and-white\\black-and-white-end\\img\\" + imgId + ".png";
        }
        file = new File(imgPath);
        if (!file.exists()) {
            imgPath = "G:\\black-and-white\\black-and-white-end\\img\\book.jpg";
        }
        file = new File(imgPath);
        try {
            FileInputStream inputStream = new FileInputStream(file);
            byte[] bytes = new byte[inputStream.available()];
            inputStream.read(bytes, 0, inputStream.available());
            return bytes;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
