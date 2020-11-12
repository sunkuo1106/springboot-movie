<%--
  Created by IntelliJ IDEA.
  User: 孙阔
  Date: 2020/10/29
  Time: 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>星空影城电影</title>
    <link href="/static/css/style.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" type="text/css" href="/static/css/CinemaStyle.css"/>
    <script type="text/javascript" src="/static/js/jquery.js"></script>
</head>
<style type="text/css">
    .account_desc li a {
        font-size: 1em;
        color: #9C9C9C;
        padding: 0 10px;
        font-family: 'ambleregular';
        -webkit-transition: all 0.3s ease-out;
        -moz-transition: all 0.3s ease-out;
        -ms-transition: all 0.3s ease-out;
        -o-transition: all 0.3s ease-out;
        transition: all 0.3s ease-out;
    }
    .nav_list li a {
        font-size:1em;
        color: #9C9C9C;
        padding: 0 10px;
        font-family: 'ambleregular';
        -webkit-transition: all 0.3s ease-out;
        -moz-transition: all 0.3s ease-out;
        -ms-transition: all 0.3s ease-out;
        -o-transition: all 0.3s ease-out;
        transition: all 0.3s ease-out;
    }
</style>
<body>
<div class="header">
    <div class="headertop_desc">
        <div class="wrap">
            <div class="nav_list">
                <ul>
                    <li><a href="/">首页</a></li>
                    <li><a href="javascript:void(0)">影片</a></li>
                    <li><a href="javascript:void(0)">影城</a></li>
                </ul>
            </div>
            <div class="account_desc">
                <ul>
                    <li>
                        <c:if test="${users==null}">
                            <a href="/static/jsp/login.jsp">登录</a>
                        </c:if>
                        <c:if test="${users!=null}">
                            <a href="/static/jsp/user_order_layui.jsp">${users.uname}</a>
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
                <a href="index.html"><img src="/static/images/logo.png" alt=""/></a>
            </div>
            <div class="header_top_right">
                <div class="cart">
                    <p><span>购物车</span>
                    <div id="dd" class="wrapper-dropdown-2"> (空)
                        <ul class="dropdown">
                            <li>您的购物车中没有商品</li>
                        </ul>
                    </div>
                    </p>
                </div>
                <div class="search_box">
                    <form>
                        <input type="text" value="搜索" onfocus="this.value = '';"
                               onblur="if (this.value == '') {this.value = '搜索';}"><input type="submit" value="">
                    </form>
                </div>
                <div class="clear"></div>
            </div>
            <div class="clear"></div>
        </div>
    </div>
</div>
<div class="main">
    <div class="dy-content">
        <div class="dy-videos">
            <input type="hidden" class="cinemaId" value="${sessionScope.cinemaId}">
            <ul class="dy-video-list ulxun">
                <%--开始循坏--%>
            </ul>
        </div>
    </div>
