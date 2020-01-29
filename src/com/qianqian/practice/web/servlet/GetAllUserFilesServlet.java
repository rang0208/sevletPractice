package com.qianqian.practice.web.servlet;

import com.qianqian.practice.entity.FileInfo;
import com.qianqian.practice.service.FileService;
import com.qianqian.practice.service.impl.FileServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "GetAllUserFilesServlet", value = "/getAllUserFiles")
public class GetAllUserFilesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FileService fileService = new FileServiceImpl();
        //从Cookie中获取userId
        String userId = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("userInfo")) {
                    userId = cookie.getValue().split("##")[2];
                }
            }
        }
        List<FileInfo> fileInfoList = fileService.getFilesByUserId(userId);

        request.setAttribute("fileInfoList", fileInfoList);
        request.getRequestDispatcher("/userAllFiles.jsp").forward(request,response);
    }
}
