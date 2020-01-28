<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
    <title>Java Server Page Standard Tag Library</title>
</head>
<body>

<table border="1" width="20%" bordercolor="black" cellspacing="0" align="center" style="margin-top: 10%">
    <tr>
        <th>NUM</th>
        <th>NAME</th>
        <th>GENDER</th>
    </tr>
    <c:set var="i" value="${(pageNumber-1)*pageSize+1}"/>
    <c:forEach items="${userList}" var="user">
        <tr>
            <td>${i}</td>
            <c:set var="i" value="${i+1}"/>
            <td>${user.userName}</td>
            <td>${user.userGender}</td>
        </tr>
    </c:forEach>
</table>
<br><br>
<div align="center">
    <a href="${pageContext.request.contextPath}/allUserServlet?pageNumber=1">首页</a>
    <a href="${pageContext.request.contextPath}/allUserServlet?pageNumber=${pageNumber-1}">上一页</a>
    <a href="${pageContext.request.contextPath}/allUserServlet?pageNumber=${pageNumber+1}">下一页</a>
    <a href="${pageContext.request.contextPath}/allUserServlet?pageNumber=${totalPages}">尾页</a>
    <a href="${pageContext.request.contextPath}/homePage.jsp">返回主页</a>
</div>
</body>
</html>

