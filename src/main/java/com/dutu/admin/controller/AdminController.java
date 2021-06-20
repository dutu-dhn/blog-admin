package com.dutu.admin.controller;

import com.dutu.admin.bean.Admin;
import com.dutu.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author dutu
 * @date 2021-03-27 20:27
 */
@Controller
public class AdminController {

    @Autowired
    AdminService adminService;

    /**
     * 去登录页
     * @return
     */
    @GetMapping(value = {"/","/login"})
    public String toLogin(){
        return "login";
    }

    /**
     * 实现登录
     * @return
     */
    @PostMapping("/login")
    public String login(Admin admin, HttpSession session, Model model){

        Admin resultAdmin = adminService.checkAdminLogin(admin);

        if (resultAdmin == null){
            model.addAttribute("msg","登陆失败,请重新尝试!");
            return "login";
        }else {
            session.setAttribute("admin",resultAdmin);
            //登录成功重定向到main.html;重定向防止表单重复提交
            return "redirect:main.html";
        }

    }

    /**
     * 去主页面
     * @param session
     * @param model
     * @return
     */
    @GetMapping("/main.html")
    public String toMain(HttpSession session, Model model, HttpServletRequest request){
        // 判断session内是否有admin信息,若有则可以前往main,若没有则可能session失效或者非法进入
        Object admin = session.getAttribute("admin");
        if (admin == null){
            model.addAttribute("msg","未登录或者登陆已失效,请重新登录!");
            return "login";
        }else {
            model.addAttribute("requestURI" , request.getRequestURI());
            return "main";
        }

    }





}
