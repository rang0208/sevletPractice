<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
    <title>Java Server Page Standard Tag Library</title>
</head>
<body>

<table border="1" width="30%" bordercolor="black" cellspacing="0" align="center">
    <tr>
        <th>NAME</th>
        <th>GENDER</th>
    </tr>

    <c:forEach items="${userList}" var="user">
        <tr>
            <td>${user.userName}</td>
            <td>${user.userGender}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

