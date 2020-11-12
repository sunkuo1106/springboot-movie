<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/9/10
  Time: 9:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>星空影城电影详情</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link href="/static/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="http://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link href="/static/css/style.css" rel="stylesheet" type="text/css"/>
    <link href="/static/css/preview.css" rel="stylesheet" type="text/css" />
    <link href="/static/css/dtjjstyle.css" rel="stylesheet" type="text/css">

    <script type="text/javascript" src="/static/js/jquery.min.js"></script>
    <script src="/static/layer/layer.js" type="text/javascript" charset="utf-8"></script>
    <style>
        /*.account_desc li a{*/
        /*    font-size: 13.2px;*/
        /*}*/
        th{
            text-align: center;
        }
        .content {
            width: 600px;
            /*height: 600px;*/
             /*background: yellow;*/
            margin: 50px auto;
        }
        #table-1 {
            margin-left: -283px;
            line-height: 35px;
            width: 1170px;
        }
        #table-1 tr{
            height: 60px;
        }
        .table-1{
            position: relative;
            left: 0px;
            -webkit-transition: all 0.5s ease-in .1s;
            transition: all 0.5s ease-in .1s;
        }
        .table-1:hover{
            background-color: black;
        }
        /*.table-1 span a{*/
        /*    font-size: 13px;*/
        /*    color: white;*/
        /*    text-align: center;*/
        /*    line-height: 35px;*/
        /*    font-family: 'ambleregular';*/
        /*}*/

        #lin {
            /*margin: 20px 0;*/
            /*height: 30px;*/
            /*padding: 5px;*/
            box-sizing: border-box;
        }
    </style>
</head>
<body>
<div class="header">
    <div class="headertop_desc">
        <div class="wrap">
            <div class="nav_list">
                <ul>
                    <li><a href="/">首页</a></li>
                    <li><a href="javascript:void(0)">影片</a></li>
                    <li><a href="/static/jsp/index_cinema.jsp">影城</a></li>
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
    <div class="wrap">
        <div class="section group">
            <c:if test="${info!=null}">
                <div class="cont-desc span_1_of_2">
                    <div class="product-details">
                        <div class="grid images_3_of_2">
                            <img src="${info.poster}" alt="${info.title}"/>
                        </div>
                        <div class="desc span_3_of_2">
                            <h2 class="title">${info.title}</h2><c:if test="${info.rating!=-1}"><span style="color:red;position: absolute;top: 230px;left: 630px;">${info.rating}</span></c:if>
                            <c:if test="${info.rating==-1}"><span style="color:red;position: absolute;top: 230px;left: 630px;">未评分</span></c:if>
                            <div class="available"></div>
                            <p>导演：${info.directors}</p>
                            <p>主演：${info.actors}</p>
                            <p>类型：${info.genres}</p>
                            <p>语言：<span class="language">${info.language}</span></p>
                            <p>拍摄时间：${info.year}年</p >
                            <p>制片国家/地区：${info.country}</p>
                        </div>
                        <div class="clear"></div>
                    </div>
                    <div class="product_desc">
                        <h2>剧情介绍：</h2>
                        <p>${info.plot_simple}</p>
                    </div>
                </div>
            </c:if>
            <div class="rightsidebar span_3_of_1 sidebar">
                <h2>热门电影</h2>
                <div class="special_movies">
                    <div class="movie_poster">
                        <a href="preview.html"><img src="/static/images/end-game.jpg" alt=""/></a>
                    </div>
                    <div class="movie_desc">
                        <h3><a href="preview.html">结束游戏</a></h3>
                        <span><a href="#">选座购票</a></span>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="special_movies">
                    <div class="movie_poster">
                        <a href="preview.html"><img src="/static/images/Coraline.jpg" alt=""/></a>
                    </div>
                    <div class="movie_desc">
                        <h3><a href="preview.html">卡洛琳</a></h3>
                        <span><a href="#">选座购票</a></span>
                    </div>
                    <div class="clear"></div>
                </div>
            </div>
        </div>
    </div>
    <div class="selectbox">
        <div class="selemediv">
            <div class="bar7">
                    <input class="bar7_text" id="lin" type="text" placeholder="请输入您要搜索的内容...">
                    <button type="submit"></button>
            </div>
        </div>
    </div>
    <div style="color:#fff" id="cs">
        <div class="content">
            <table id="table-1" class="table-cc" cellspacing="0" border="1" style="text-align: center;">
                <tr class="trbt" style="font-size: 20px;height: 50px;line-height: 50px;">
                    <th>放映时间</th>
                    <th>语言版本</th>
                    <th>放映厅</th>
                    <th>现价/影院价(元)</th>
                    <th>选座购票</th>
                </tr>
            </table>
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
    <input type="hidden" class="cinemaId" value="${cinemaId}">
    <input type="hidden" class="movieId" value="${movieId}">
    <input type="hidden" class="yingchengName" value="${yingchengName}">
