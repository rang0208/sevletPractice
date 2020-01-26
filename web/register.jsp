<%--
  Created by IntelliJ IDEA.
  User: Swing
  Date: 2020/1/25
  Time: 12:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册用户</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/registerServlet"
      style="margin-left: 40%;margin-top: 20%">

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
            <td>重复密码</td>
            <td><input type="password" name="ReUserPassword"/></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="radio" name="userGender" value="女" checked/>女
                <input type="radio" name="userGender" value="男"/>男
            </td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="注册"><input type="reset" value="重置"></td>
        </tr>
    </table>
</form>
</body>
</html>
