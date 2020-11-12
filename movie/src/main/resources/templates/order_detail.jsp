<%--
  Created by IntelliJ IDEA.
  User: LHX
  Date: 2020/10/15
  Time: 9:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>订单详情</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="/static/style/adminStyle.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="wrap">
    <div class="page-title">
        <span class="modular fl"><i class="order"></i><em>订单编号：2015041803225</em></span>
    </div>
    <dl class="orderDetail">
        <dt class="order-h">订单详情</dt>
        <dd>
            <ul>
                <li>
                    <span class="h-cont h-right">收件人姓名：</span>
                    <span class="h-cont h-left">张三</span>
                </li>
                <li>
                    <span class="h-cont h-right">联系电话：</span>
                    <span class="h-cont h-left">15825518194</span>
                </li>
                <li>
                    <span class="h-cont h-right">联系地址：</span>
                    <span class="h-cont h-left">陕西省西安市未央区220号</span>
                </li>
                <li>
                    <span class="h-cont h-right">付款状态：</span>
                    <span class="h-cont h-left">未付款</span>
                </li>
                <li>
                    <span class="h-cont h-right">下单时间：</span>
                    <span class="h-cont h-left">2015-04-18 13:25</span>
                </li>
                <li>
                    <span class="h-cont h-right">付款时间：</span>
                    <span class="h-cont h-left">2015-04-18 13:35</span>
                </li>
            </ul>
        </dd>
        <dd style="padding:1em 0;">
            <span><b>订单留言：</b></span>
            <span>...这里是用户留言信息，务必***请到****谢谢~</span>
        </dd>
        <dd>
            <table class="list-style">
                <tr>
                    <th>缩略图</th>
                    <th>产品</th>
                    <th>单价</th>
                    <th>数量</th>
                    <th>小计</th>
                </tr>
                <tr>
                    <td><img src="#" class="thumbnail"/></td>
                    <td>这里是产品名称哦</td>
                    <td>
       <span>
        <i>￥</i>
        <em>0.00</em>
       </span>
                    </td>
                    <td>1</td>
                    <td>
       <span>
        <i>￥</i>
        <em>0.00</em>
       </span>
                    </td>
                </tr>
                <tr>
                    <td colspan="5">
                        <div class="fr">
        <span style="font-size:15px;font-weight:bold;">
         <i>订单共计金额：￥</i>
         <b>0.00</b>
        </span>
                        </div>
                    </td>
                </tr>
            </table>
        </dd>
        <dd>
            <table class="noborder">
                <tr>
                    <td width="10%" style="text-align:right;"><b>管理员操作：</b></td>
                    <td>
                        <textarea class="block" style="width:80%;height:35px;outline:none;"></textarea>
                    </td>
                </tr>
            </table>
        </dd>
        <dd>
            <!-- Operation -->
            <div class="BatchOperation">
                <input type="button" value="打印订单" class="btnStyle"/>
                <input type="button" value="配送" class="btnStyle"/>
                <input type="button" value="发货" class="btnStyle"/>
                <input type="button" value="取消订单" class="btnStyle"/>
            </div>
        </dd>
    </dl>
</div>
</body>
</html>
