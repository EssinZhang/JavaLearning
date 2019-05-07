<%--
  Created by IntelliJ IDEA.
  User: ZYX'sDay
  Date: 2019/5/7
  Time: 16:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>addUser</title>
</head>
<body>

    <form action="/08/user/addUser.do" method="post">
        姓名：<input type="text" name="name"><br>
        年龄：<input type="number" name="age"><br>
        生日：<input type="date" name="birthday"><br>
        <input type="submit" value="提交">
    </form>

</body>
</html>
