$(document).ready(function () {
    $(".uName").blur(function () {
        var uname=$(this).val();
        if(uname==""){
            $(".sp1").text("用户名不能为空");
            return;
        }else{
            $(".sp1").text("");
        }
    })
    $(".uPassword").blur(function () {
        var uPassword=$(this).val();
        if(uPassword==""){
            $(".sp2").text("密码不能为空");
            return;
        }else{
            $(".sp2").text("");
        }
    })
    $(".btn-login").click(function () {
        var uname=$(".uName").val();
        var uPassword=$(".uPassword").val();
        var reg=/^1\d{10}$/;
        if(uname!=""&&uPassword!="") {
            var json;
            if(reg.test(uname)==false) {
               json = {
                    uName: uname,
                    uPassword: uPassword
                }
            }else{
                 json = {
                    uPhone: uname,
                    uPassword: uPassword
                }
            }
            $.post("/doLogin", json, function (result) {
                if(result.status=="true"){
                    window.location.href=document.referrer;
                }else{
                    $(".sp3").text(result.error);
                }
            }, "json")
        }
    })
    $(".userName").blur(function () {
        var userName=$(this).val();

        if(userName==""){
            $(".sp4").text("用户名不能为空");
            return;
        }else{
            var json2={
                userName:userName
            }
            $.post("/doSelectAll",json2,function (result) {
                if (result.status == "true") {
                    $(".sp4").text("用户名不可用，已被注册");
                    return;
                } else {
                    $(".sp4").text("");
                }
            },"json")

        }

    })
    $(".userPwd").blur(function () {
        var userPwd=$(this).val();
        if(userPwd==""){
            $(".sp5").text("密码不能为空");
            return;
        }else{
            $(".sp5").text("");
        }
    })
    $(".userPhone").blur(function () {
        var userPhone=$(this).val();
        var reg=/^1\d{10}$/;
        if(userPhone==""){
            $(".sp6").text("手机号不能为空");
            return;
        }else if(reg.test(userPhone)==false){
            $(".sp6").text("手机号请填写正确");
            return;
        }else{
            $(".sp6").text("");
            $(".btn").fadeIn(500);
        }
    })
    $(".btn-add").click(function () {
        var userName=$(".userName").val();
        var userPwd=$(".userPwd").val();
        var userPhone=$(".userPhone").val();
        var yan=$(".yan").val();
        var yanZheng=$(".sp1").text();
        if(yan==""){
            $(".sp9").text("验证码不能为空");
            return;
        }
        if (yan1=="过期"){
            $(".sp9").text("验证码失效");
            return;
        }
        if(userName!=""&&userPwd!=""&&userPhone!="") {
            if(yan==yanZheng){
                var json = {
                    uname: userName,
                    upassword: userPwd,
                    uphone: userPhone
                }
                $.post("/doUserAdd", json, function (data) {
                    // alert(data);
                    if (data.status=="true") {
                        location.href = "/";
                    } else {
                        $(".sp7").text("系统繁忙");
                    }
                },"json")
            }else{
                $(".sp9").text("验证码错误");
            }

        }
    })
    var yan1="";
    $(".btn").click(function () {
        var phone=$(".userPhone").val();
        if(phone==""){
            $(".sp6").text("手机号不能为空");
            return;
        }

        var json2={
            userPhone:phone
        }

        var sum=60;
        $.post("/doSelectAll",json2,function (result) {
            if(result.status=="true"){
                $(".sp6").text("手机号不可用，已被注册");
                return;
            }else{
                time=setInterval(function dao() {
                    sum--;
                    $(".btn").text(sum);
                    $(".btn").css("background-color","grey");
                    $(".btn").attr("disabled","disabled");
                    // console.log(sum)
                    if (sum==0){
                        yan1="过期"
                        $(".btn").text("发送");
                        $(".btn").css("background-color","#D4AF7A");
                        $(".btn").removeAttr("disabled");
                        clearTimeout(time);
                    }
                    //#D4AF7A
                },1000)
                var json={
                    phone:phone
                }
                $.post("/doPhone",json,function (result) {
                    if(result.a=="true"){
                        // alert(result.yanZheng)
                         yan1=result.yanZheng;
                         console.log(yan1);
                        $(".sp1").text(result.yanZheng)
                    }else{
                    }
                },"json")
            }
        },"json")

    })



});