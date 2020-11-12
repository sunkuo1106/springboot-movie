<%--
  Created by IntelliJ IDEA.
  User: 孙阔
  Date: 2020/10/15
  Time: 22:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" >
<head>
    <meta charset="UTF-8">
    <title>星空影城支付成功</title>
    <link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Acme'>
    <link rel="stylesheet" href="/static/css/zfstyle.css">
    <script src='/static/js/jquery.min.js'></script>
</head>
<body>

<div class="top">
    <div class="ribbonTop"></div>
    <div class="ghost">
        <div class="eye left">
            <div class="eyeball"></div>
        </div>
        <div class="eye right">
            <div class="eyeball"></div>
        </div>
    </div>
    <div class="hand right"></div>
</div>
<div class="bottom">
    <div class="hand left"></div>
    <div class="ribbonBottom"></div>
    <div class="ribbonBottom h"></div>
</div>
<div>
    <input hidden class="phone" value="${users.uphone}">
    <h3 class="ghostText">购票成功!</h3>
</div>
<div class="pageLoading">
    <div class="pumpkin">
        <div class="pumpkinHead"></div>
        <div class="eye left"></div>
        <div class="eye right"></div>
        <div class="mouth"></div>
    </div>
    <div class="loading">
        <div class="bar"></div>
    </div>
</div>
<script src="/static/js/zfindex.js"></script>
<script type="text/javascript">
    $(function () {
        $.post("/buyMovie","",function (result) {

        },"json")
        var phone=$(".phone").val();
        var json={
            phone:phone
        }
        $.post("/doPhone2",json,function (result) {
            if(result.a=="true"){
                // alert(result.status);
            }else{
                //alert(result.error)
            }
        },"json")

    })
    setInterval (function () {

        location.href="/";
    }, 11000);
</script>
</body>
</html>
