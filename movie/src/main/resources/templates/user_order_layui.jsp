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
    <title>星空影城个人订单</title>
    <link rel="shortcut icon" href="/static/images/logo.png" />
    <link rel="stylesheet" type="text/css" href="/static/css/jq22.css" />
    <link href="/static/css/style.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" href="/static/layui/css/layui.css" media="all">
</head>
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
    <h2 class="title"><a href="" style="color:#007BC4;">星空影城查看个人订单</a></h2>
    <div class="demo clearfix">
        <table id="demo" style="margin-left: 100px;margin-top: -40px;" lay-filter="test"></table>
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

<script src="/static/layui/layui.js"></script>
<script>
    layui.use('table', function(){
        var table = layui.table;

        //第一个实例
        table.render({
            elem: '#demo'
            ,width: 980
            ,url: '/userOderSelect' //数据接口
            ,id: 'listReload'
            ,page: true //开启分页
            , parseData: function (res) { //将原始数据解析成 table 组件所规定的数据，res为从url中get到的数据
                var result;
                console.log(this);
                console.log(JSON.stringify(res));
                if (this.page.curr) {
                    result = res.data.slice(this.limit * (this.page.curr - 1), this.limit * this.page.curr);
                }
                else {
                    result = res.data.slice(0, this.limit);
                }
                return {
                    "code": res.code, //解析接口状态
                    "msg": res.msg, //解析提示文本
                    "count": res.count, //解析数据长度
                    "data": result //解析数据列表
                };
            }
            ,cols: [[ //表头
                {field: 'movieId', title: 'ID',  sort: true, fixed: 'left'}
                ,{field: 'movieName', title: '电影名称'}
                ,{field: 'movieRoom', title: '放映厅'}
                ,{field: 'movieDate', title: '电影放映日期',  sort: true}
                ,{field: 'moviePrice', title: '价格', sort: true}
                ,{field: 'movieSeat', title: '座位'}
            ]]
        });

    });
</script>
</body>
</html>
