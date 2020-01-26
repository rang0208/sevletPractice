package com.qianqian.practice.web.servlet;

import com.qianqian.practice.service.UserService;
import com.qianqian.practice.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = new UserServiceImpl();
        String validCode = request.getParameter("validCode");
        //验证码是否正确
        if (validCode.equalsIgnoreCase((String) this.getServletContext().getAttribute("validateCodeString"))) {
            String userName = request.getParameter("userName");
            String userPassword = request.getParameter("userPassword");
            if (userService.loginCheck(userName, userPassword)) {
                Cookie cookie = new Cookie("userInfo", userName + "##" + userPassword);
                cookie.setPath("/");
                //设置有效时间为三个小时
                cookie.setMaxAge(60 * 60 * 3);
                response.addCookie(cookie);
                //登录成功跳转到主页
                request.setAttribute("message", "欢迎您！用户：" + userName);
                request.getRequestDispatcher("/homePage.jsp").forward(request, response);
            } else {
                request.setAttribute("message", "用户名或密码有误，请检查！");
                request.getRequestDispatcher("/errorPage/message.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("message", "验证码输入错误！");
            request.getRequestDispatcher("/errorPage/message.jsp").forward(request, response);
        }
    }
}
