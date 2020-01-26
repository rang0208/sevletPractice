<%--
  Created by IntelliJ IDEA.
  User: Swing
  Date: 2020/1/24
  Time: 19:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/loginServlet" style="margin-left: 40%;margin-top: 20%">
    <table>
        <tr>
            <td>用户名</td>
            <td><input type="text" name="userName"/></td>
        </tr>
        <tr>
            <td>用户密码</td>
            <td><input type="password" name="userPassword"/></td>
        </tr>
        <tr>
            <td></td>
            <td><img src="validateCode"></td>
        </tr>
        <tr>
            <td>请输入验证码：</td>
            <td><input type="text" name="validCode"/></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="登录"><input type="reset" value="重置"/>
                <a href="register.jsp">注册用户</a></td>
        </tr>
    </table>
</form>
</body>
</html>
