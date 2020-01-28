package com.qianqian.practice.web.servlet;

import com.qianqian.practice.entity.User;
import com.qianqian.practice.service.UserService;
import com.qianqian.practice.service.impl.UserServiceImpl;
import com.qianqian.practice.utils.ConfigUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

@WebServlet(name = "GetAllUserServlet", value = "/allUserServlet")
public class GetAllUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = new UserServiceImpl();
        //数据库的数据量
        int totalUsers = userService.getAllUserNum();
        //获取配置文件对象
        Properties globalProperties = ConfigUtils.getGlobalProperties();
        //获取配置中的每页的大小
        int pageSize = Integer.parseInt(globalProperties.getProperty("pageSize"));
        //总共可以显示的页数
        int totalPages = totalUsers % pageSize == 0 ? totalUsers / pageSize : totalUsers / pageSize + 1;
        //页码数
        int pageNumber = 1;
        //获取请求的页数字符串
        String pageNumberString = request.getParameter("pageNumber");
        //如果不是第一次请求
        if (pageNumberString != null) {
            pageNumber = Integer.parseInt(pageNumberString);
            if (pageNumber < 1) pageNumber++;
            if (pageNumber > totalPages) pageNumber--;
        }

        //如果还可以取一页数据
        if (pageNumber > 0 && pageNumber <= totalPages) {
            List<User> userList = userService.getUserListByPage(pageNumber);
            request.setAttribute("userList", userList);
            request.setAttribute("pageNumber", pageNumber);
            request.setAttribute("pageSize",pageSize);
            request.setAttribute("totalPages", totalPages);
        }
        request.getRequestDispatcher("/allUserList.jsp").forward(request, response);
    }
}
