package com.qianqian.practice.web.filter;

import com.qianqian.practice.service.UserService;
import com.qianqian.practice.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 验证是否已经登录（Session与Cookie）
 */
@WebFilter(filterName = "LoginFilter")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        UserService userService = new UserServiceImpl();
        HttpServletRequest httpServletRequest = (HttpServletRequest) req;
        HttpServletResponse httpServletResponse = (HttpServletResponse) resp;
       //使用Cookie来验证
        Cookie[] cookies = httpServletRequest.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("userInfo")) {
                    //分别获取用户名和密码
                    String[] strings = cookie.getValue().split("##");
                    //检查登录信息是否正确
                    if (userService.loginCheck(strings[0], strings[1])) {
                        httpServletRequest.setAttribute("message", "欢迎您！用户：" + strings[0]);
                        httpServletRequest.getRequestDispatcher("/homePage.jsp").forward(httpServletRequest, httpServletResponse);
                    }
                }
            }
        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
