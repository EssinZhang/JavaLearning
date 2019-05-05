<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>test1</title>
</head>
<body>

    <form method="post" action="/Params/User/userInfo2.do">
        姓名：<input type="text" name="username"/>
        <br>
        年龄：<input type="number" name="userage"/>
        <br>
        <%--在对象中又封装了一个对象的情况下要用 对象.属性的方式--%>
        国家：<input type="text" name="region.country"/>
        <br>
        省份：<input type="text" name="region.province"/>
        <br>
        <input type="submit" value="提交">
    </form>

</body>
</html>
