<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>UserAdd</title>
    <link href="/css/bootstrap.css" rel="stylesheet">
</head>
<body>
<div class="page-header"></div>
<div class="container">
    <form action="/create.do" method="post" style="max-width: 330px;padding: 15px;margin: 0 auto;">
        <div class="form-group">
            <label for="name">姓名:</label>
            <input type="text" class="form-control" id="name" name="name">
        </div>
        <div class="form-group">
            <label for="tel">手机:</label>
            <input type="text" class="form-control" id="tel" name="tel">
        </div>
        <div class="form-group">
            <label for="birth">生日:</label>
            <input type="date" class="form-control" id="birth" name="birth">
        </div>
        <div class="form-group">
            <label for="addr">地址:</label>
            <input type="text" class="form-control" id="addr" name="addr">
        </div>

        <input type="submit" value="提交">
    </form>
</div>
<script src="/js/jquery-3.3.1.min.js"></script>
<script src="/js/bootstrap.js"></script>
</body>
</html>