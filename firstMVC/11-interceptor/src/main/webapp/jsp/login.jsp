<%--
  Created by IntelliJ IDEA.
  User: ZYX'sDay
  Date: 2019/5/8
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <%--当访问该页面时默认登录kobe账户--%>
    <%
        request.getSession().setAttribute("user","kobe");
    %>
</head>
<body>

</body>
</html>
