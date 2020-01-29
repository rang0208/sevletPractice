<%--
  Created by IntelliJ IDEA.
  User: Swing
  Date: 2020/1/28
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户文件</title>
</head>
<body>
<table border="1" width="30%" bordercolor="black" cellspacing="0" align="center" style="margin-top: 10%">
    <tr>
        <th>文件名</th>
        <th>上传日期</th>
        <th>文件大小</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${fileInfoList}" var="file">
        <tr>
            <td>${file.fileName}</td>
            <td>${file.fileUploadDate}</td>
            <td>${file.fileSize}</td>
            <td><a href="${pageContext.request.contextPath}/downLoadService?fileId=${file.fileId}">下载</a>
                <a href="${pageContext.request.contextPath}/deleteFileServlet?fileId=${file.fileId}">删除</a>
            </td>
        </tr>
    </c:forEach>
</table>
<br><br><br>
<div align="center">
    <h3>上传文件</h3>
    <form action="${pageContext.request.contextPath}/uploadFileServlet" method="post" enctype="multipart/form-data">
        <table>
            <tr>
                <td>文件：</td>
                <td><input type="file" name="uploadFile"/></td>
            </tr>
            <tr>
                <td><input type="submit" value="上传"/></td>
                <td><input type="reset" value="重置"/><a href="${pageContext.request.contextPath}/homePage.jsp">返回主页</a>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
