package com.qianqian.practice.web.servlet;

import com.qianqian.practice.entity.User;
import com.qianqian.practice.service.UserService;
import com.qianqian.practice.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "GetAllUserServlet",value = "/allUserServlet")
public class GetAllUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService=new UserServiceImpl();
        List<User> userList=userService.getAllUsers();
        request.setAttribute("userList",userList);
        request.getRequestDispatcher("/allUserList.jsp").forward(request,response);
    }
}
