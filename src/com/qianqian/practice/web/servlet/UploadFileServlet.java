package com.qianqian.practice.web.servlet;

import com.qianqian.practice.service.FileService;
import com.qianqian.practice.service.impl.FileServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@WebServlet(name = "UploadFileServlet", value = "/uploadFileServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 100, maxFileSize = 1024 * 1024 * 100, maxRequestSize = 1024 * 1024 * 200)
public class UploadFileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //文件业务类
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
        //得到上传文件的保存目录，将上传的文件存放于WEB-INF目录下，不允许外界直接访问，保证上传文件的安全
        String fileRootPath = request.getServletContext().getRealPath("/WEB-INF/upLoadFiles");
        //获取该文件夹对象
        File upLoadRootFile = new File(fileRootPath);
        if (!upLoadRootFile.exists()) upLoadRootFile.mkdirs();

        Part filePart = request.getPart("uploadFile");
        String fileName = filePart.getSubmittedFileName();
        //检查文件名是否为空字符串
        if (!fileName.equals("")) {
            //使用UUID标识文件，保证唯一性
            String fileId = UUID.randomUUID().toString();
            //获取fileNewName,用于在文件夹中的名称
            String fileNewName = fileId + "##" + fileName;
            //获取文件大小
            long size = filePart.getSize();
            int fileSize = (int) size;
            //将文件和用户关联的数据添加到数据库
            fileService.insertFile(fileId, fileName, fileSize, userId);
            //将文件写入服务器目录下
            filePart.write(fileRootPath + File.separator + fileNewName);
            //清除缓存
            filePart.delete();
        }
        request.getRequestDispatcher("/getAllUserFiles").forward(request, response);
    }
}
