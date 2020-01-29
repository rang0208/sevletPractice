package com.qianqian.practice.web.servlet;

import com.qianqian.practice.service.FileService;
import com.qianqian.practice.service.impl.FileServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@WebServlet(name = "DeleteFileServlet", value = "/deleteFileServlet")
public class DeleteFileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FileService fileService = new FileServiceImpl();
        //获取fileId
        String fileId = request.getParameter("fileId");
        //获取文件存储名
        String fileStorageName = fileService.getFileStorageName(fileId);
        //将文件信息从数据库中删除
        fileService.deleteFileByFileId(fileId);
        //获取文件该文件的存储位置，并将其删除
        String fileRealName = request.getServletContext().getRealPath("/WEB-INF/upLoadFiles") + File.separator + fileStorageName;
        File file = new File(fileRealName);
        if (file.exists()) file.delete();
        request.getRequestDispatcher("/getAllUserFiles").forward(request, response);
    }
}
