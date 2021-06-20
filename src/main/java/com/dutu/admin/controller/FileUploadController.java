package com.dutu.admin.controller;


import com.aliyun.oss.model.OSSObjectSummary;
import com.dutu.admin.bean.Blable;
import com.dutu.admin.bean.FileUploadResult;
import com.dutu.admin.service.BlableService;
import com.dutu.admin.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * @author dutu
 * @date 2021-04-26 21:04
 */
@Controller
public class FileUploadController {
    @Autowired
    private FileUploadService fileUploadService;
    @Autowired
    private BlableService blableService;

    @GetMapping("/upload")
    public String upload(){
        return "upload";
    }

    @RequestMapping("/imgList")
    public String imgList(Model model){

        try {
            List<OSSObjectSummary> list = list();
            List<String> img = new ArrayList();
            for (OSSObjectSummary ossObjectSummary : list) {
                String key = ossObjectSummary.getKey();
                String name = key.substring(5, key.length());
                img.add(name);
            }
            model.addAttribute("list",img);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "imgList";
    }

    @GetMapping("/test")
    public String test1(){
        return "test";
    }

    /**
     * @author 团子
     * @desc 文件上传到oss
     * @return FileUploadResult
     * @Param uploadFile
     */
    @RequestMapping("file/upload")
    public String upload(@RequestParam("file") MultipartFile uploadFile) throws Exception {

        // 代更改,ajax上传
        fileUploadService.upload(uploadFile);
        return "redirect:/imgList";
    }

    /**
     * @return FileUploadResult
     * @desc 根据文件名删除oss上的文件
     * @author 团子
     * @Param objectName
     */
    @RequestMapping("file/delete")
    public String delete(@RequestParam("fileName") String objectName)
            throws Exception {
        fileUploadService.delete(objectName);
        return "redirect:/imgList";
    }

/*    @RequestMapping("file/delete")
    @ResponseBody
    public FileUploadResult delete(@RequestParam("fileName") String objectName)
            throws Exception {
        return this.fileUploadService.delete(objectName);
    }*/

    /**
     * @author 团子
     * @desc 查询oss上的所有文件
     * @return List<OSSObjectSummary>
     * @Param
     */
    @RequestMapping("file/list")
    @ResponseBody
    public List<OSSObjectSummary> list()
            throws Exception {
        return this.fileUploadService.list();
    }

    /**
     * @author 团子
     * @desc 根据文件名下载oss上的文件
     * @return
     * @Param objectName
     */
    @RequestMapping("file/download")
    @ResponseBody
    public void download(@RequestParam("fileName") String objectName, HttpServletResponse response) throws IOException {
        //通知浏览器以附件形式下载
        response.setHeader("Content-Disposition",
                "attachment;filename=" + new String(objectName.getBytes(), "ISO-8859-1"));
        this.fileUploadService.exportOssFile(response.getOutputStream(),objectName);
    }
}
