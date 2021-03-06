package com.qianqian.practice.web.servlet;

import com.qianqian.practice.service.FileService;
import com.qianqian.practice.service.impl.FileServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

@WebServlet(name = "DownLoadServlet", value = "/downLoadService")
public class DownLoadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FileService fileService = new FileServiceImpl();
        //获取fileId
        String fileId = request.getParameter("fileId");
        //获取文件存储名(带UUID）
        String fileStorageName = fileService.getFileStorageName(fileId);
        //获取文件名
        String fileName = fileStorageName.split("##")[1];
        //获取文件该文件的存储位置
        String fileRealName = request.getServletContext().getRealPath("/WEB-INF/upLoadFiles") + File.separator + fileStorageName;
        File file = new File(fileRealName);
        //告诉浏览器将流以文件的形式保存
        response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "utf-8"));
        //将文件读入到程序,并通过Servlet输出到浏览器
        InputStream inputStream = new FileInputStream(file);
        ServletOutputStream servletOutputStream = response.getOutputStream();
        byte[] bytes = new byte[1024 * 1024 * 200];
        int len = 0;
        while ((len = inputStream.read(bytes)) != -1) {
            servletOutputStream.write(bytes, 0, len);
        }
        inputStream.close();
        servletOutputStream.close();

    }
}
