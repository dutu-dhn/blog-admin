package com.dutu.admin.interceptor;

/**
 * @author dutu
 * @date 2021-03-04 20:26
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登录检查
 * 1.配置好拦截器需要拦截哪些请求
 * 2.把这些配置放在容器中
 */
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
    /**
     * 目标方法执行完成以后
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 目标方法执行完成以前
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String requestURI = request.getRequestURI();
        log.info("拦截的请求路径{}",requestURI);

        //登录检查逻辑
        HttpSession session = request.getSession();

        Object loginAdmin = session.getAttribute("admin");

        if (loginAdmin != null){

            return true;
        }
        request.setAttribute("msg","请先登录");
        //response.sendRedirect("/");
        request.getRequestDispatcher("/").forward(request,response);

        return false;
    }

    /**
     * 页面渲染后
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
