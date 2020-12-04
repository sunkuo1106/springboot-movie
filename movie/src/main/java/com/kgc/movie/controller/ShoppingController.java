package com.kgc.movie.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.kgc.movie.pojo.*;
import com.kgc.movie.service.*;
import com.kgc.movie.tools.AliPayConfig;
import com.kgc.movie.tools.AliPayConfig_shopping_order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sunkuo
 * @create 2020-11-30 10:50
 */
@Controller
public class ShoppingController {

    @Resource
    CommodityTableService commodityTableService;

    @Resource
    GoodsService goodsService;

    @Resource
    HarvestAddressService harvestAddressService;

    @Resource
    OrderIdService orderIdService;

    @Resource
    MallOrderService mallOrderService;

    @Resource
    CommodityStockService commodityStockService;

    @RequestMapping("/toShopping")
    public String toShopping(Model model, HttpServletRequest request){
        return "shopping";
    }

    @RequestMapping("/toShopping_cart")
    public String toShopping_cart(Model model, HttpServletRequest request,HttpSession session){
        //获取session中users对象得到id
        User user=(User) session.getAttribute("users");
        if(user!=null){
            //根据id查询用户收货地址
            List<HarvestAddress> harvestAddresses = harvestAddressService.selectAllAddress(user.getId());
            model.addAttribute("harvestAddresses",harvestAddresses);
        }
        return "shopping_cart";
    }

    @RequestMapping("/toShopping_cart_userName")
    @ResponseBody
    public Map<String,List<Goods>> toTest1(Model model, HttpServletRequest request,HttpSession session){
        Map<String,List<Goods>> map=new HashMap<>();
        //获取session中users对象得到id
        User user=(User) session.getAttribute("users");
        if(user!=null) {
            List<Goods> goods = goodsService.selectAllGoods(user.getUname());
            map.put("data", goods);
        }
        return map;
    }

    //添加购物车
    @RequestMapping("/doAddShoppingCart")
    @ResponseBody
    public Map<String,Object> doAddShoppingCart(Integer id, HttpSession session){
        //获取session中users对象得到id
        User user=(User) session.getAttribute("users");
        Map<String,Object>map=new HashMap<>();
        System.out.println("商品id为"+id);
        //根据商品id查询出该商品
        CommodityTable commodityTable = commodityTableService.selectByCommodity(id);
        //添加购物车页面前判断是否存在  如果存在走修改方法
        boolean flag = goodsService.selectById(user.getUname(), commodityTable.getCommodityName());
        if(flag){
            int i=goodsService.updateGoodsNums(user.getUname(), commodityTable.getCommodityName());
            if(i==0){//如果i==0 证明数量已经到了10无法继续添加购物车
                map.put("flag",true);
            }
        }else{
            Goods goods=new Goods();
            goods.setUserName(user.getUname());
            goods.setGoodsName(commodityTable.getCommodityName());
            goods.setGoodsNums(1);
            goods.setGoodsPicture(commodityTable.getCommodityPicture());
            goods.setGoodsPrice(commodityTable.getCommodityPrice());
            goodsService.AddGoods(goods);
        }
        return map;
    }

    //购物车减商品
    @RequestMapping("/doGoodsNumsJian")
    @ResponseBody
    public Map<String,Object> doGoodsNumsJian(HttpSession session,Integer GoodsId){
        Map<String,Object>map=new HashMap<>();
        //获取session中users对象得到id
        User user=(User) session.getAttribute("users");
        goodsService.jianGoodsNums(user.getUname(),GoodsId);
        return map;
    }

    //购物车加商品
    @RequestMapping("/doGoodsNumsJia")
    @ResponseBody
    public Map<String,Object> doGoodsNumsJia(HttpSession session,Integer GoodsId){
        Map<String,Object>map=new HashMap<>();
        //获取session中users对象得到id
        User user=(User) session.getAttribute("users");
        goodsService.jiaGoodsNums(user.getUname(),GoodsId);
        return map;
    }

