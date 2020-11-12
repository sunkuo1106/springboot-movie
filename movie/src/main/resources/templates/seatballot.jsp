<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/9/16
  Time: 20:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>星空影城选座购票</title>
    <meta name="keywords" content="jQuery在线选座,jQuery选座系统" />
    <meta name="description" content="jquery.seat-charts是一款适合电影票、高铁票的在线选座插件。" />
    <link rel="stylesheet" type="text/css" href="/static/css/jq22.css" />
    <link href="/static/css/style.css" rel="stylesheet" type="text/css"/>
    <style type="text/css">

        .front{width: 300px;margin: 5px 32px 45px 32px;background-color: #f0f0f0;	color: #666;text-align: center;padding: 3px;border-radius: 5px;}

        .booking_area {float: right;position: relative;width:400px;height: 450px; }

        .booking_area h3 {margin: 5px 5px 0 0;font-size: 16px;}

        .booking_area p{line-height:26px; font-size:16px; color:#999}

        .booking_area p span{color:#666}

        div.seatCharts-cell {color: #182C4E;height: 25px;width: 25px;line-height: 25px;margin: 3px;float: left;text-align: center;outline: none;font-size: 13px;}

        div.seatCharts-seat {color: #fff;cursor: pointer;-webkit-border-radius: 5px;-moz-border-radius: 5px;border-radius: 5px;}

        div.seatCharts-row {height: 35px;}

        div.seatCharts-seat.available {background-color: #B9DEA0;}

        div.seatCharts-seat.focused {background-color: #76B474;border: none;}

        div.seatCharts-seat.selected {background-color: #E6CAC4;}

        div.seatCharts-seat.unavailable {background-color: #472B34;cursor: not-allowed;}

        div.seatCharts-container {border-right: 1px dotted #adadad;width: 400px;padding: 20px;float: left;}

        div.seatCharts-legend {padding-left: 0px;position: absolute;bottom: 16px;}

        ul.seatCharts-legendList {padding-left: 0px;}

        .seatCharts-legendItem{float:left; width:90px;margin-top: 10px;line-height: 2;}

        span.seatCharts-legendDescription {margin-left: 5px;line-height: 30px;}

        .checkout-button {display: block;width:80px; height:24px; line-height:20px;margin: 10px auto;border:1px solid #999;font-size: 14px; cursor:pointer}

        #seats_chose {max-height: 150px;overflow-y: auto;overflow-x: none;width: 200px;}

        #seats_chose li{float:left; width:72px; height:26px; line-height:26px; border:1px solid #d3d3d3; background:#f7f7f7; margin:6px; font-size:14px; font-weight:bold; text-align:center}

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

<div class="container">
    <h2 class="title"><a href="http://www.jq22.com/jquery-info2692">星空影城选座购票</a></h2>
    <div class="demo clearfix">
        <!---左边座位列表----->
        <div id="seat_area">
            <div class="front">屏幕</div>
        </div>

        <!---右边选座信息----->
        <div class="booking_area">
            <p>电影：<span>${movieName}</span></p>
            <p>时间：<span>${time}</span></p>
            <p>放映厅：<span>${movieRoom}</span></p>
            <p>座位：</p>
            <ul id="seats_chose"></ul>
            <p>票数：<span id="tickects_num">0</span></p>
            <p>总价：<b>￥<span id="total_price">0</span></b></p>
            <input type="button" class="btn buy" value="确定购买"/>
            <div id="legend"></div>
            <input type="hidden" class="movieDate" value="${sessionScope.movieTicket.movieDate}">
            <input type="hidden" class="movieName" value="${sessionScope.movieTicket.movieName}">
            <input type="hidden" class="movieRoom" value="${sessionScope.movieTicket.movieRoom}">
            <input type="hidden" class="moviePrice" value="${sessionScope.movieTicket.moviePrice}">
            <input type="hidden" class="movieYingchengid" value="${sessionScope.movieTicket.movieYingchengid}">
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
</div>
<script src="http://www.jq22.com/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="/static/js/jquery.seat-charts.min.js"></script>
<script src="/static/layer/layer.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
    var price = ${price}; //电影票价
    var list1=new Array();
    var jie="";
    $(document).ready(function() {
        var $cart = $('#seats_chose'), //座位区
            $tickects_num = $('#tickects_num'), //票数
            $total_price = $('#total_price'); //票价总额
        var sc = $('#seat_area').seatCharts({
            map: [//座位结构图 a 代表座位; 下划线 "_" 代表过道
                <c:if test="${ting==0}">
                'cccccccccc', 'cccccccccc', '__________', 'cccccccc__', 'cccccccccc', 'cccccccccc', 'cccccccccc', 'cccccccccc', 'cccccccccc', 'cc__cc__cc'
                </c:if>
                <c:if test="${ting==1}">
                'cccccccccc', 'cccccccccc', 'cccccccccc', 'cccccccc__', 'cccccccccc', 'cccccccccc', 'cccccccccc', 'cccccccccc', 'cccccccccc', 'cccccccccc'
                </c:if>
                <c:if test="${ting==2}">
                'cccccccccc', 'cccccccccc', 'cccccccccc', 'cccccccccc', 'cccccccccc', 'cccccccccc', 'cccccccccc', 'cccccccccc', 'cccccccccc', 'cccccccccc'
                </c:if>
                <c:if test="${ting==3}">
                'cccccccccc', 'cccccccccc', 'cccccccc__', 'cccccccc__', 'cccccccccc', 'cccccccccc', 'cccccccccc', 'cccccccccc', 'cccccccccc', 'cc__cc__cc'
                </c:if>
                <c:if test="${ting==4}">
                '___ccccccc', '___ccccccc', '___ccccccc', '___ccccccc', '___ccccccc', '___ccccccc', '___ccccccc', '___ccccccc', '___ccccccc', '___ccccccc'
                </c:if>
                <c:if test="${ting==5}">
                'ccccccccc_', 'ccccccccc_', 'ccccccccc_', 'ccccccccc_', 'ccccccccc_', 'ccccccccc_', 'ccccccccc_', 'ccccccccc_', 'ccccccccc_', 'ccccccccc_'
                </c:if>
                <c:if test="${ting==6}">
                'cccccccccc', 'cccccccccc', 'cccccccccc', 'cccccccc__', 'cccccccccc', '__________', 'cccccccccc', 'cccccccccc', 'cccccccccc', 'cc__cc__cc'
                </c:if>
                <c:if test="${ting==7}">
                '_cccccccc_', '_cccccccc_', '_cccccccc_', '_cccccccc_', '_cccccccc_', '_cccccccc_', '_cccccccc_', '_cccccccc_', '_cccccccc_', 'cccccccccc'
                </c:if>
                //'cccccccccc', 'cccccccccc', '__________', 'cccccccc__', 'cccccccccc', 'cccccccccc', 'cccccccccc', 'cccccccccc', 'cccccccccc', 'cc__cc__cc'
            ],

            naming: {//设置行列等信息
                top: false, //不显示顶部横坐标（行）
                getLabel: function(character, row, column) { //返回座位信息
                    return column;
                }
            },

            legend: {//定义图例
                node: $('#legend'),
                items: [
                    ['c', 'available', '可选座'],
                    ['c', 'unavailable', '已售出']
                ]
            },

            click: function() {
                if (this.status() == 'available') { //若为可选座状态，添加座位
                    $('<li class="li">' + (this.settings.row + 1) + '排' + this.settings.label + '座</li>')
                        .attr('id', 'cart-item-' + this.settings.id)
                        .data('seatId', this.settings.id)
                        .appendTo($cart);
                    $tickects_num.text(sc.find('selected').length + 1); //统计选票数量
                    $total_price.text(getTotalPrice(sc) + price);//计算票价总金额
                    return 'selected';
                } else if (this.status() == 'selected') { //若为选中状态
                    $tickects_num.text(sc.find('selected').length - 1);//更新票数量
                    $total_price.text(getTotalPrice(sc) - price);//更新票价总金额
                    $('#cart-item-' + this.settings.id).remove();//删除已预订座位
                    return 'available';
                } else if (this.status() == 'unavailable') { //若为已售出状态
                    return 'unavailable';
                } else {
                    return this.style();
                }
            }
        });
        //设置已售出的座位
        // var json={
        //     zw:['1_3', '1_4', '4_4', '4_5', '4_6', '4_7', '4_8','6_1',]
        // }
        var json={
            yingpianname:$(".movieName").val(),
            yingyuanid:$(".movieYingchengid").val(),
            datetime:$(".movieDate").val(),
        }
        $.ajax({
            url:"/selectSeat",
            data:json,
            type:"POST",
            dataType:"json",
            async:false,
            success:function (result) {
                if(result.status=="true"){
                    $.each(result.jie,function (i,v) {
                        list1.push(v);
                    })
                }
                //list=['5_1','5_2','5_4','5_5','4_6','4_7','4_8','6_1'];
            }
        })
        //alert(list1);
        list1.push('1_1');
        list1.push('2_1');
        sc.get(list1).status('unavailable');
        $(".buy").click(function () { //结算前判断是否登录
            if(${users==null}){
                layer.msg('请您先进行登录!', function(){
                    //关闭后的操作
                    location.href="/login";
                });
            }else{
                var movieYingchengid=$(".movieYingchengid").val();
                var movieDate=$(".movieDate").val();
                var movieName=$(".movieName").val();
                var movieRoom=$(".movieRoom").val();
                var moviePrice=$("#total_price").text();
                var seat=$(".li").text();
                console.log($(".li").text());
                //location.href="/buyMovie?seat="+seat+"&movieName="+movieName+"&movieDate="+movieDate+"&movieRoom="+movieRoom+"&moviePrice="+moviePrice+"&yingchengid="+movieYingchengid+"";
                location.href="/zhifuyemian?seat="+seat+"&movieName="+movieName+"&movieDate="+movieDate+"&movieRoom="+movieRoom+"&moviePrice="+moviePrice+"&yingchengid="+movieYingchengid+"";
            }
        })
    });

    function getTotalPrice(sc) { //计算票价总额
        var total = 0;
        sc.find('selected').each(function() {
            total += price;
        });
        return total;
    }


</script>
</body>
</html>
