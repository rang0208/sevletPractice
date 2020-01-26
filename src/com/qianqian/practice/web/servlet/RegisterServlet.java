package com.qianqian.practice.web.servlet;

import com.qianqian.practice.service.UserService;
import com.qianqian.practice.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@WebServlet(name = "RegisterServlet", value = "/registerServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = new UserServiceImpl();
        String userName = request.getParameter("userName");
        //检查此用户名是否存在
        if (!userService.checkUserName(userName)) {
            String userPassword = request.getParameter("userPassword");
            String reUserPassword = request.getParameter("ReUserPassword");
            //检查两次密码是否一样
            if (userPassword.equals(reUserPassword)) {
                String userGender = request.getParameter("userGender");
                //生成唯一ID
                UUID uuid = UUID.randomUUID();
                String userId = uuid.toString();
                if(userService.insertUser(userId,userName,userPassword,userGender)){
                    response.sendRedirect(request.getContextPath()+"/login.jsp");
                }
            } else {
                request.setAttribute("message", "两次密码不一致");
                request.getRequestDispatcher("/errorPage/message.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("message", "用户名已存在");
            request.getRequestDispatcher("/errorPage/message.jsp").forward(request, response);
        }
    }
}
