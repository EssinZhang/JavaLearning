<%--
  Created by IntelliJ IDEA.
  User: ZYX'sDay
  Date: 2019/5/6
  Time: 15:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ajaxJump</title>
    <link rel="shortcut icon" href="#"/>
    <script type="text/javascript" src="/returnVal/js/jquery-3.3.1.js"></script>
</head>
<body>
    <button id="ajaxJump" >提交</button>
</body>
<script>
    $(function () {
        $("#ajaxJump").click(function () {
            /*$.ajax({
                method:"post",
                url:"/returnVal/ajaxJump.do",
                data:{name:"kobe",age:24},
                dataType:"json",
                success:function (result) {
                    alert(result.name + "," + result.age);
                }
            });*/

            /*$.ajax({
                method:"post",
                url:"/returnVal/returnObject01.do",
                success:function (result) {
                    alert(result);
                }
            });*/

            $.ajax({
                method:"post",
                url:"/returnVal/returnObject02.do",
                success:function (result) {
                    alert(result.hello + ":::" + result.world);
                }
            });
        });
    });

</script>
</html>
