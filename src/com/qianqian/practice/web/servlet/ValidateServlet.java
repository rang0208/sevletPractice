package com.qianqian.practice.web.servlet;

import cn.dsna.util.images.ValidateCode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ValidateServlet",value = "/validateCode")
public class ValidateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //构造参数依次是（宽，高，验证码字符数，干扰线数）
        ValidateCode validateCode=new ValidateCode(200,40,4,30);
        //如不需要控制台显示验证码字符串，则以下两行不需要
        String validateCodeString=validateCode.getCode();
        getServletContext().setAttribute("validateCodeString",validateCodeString);
        validateCode.write(response.getOutputStream());
    }
}