    //购物车手动输入商品数量
    @RequestMapping("/doGoodsNumsShuRu")
    @ResponseBody
    public Map<String,Object> doGoodsNumsShuRu(HttpSession session,Integer GoodsId,Integer GoodsNums){
        Map<String,Object>map=new HashMap<>();
        //获取session中users对象得到id
        User user=(User) session.getAttribute("users");
        goodsService.ShuRuGoodsNums(user.getUname(),GoodsId,GoodsNums);
        return map;
    }

    //单删购物车
    @RequestMapping("/doDanShanGoods")
    @ResponseBody
    public Map<String,Object> doDanShanGoods(Integer id,HttpSession session){
        Map<String,Object>map=new HashMap<>();
        goodsService.deleteDanShan(id);
        return map;
    }
    @GetMapping("/pay/aliPay/Goods/{orderId}/{amount}/{product}/{body}")
    @ResponseBody
    public String aliPayGoods(@PathVariable String orderId,
                         @PathVariable String amount,
                         @PathVariable String product,
                         @PathVariable String body) throws AlipayApiException {

//获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AliPayConfig_shopping_order.gatewayUrl,
                AliPayConfig_shopping_order.app_id,
                AliPayConfig_shopping_order.merchant_private_key,
                "json",
                AliPayConfig_shopping_order.charset,
                AliPayConfig_shopping_order.alipay_public_key,
                AliPayConfig_shopping_order.sign_type);
//        page
        AlipayTradePagePayRequest alipayPageRequest = new AlipayTradePagePayRequest();
        alipayPageRequest.setReturnUrl(AliPayConfig_shopping_order.return_url);
        alipayPageRequest.setNotifyUrl(AliPayConfig_shopping_order.notify_url);


        //拼接参数
        alipayPageRequest.setBizContent("{\"out_trade_no\":\"" + orderId + "\","
                + "\"total_amount\":\"" + amount + "\","
                + "\"subject\":\"" + product + "\","
                + "\"body\":\"" + body + "\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        //请求
        return alipayClient.pageExecute(alipayPageRequest).getBody();
    }

    //跳转支付宝
    @RequestMapping("/shopping_order")
    public String shopping_order(HttpSession session,String price,String ids,Integer addId,String nums) throws UnsupportedEncodingException {
        List<OrderId> orderIds = orderIdService.orderList();
        Integer id = orderIds.get(orderIds.size() - 1).getId();
        OrderId orderId=new OrderId();
        orderId.setId(id+1);
        orderIdService.addOrderId(orderId);
        String product="周边商城";
        String name="玩具";
        String[] split = ids.split(",");
        String[] split1 = nums.split(",");
        session.setAttribute("GoodsIds",split);
        session.setAttribute("addId",addId);
        session.setAttribute("stockNum",split1);
        return "redirect:/pay/aliPay/Goods/"+id+"/"+Float.parseFloat(price)+"/"+ URLEncoder.encode(product,"UTF-8")+"/"+URLEncoder.encode(name,"UTF-8");
    }

    //支付完成进行添加商城订单操作并且减少相应的库存
    @RequestMapping("/doGoodsOrder")
    public String doGoodsOrder(HttpSession session){
        //获取ids数组
        String[] goodsIds = (String[]) session.getAttribute("GoodsIds");
        //得到收获地址id
        Integer addId = (Integer) session.getAttribute("addId");
        //获取session中users对象得到id
        User user=(User) session.getAttribute("users");
        //修改购物车表GoodsType值为1
        goodsService.XunHuanUpdateGoodsType(goodsIds);
        //将信息存入商品订单表
        mallOrderService.addMallOrder(goodsIds,addId,user.getUname());
        //减少相应的库存
        String[] stockNum = (String[]) session.getAttribute("stockNum");
        commodityTableService.selectIdByPictureAndJianStockNums(goodsIds,stockNum);
        return "redirect:/toShopping_cart";
    }
    @RequestMapping("/stockNum")
    @ResponseBody
    public  Map<String,Object> stockNum(Integer commodityid,HttpSession session){
        Map<String,Object> map=new HashMap<>();
        List<CommodityStock> commodityStocks = commodityStockService.stockNums(commodityid);
        Integer nums=commodityStocks.get(commodityStocks.size()-1).getStockNums();//当前库存
        map.put("nums",nums);
        return map;
    }
}
