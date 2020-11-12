<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/9/10
  Time: 22:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <title>星空影城</title>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="apple-touch-fullscreen" content="yes">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <meta name="format-detection" content="telephone=no">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link href="/static/css/style.css" rel="stylesheet" type="text/css" media="all"/>
    <link href="/static/css/slider.css" rel="stylesheet" type="text/css" media="all"/>

    <link href="/static/css/jquery.searchableSelect.css" rel="stylesheet" type="text/css">
    <script src="/static/js/jquery-1.11.1.min.js"></script>
    <script src="/static/js/jquery.searchableSelect.js"></script>

    <link rel="stylesheet" href="/static/css/yemiandibustyle.css">

    <link href="http://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">

    <link rel="stylesheet" type="text/css" href="/static/css/base.css">
    <link rel="stylesheet" type="text/css" href="/static/css/tab.css">

    <script type="text/javascript" src="/static/js/move-top.js"></script>
    <script type="text/javascript" src="/static/js/easing.js"></script>
    <script type="text/javascript" src="/static/js/jquery.nivo.slider.js"></script>
    <script type="text/javascript">
        $(window).load(function() {
            $('#slider').nivoSlider();
        });

    </script>
    <script>
        $(function(){
            $('select').searchableSelect();
        });
    </script>
</head>
<style>
    /*搜索框*/
    .bar7 form {
        width: 300px;
        margin-top: 0px;
        margin-right: 390px;
    }
    .bar7 input,
    button {
        border: none;
        outline: none;
    }
    .bar7 input {
        width: 100%;
        height: 40px;
        padding-left: 13px;
        position: relative;
        left: 470px;
    }
    .bar7 button {
        height: 42px;
        width: 42px;
        cursor: pointer;
        position: absolute;
    }
    .bar7 input {
        width: 250px;
        border-radius: 42px;
        border: 1px solid #EDEDED;
        background: #FCFCFC;
        transition: .3s linear;
        float: right;
    }
    .bar7 input:hover{
        border: 1px solid orangered;
    }
    .bar7 input:focus {
        width: 485px;
    }
    .bar7 button {
        background: none;
        left: 910px;
    }
    .bar7 button:before {
        content: "\f002";
        font-family: FontAwesome;
        color: #FF4500;
    }
    /**/
    /*.dyItem{*/
    /*    border:1px dashed  #EBE8E8;*/
    /*}*/
</style>
<body>
<div class="header">
    <div class="headertop_desc">
        <div class="wrap">
            <div class="nav_list">
                <ul>
                    <!--						<li><a href="/static/contact.html">联系</a></li>-->
                    <li>
                        <select name="city" id="select" style="z-index: 100;">
                            <option value="1">上海</option>
                            <option value="2" selected>北京</option>
                            <option value="105">保定</option>
                            <option value="3">深圳</option>
                            <option value="4">重庆</option>
                            <option value="5">广州</option>
                            <option value="6">成都</option>
                            <option value="7">武汉</option>
                            <option value="8">东莞</option>
                            <option value="9">天津</option>
                            <option value="10">杭州</option>
                            <option value="11">沈阳</option>
                            <option value="12">佛山</option>
                            <option value="13">合肥</option>
                            <option value="14">南京</option>
                            <option value="15">长沙</option>
                            <option value="16">西安</option>
                            <option value="17">郑州</option>
                            <option value="18">宁波</option>
                            <option value="19">大连</option>
                            <option value="20">青岛</option>
                        </select>
                    </li>
                    <li><a href="javascript:void(0)" onclick="selectCityCinema()">选择城市</a></li>
                    <li><a href="javascript:void(0)">影片</a></li>
                    <li><a href="/baidu">附近影城</a></li>
                </ul>
            </div>
            <div class="account_desc">
                <ul>
                    <li>
                        <c:if test="${users==null}">
                            <a href="/static/jsp/login.jsp">登录</a>
                        </c:if>
                        <c:if test="${users!=null}">
                            <a href="javascript:void(0)">${users.uname}</a>
                            <a href="/zhuxiao">注销</a>
                        </c:if>
                    </li>
                    <li><a href="/static/preview.html">交付记录</a></li>
                    <li><a href="#">我的账户</a></li>
                </ul>
            </div>
            <div class="clear"></div>
        </div>
    </div>
    <div class="wrap">
        <div class="header_top">
            <div class="logo">
                <a href="index.html"><img src="/static/images/logo.png" alt="" /></a>
            </div>
            <div class="header_top_right">
                <div class="cart">
                    <p><span>购物车</span><div id="dd" class="wrapper-dropdown-2"> (空)
                    <ul class="dropdown">
                        <li>您的购物车中没有商品</li>
                    </ul></div></p>
                </div>
                <div class="search_box">
                    <form>
                        <input type="text" value="Search" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Search';}"><input type="submit" value="">
                    </form>
                </div>
                <div class="clear"></div>
            </div>
            <script type="text/javascript">
                function DropDown(el) {
                    this.dd = el;
                    this.initEvents();
                }
                DropDown.prototype = {
                    initEvents : function() {
                        var obj = this;

                        obj.dd.on('click', function(event){
                            $(this).toggleClass('active');
                            event.stopPropagation();
                        });
                    }
                }

                $(function() {

                    var dd = new DropDown( $('#dd') );

                    $(document).click(function() {
                        // all dropdowns
                        $('.wrapper-dropdown-2').removeClass('active');
                    });

                });
            </script>
        </div>

    </div>
