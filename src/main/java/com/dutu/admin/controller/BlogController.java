package com.dutu.admin.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dutu.admin.bean.Blable;
import com.dutu.admin.bean.Blog;
import com.dutu.admin.bean.Bt;
import com.dutu.admin.service.BlogService;
import com.dutu.admin.util.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author dutu
 * @date 2021-03-27 22:03
 */
@Controller
public class BlogController {

    @Autowired
    BlogService blogService;



    @GetMapping("/toEditBlog")
    public String toEditBlog(Model model, HttpServletRequest request){

        List<Blable> blableList = blogService.getLable();

        model.addAttribute("blableList",blableList);

        model.addAttribute("requestURI" , request.getRequestURI());

        return "editBlog";
    }

    @ResponseBody
    @PostMapping("/saveblog")
    public ResultEntity<String> saveBlog(Bt bt, Blog blog){

        int saveBtStatus = blogService.saveBt(bt);
        if (saveBtStatus != 1){
            return ResultEntity.failed("保存失败!");
        }

        Integer bid = bt.getBtid();
        blog.setBid(bid);
        blog.setUpdtime("123");

        System.out.println(blog.getBid());

        int saveBlogStatus = blogService.saveBlog(blog);
        if (saveBlogStatus != 1){
            return ResultEntity.failed("保存失败!");
        }
        return ResultEntity.successWhithoutData();
    }

    @RequestMapping("/blogList")
    public String toBlogList(@RequestParam(value = "pn",defaultValue = "1") Integer pn, Model model){
        List<Blog> list = blogService.getList();
        model.addAttribute("blogs",list);

        Page<Blog> userPage = new Page<>(pn,6);
        Page<Blog> page = blogService.page(userPage, null);
        model.addAttribute("page",page);

        List<Blable> blableList = blogService.getLable();
        model.addAttribute("lables",blableList);

        return "blogList";
    }

    @GetMapping("/blog/delete/{bid}")
    public String deleteUser(@PathVariable("bid") Long bid,
                             @RequestParam("pn") Integer pn,
                             RedirectAttributes rd){
        blogService.removeById(bid);
        rd.addAttribute("pn",pn);
        return "redirect:/blogList";
    }

}
