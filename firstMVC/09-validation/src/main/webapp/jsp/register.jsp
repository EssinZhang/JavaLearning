<%--
  Created by IntelliJ IDEA.
  User: ZYX'sDay
  Date: 2019/5/7
  Time: 22:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>

    <form action="/09/user/register.do" method="post">
        姓名：<input type="text" name="name">${nameError}<br>
        年龄：<input type="number" name="age">${ageError}<br>
        电话：<input type="text" name="tel">${telError}<br>
        <input type="submit" value="提交">
    </form>

</body>
</html>
