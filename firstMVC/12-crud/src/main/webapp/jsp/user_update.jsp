<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>UserUpdate</title>
    <link href="css/bootstrap.css" rel="stylesheet">
</head>
<body>
<div class="page-header"></div>
<div class="container">
    <form action="/update.do" method="post" style="max-width: 330px;padding: 15px;margin: 0 auto;">
        <input type="hidden" name="id" value="${id}">
        <div class="form-group">
            <label for="name">姓名:</label>
            <input type="text" class="form-control" value="${user.name}" name="name" id="name">
        </div>
        <div class="form-group">
            <label for="tel">手机:</label>
            <input type="text" class="form-control" id="tel" value="${user.tel}" name="tel">
        </div>
        <div class="form-group">
            <label for="birth">生日:</label>
            <input type="date" class="form-control" id="birth" value="${user.birth}" name="birth">
        </div>
        <div class="form-group">
            <label for="addr">地址:</label>
            <input type="text" class="form-control" id="addr" value="${user.addr}" name="addr">
        </div>

        <input type="submit" value="提交">
    </form>
</div>
<script src="js/jquery-3.3.1.min.js"></script>
<script src="js/bootstrap.js"></script>
</body>
</html>