</div>


<div style="border: pink 1px solid;width: 1215px;margin-top: 100px;margin-left: 165px;">
<%--    <div class="bar7">--%>
<%--        <form action="#">--%>
<%--            <input class="bar7_text" type="text" placeholder="请搜索影院名称/关键字">--%>
<%--            <button type="submit"></button>--%>
<%--        </form>--%>
<%--    </div>--%>
<%--    <div class="dyItem">--%>
<%--        <p>电影名称</p>--%>
<%--        <p>地址：朝阳区东大桥路9号芳草地大厦LG2-26</p>--%>
<%--        <p>电话：010-56907679,0</p>--%>
<%--        <p>更多：<a>影院服务</a><a>交通信息</a></p>--%>
<%--    </div>--%>

    <div class="aui-nav-content-box">
        <div class="aui-nav-list-tab">
            <div class="aui-nav-list-item divxun" style="display:block">
                <%--循环开始--%>
            </div>
        </div>
    </div>

</div>



<script type="text/javascript">
    $(document).ready(function() {
        $().UItoTop({ easingType: 'easeOutQuart' });
        selectCityCinema();
    });

    //根据城市查询当天上映所有电影
    function selectCityCinema() {
        var lat=${lat}
        var lng=${lng}
        var json={
            lat:lat,
            lng:lng
        }
        $.post("/baiduCha",json,function (result) {
            console.log(result.cc);
            $(".divxun div").remove();
            $.each(result.cc,function (i,v) {
                    $(".divxun").append("<div class=\"aui-page-list\">\n" +
                        "                    <div class=\"aui-page-img\">\n" +
                        "                        <a href=\"javascript:;\">\n" +
                        "                            <img src=\"/static/images/xkLogo.jpg\">\n" +
                        "                        </a>\n" +
                        "                    </div>\n" +
                        "                    <div class=\"aui-page-text\">\n" +
                        "                        <h2>\n" +
                        "                            <a href=\"javascript:;\" class='a'>" + v.cinemaName + "</a>\n" +
                        "                            <input type='hidden' class='cinemaId' value='" + v.id + "'>\n" +
                        "                        </h2>\n" +
                        "                        <p>\n" +
                        "                            <em>电话:" + v.telephone + "</em>\n" +
                        "                            <em>地址:" + v.address + "</em>\n" +
                        "                        </p>\n" +
                        "                    </div>\n" +
                        "                </div>");

            })
            $(".a").click(function () {
                var cinemaId=$(this).next().val();
                var yingchengName=$(this).text();
                var json={
                    cinemaId:cinemaId,
                    yingchengName:yingchengName
                }
                $.post("/selectByCinema",json,function (result) {
                    if(result.status=="true"){
                        location.href="/static/jsp/Cinema.jsp";
                    }
                },"json")
            })
        },"json")
    }



</script>
<a href="#" id="toTop"><span id="toTopHover"> </span></a>

</body>
</html>