</div>
<div class="footer">
    <div class="wrap">
        <div class="section group">
            <div class="col_1_of_4 span_1_of_4">
                <h4>信息</h4>
                <ul>
                    <li><a href="#">关于我们</a></li>
                    <li><a href="#">客户服务</a></li>
                    <li><a href="#">高级搜索</a></li>
                    <li><a href="#">订单</a></li>
                    <li><a href="contact.html">联系我们</a></li>
                </ul>
            </div>
            <div class="col_1_of_4 span_1_of_4">
                <h4>Why buy from us</h4>
                <ul>
                    <li><a href="#">关于我们</a></li>
                    <li><a href="#">客户服务</a></li>
                    <li><a href="#">隐私政策</a></li>
                    <li><a href="contact.html">网站地图</a></li>
                    <li><a href="#">搜索词</a></li>
                </ul>
            </div>
            <div class="col_1_of_4 span_1_of_4">
                <h4>我的账户</h4>
                <ul>
                    <li><a href="contact.html">登录跟踪</a></li>
                    <li><a href="index.html">查看购物车</a></li>
                    <li><a href="#">愿望列表</a></li>
                    <li><a href="#">订单</a></li>
                    <li><a href="contact.html">帮助</a></li>
                </ul>
            </div>
            <div class="col_1_of_4 span_1_of_4">
                <h4>联系</h4>
                <ul>
                    <li><span>+91-123-456789</span></li>
                    <li><span>+00-123-000000</span></li>
                </ul>
                <div class="social-icons">
                    <h4>跟踪我们</h4>
                    <ul>
                        <li><a href="#" target="_blank"><img src="/static/images/facebook.png" alt=""/></a></li>
                        <li><a href="#" target="_blank"><img src="/static/images/twitter.png" alt=""/></a></li>
                        <li><a href="#" target="_blank"><img src="/static/images/skype.png" alt=""/> </a></li>
                        <li><a href="#" target="_blank"> <img src="/static/images/linkedin.png" alt=""/></a></li>
                        <div class="clear"></div>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script type="text/javascript">
    $(function () {
        $.post("/selectCinema","",function (result) {
            $(".ulxun li").remove();
            $.each(result.o.lists,function (i,v) {
                // var number =0;
                // $.post("/selecltBySize",{movieid:v.movieId},function (result) {
                //     number = result.size;
                $(".ulxun").append("<li data- class=\"dy-video-item dy-video-meta-right liclass\">\n" +
                    "                        <input type='hidden' class='movieId' value='"+v.movieId+"'>\n" +
                    "                    <div class=\"dy-video-meta\">\n" +
                    "                        <div class=\"dy-video-meta-bg\"> </div>\n" +
                    "                        <div class=\"dy-video-meta-dy divxiangqing\">\n" +

                    "                        </div>\n" +
                    "                        <div class=\"dy-video-meta-bg\"> </div>\n" +
                    "                    </div>\n" +
                    "                    <div class=\"dy-video-poster\"> <a class=\"dy-video-link\"> <img class=\"dy-video-img\" src=\""+v.pic_url+"\" alt=\""+v.movieName+"\"> <span class=\"dy-video-nocomplete\"></span> <span class=\"dy-video-date\"> 2018 年 </span> <span class=\"dy-video-bg\"></span> <span class=\"s-pay\"></span> </a> </div>\n" +
                    "                    <div class=\"dy-video-primary\">\n" +
                    "                        <h4 class=\"dy-video-title\"><a> "+v.movieName+" </a> </h4>\n" +
                    "                        <span class=\"dy-video-rating\"> 7.3 </span> </div>\n" +
                    "                </li>")
                // },"json")
            })
            $(".liclass").hover(function () {
                var movieId=$(this).children(".movieId").val();
                var thiss= $(this).children(".dy-video-meta").children(".divxiangqing");
                console.log(thiss);
                var json2={
                    movieId:movieId
                }
                $.post("/selectCinemaByMovie",json2,function (result) {
                        thiss.append(
                        "                            <h4 class=\"dy-video-title\"> <a> "+result.o.title+" </a> </h4>\n" +
                        "                            <span class=\"dy-video-rating\">7.3</span>\n" +
                        "                            <ul class=\"dy-video-meta-list\">\n" +
                        "                                <li class=\"dy-video-actors\"> <span class=\"dy-video-tip\"> 主演: </span> <a>"+result.o.writers+"</a></li>\n" +
                        "                                <li class=\"dy-video-types\"> <span class=\"dy-video-tip\">类型:</span> <span class=\"dy-video-meta-filter\">"+result.o.genres+"</span> </li>\n" +
                        "                                <li class=\"dy-video-areas\"> <span class=\"dy-split\">|</span> <span class=\"dy-video-tip\">地区:</span> <span class=\"dy-video-meta-filter\">"+result.o.film_locations+"</span> </li>\n" +
                        "                                <li class=\"dy-video-starts\"> <span class=\"dy-split\">|</span> <span class=\"dy-video-tip\">年代:</span> <span class=\"dy-video-meta-filter\">"+result.o.year+"</span> </li>\n" +
                        "                            </ul>\n" +
                        "                            <p class=\"dy-video-intro\">"+result.o.plot_simple+" <a class=\"dy-video-intro-more\">更多</a> </p>\n"
                    )
                },"json")
            },function () {

            })
            $(".liclass").click(function () {
                var cinemaId=$(".cinemaId").val();
                var movieId=$(this).children(".movieId").val();
                location.href="/toPreviewycCinema?cinemaId="+cinemaId+"&movieId="+movieId+"";
            })
        },"json")
    })
</script>
</html>
