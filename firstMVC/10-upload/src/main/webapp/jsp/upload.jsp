<%--
  Created by IntelliJ IDEA.
  User: ZYX'sDay
  Date: 2019/5/8
  Time: 9:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Upload</title>
</head>
<body>
    <form enctype="multipart/form-data" method="post" action="/10/upload02.do">
        图片1：<input type="file" name="picture"><br>
        图片2：<input type="file" name="picture"><br>
        图片3：<input type="file" name="picture"><br>
        <input type="submit" value="上传">
    </form>
</body>
</html>
