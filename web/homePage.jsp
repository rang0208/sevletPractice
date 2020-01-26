<%--
  Created by IntelliJ IDEA.
  User: Swing
  Date: 2020/1/25
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页</title>
</head>
<body>
<h3>${message}</h3>
<a href="${pageContext.request.contextPath}/allUserServlet">获取所有用户名单</a>
</body>
</html>