</div>



<script type="text/javascript" src="/static/js/move-top.js"></script>
<script src="/static/js/dtssscript.js" type="text/javascript"></script>
<script type="text/javascript" src="/static/js/lin_search.js"></script>
<script type="text/javascript" src="/static/js/easing.js"></script>

<script type="text/javascript">
    $(document).ready(function () {
        $().UItoTop({easingType: 'easeOutQuart'});
        var dd = new DropDown($('#dd'));
            var time=new Date();
            var timehover=time.getHours();
            var timemins=time.getMinutes();
            var timet=timehover+":"+timemins;
            var movieId=$(".movieId").val();
            var cinemaId=$(".cinemaId").val();
            var json={
                cinemaId:cinemaId,
                movieId:movieId
            }
            $.post("/previewycCinema",json,function (result) {
                console.log(result.cc.lists);
                $.each(result.cc.lists,function (i,v) {
                    $.each(v.broadcast,function (a,b) {
                        if(b.time<timet){
                        }else{
                            var yuyan="";
                            if(b.language==null||b.language==""){
                                yuyan="普通话";
                            }else{
                                yuyan=b.language;
                            }
                            $(".table-cc").append("<tr style='line-height:60px;' class='trys'>\n" +
                                "                    <td>"+b.time+"</td>\n" +
                                "                    <td>"+yuyan+"</td>\n" +
                                "                    <td>"+b.hall+"</td>\n" +
                                "                    <td>"+b.price+"</td>\n" +
                                "                    <td>\n" +
                                "                             <button type=\"button\" class=\"btn btn-warning table-1\">选座购票</button>\n" +
                                "                    </td>\n" +
                                "                </tr>");
                        }
                    })
                })
                $(".trys:odd").css("background-color","#F6F6F6");
                $(".table-1").click(function () {
                    if(${users==null}){
                        layer.msg('请您先进行登录!', function(){
                            //关闭后的操作
                            location.href="/login";
                        });
                    }else{
                        // alert("目前是登录状态");
                        var movieName="${info.title}";
                        var movieDate=$(this).parent().prev().prev().prev().prev().text();
                        var movieRoom=$(this).parent().prev().prev().text();
                        var moviePrice=$(this).parent().prev().text();
                        var yingchengid=$(".cinemaId").val();
                        var yingchengName=$(".yingchengName").val();
                        console.log(movieName);
                        console.log(movieDate);
                        console.log(movieRoom);
                        console.log(moviePrice);
                        console.log(yingchengid);
                        location.href="/buyTicket?movieName="+movieName+"&movieDate="+movieDate+"&movieRoom="+movieRoom+"&moviePrice="+moviePrice+"&yingchengid="+yingchengid+"&yingchengName="+yingchengName+"";
                    }
                })
            },"json")
            $(".ycli").click(function () {
                $(".table-cc tr:gt(0)").remove();
                var cinemaId=$(this).children(input).val();
                var language=$(".language").text();
                var json={
                    cinemaId:cinemaId
                }
                $.post("/previewycCinema",json,function (result) {
                    console.log(result.cc.lists);
                    $.each(result.cc.lists,function (i,v) {
                       $.each(v.broadcast,function (a,b) {
                           if(b.time<timet){
                           }else{
                               var yuyan="";
                               if(b.language==null||b.language==""){
                                   yuyan="普通话";
                               }else{
                                   yuyan=b.language;
                               }
                           $(".table-cc").append("<tr style='line-height:60px;' class='trys'>\n" +
                               "                    <td>"+b.time+"</td>\n" +
                               "                    <td>"+yuyan+"</td>\n" +
                               "                    <td>"+b.hall+"</td>\n" +
                               "                    <td>"+b.price+"</td>\n" +
                               "                    <td>\n" +
                               "                             <button type=\"button\" class=\"btn btn-warning table-1\">选座购票</button>\n" +
                               "                    </td>\n" +
                               "                </tr>");
                           }
                       })
                       })
                    $(".trys:odd").css("background-color","#F6F6F6");
                    $(".table-1").click(function () {
                        alert(1);
                        if(${users==null}){
                            layer.msg('请您先进行登录!', function(){
                                //关闭后的操作
                                location.href="/login";
                            });
                        }else{//进行购票的操作
                            // alert("目前是登录状态");
                            var movieName=$(".title").text();
                            var movieDate=$(this).parent().prev().prev().prev().prev().text();
                            var movieRoom=$(this).parent().prev().prev().text();
                            var moviePrice=$(this).parent().prev().text();
                            var yingchengid=$(".cinemaId").val();
                            var yingchengName=$(".yingchengName").val();
                            console.log(movieName);
                            console.log(movieDate);
                            console.log(movieRoom);
                            console.log(moviePrice);
                            console.log(yingchengid);
                            location.href="/buyTicket?movieName="+movieName+"&movieDate="+movieDate+"&movieRoom="+movieRoom+"&moviePrice="+moviePrice+"&yingchengid="+yingchengid+"&yingchengName="+yingchengName+"";
                        }
                    })
                },"json")
                $(".citylist2").hide();
            })

        $(document).click(function () {
            // all dropdowns
            $('.wrapper-dropdown-2').removeClass('active');
        });
        $(".selemenu").click(function(){
            $(this).next().slideToggle();
            $(this).parents().siblings().find(".citylist,.citylist2").slideUp();
        })
        $(".citylist span").click(function(){
            var text=$(this).text();
            $(this).parent().prev().html(text);
            $(this).parent().prev().css("color","#666")
            $(this).parent().fadeOut();

        })
        $(".shangquan li").click(function(){
            $(".shangquan li").removeClass("active")
            $(this).addClass("active")
            var text1=$(this).text();
            $(".sqinput").html(text1)
        })
        $(".chengshi li").click(function(){
            $(".chengshi li").removeClass("active")
            $(this).addClass("active")
            var text2=$(this).text();
            $(".csinput").html("-"+text2)
            $(".citylist2").slideUp();
        })
        $(document).not($(".selectbox")).click(function(){
            $(".citylist,.citylist2").slideUp();
        })
        $(".selectbox").click(function(event){
            event.stopPropagation();
        })
    });
    function DropDown(el) {
        this.dd = el;
        this.initEvents();
    }

    DropDown.prototype = {
        initEvents: function () {
            var obj = this;

            obj.dd.on('click', function (event) {
                $(this).toggleClass('active');
                event.stopPropagation();
            });
        }
    }


    var table = document.getElementById("table-1");
    var input = document.getElementById("lin")


    input.onkeyup = function () {
        new Search(table, input)
    }

    $(".trbt").css("background-color","#EAEAEA");
</script>
<a href="#" id="toTop"><span id="toTopHover"> </span></a>
</body>
</html>
