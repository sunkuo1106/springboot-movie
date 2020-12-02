package com.kgc.movie.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.kgc.movie.pojo.*;
import com.kgc.movie.service.*;
import com.kgc.movie.tools.AliPayConfig_member;
import com.kgc.movie.tools.AliPayConfig_renew_member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;

@Controller
public class PersonalController {
    @Resource
    UserOderService userOderService;

    @Resource
    HarvestAddressService harvestAddressService;

    @Resource
    UserLoginService userLoginService;

    @Resource
    PersonalCenterService personalCenterService;

    @Resource
    UserMemberService userMemberService;

    @Resource
    MallOrderService mallOrderService;

    //跳转个人电影订单页面
    @RequestMapping("/touserOderSelect")
    public String touserOderSelect(){
        return "user_order_layui";
    }
    //查询电影订单
    @RequestMapping("/userOderSelect")
    @ResponseBody
    public Map<String,Object> userOderSelect(HttpSession session){
        Map<String,Object> map=new HashMap<>();
        //当前页
        Integer page = 1;
        //每页的数量
        Integer size = 10;
        User user=(User)session.getAttribute("users");
        List<MovieTicket> movieTickets = userOderService.selectAllOrder(user.getUname());
        for (MovieTicket movieTicket : movieTickets) {
            String A=movieTicket.getMovieSeat().replaceAll("\\_","排").replaceAll("\\,","座,").replaceAll("^,|,$","");
            movieTicket.setMovieSeat(A);
        }
        map.put("start", (page - 1) * size);  //当前页的数量
        map.put("data",movieTickets);
        map.put("code",0);
        map.put("count",movieTickets.size());
        return map;
    }

    //跳转收获地址页面
    @RequestMapping("/toShippingAddress")
    public String toShippingAddress(Model model,HttpSession session){
        //获取session中users对象得到id
        User user=(User) session.getAttribute("users");
        //根据id查询用户收货地址
        List<HarvestAddress> harvestAddresses = harvestAddressService.selectAllAddress(user.getId());
        model.addAttribute("harvestAddresses",harvestAddresses);
        return "Shopping_address_layui";
    }
    //添加收获地址
    @RequestMapping("/doShippingAddress")
    public String doShippingAddress(Model model,HttpSession session,HarvestAddress harvestAddress,String map){
        System.out.println("新增收获地址为:"+map);
        //获取session中users对象得到id
        User user=(User) session.getAttribute("users");
        //添加地址
        harvestAddress.setUserId(user.getId());
        harvestAddress.setAddAddress(map);
        if(harvestAddress.getAddPostcode()==""){
            harvestAddress.setAddPostcode(null);
        }
        System.out.println(harvestAddress.toString());
        harvestAddressService.addAddress(harvestAddress);
        //并且返回页面再次查询
        List<HarvestAddress> harvestAddresses = harvestAddressService.selectAllAddress(user.getId());
        model.addAttribute("harvestAddresses",harvestAddresses);
        return "Shopping_address_layui";
    }
    //删除收获地址
    @RequestMapping("/delShippingAddress")
    public String delShippingAddress(Model model,HttpSession session,Integer addId){
        //获取session中users对象得到id
        User user=(User) session.getAttribute("users");
        //根据地址id删除
        harvestAddressService.delShippingAddress(addId);
        System.out.println("删除的id为:"+addId);
        //并且返回页面再次查询
        List<HarvestAddress> harvestAddresses = harvestAddressService.selectAllAddress(user.getId());
        model.addAttribute("harvestAddresses",harvestAddresses);
        return "Shopping_address_layui";
    }

    //跳转个人中心页面
    @RequestMapping("/toPersonalCenter")
    public String toPersonalCenter(Model model,HttpSession session){
        //获取session中users对象得到id
        User user=(User) session.getAttribute("users");
        //查询个人信息
        User user1 = userLoginService.selectById(user.getId());
        model.addAttribute("user",user1);
        //查询出该用户观影场次
        List<MovieTicket> movieTicketSize = personalCenterService.selectAllTicket(user.getUname());
        model.addAttribute("movieTicketSize",movieTicketSize.size());
        //查询出所发表的评论次数
        List<MovieComment> movieCommentSize = personalCenterService.selectAllComment(user.getUname());
        model.addAttribute("movieCommentSize",movieCommentSize.size());
        //查询总消费金额   (电影票价格+食品价格+商城价格+会员充值价格)
        List<MovieTicket> TicketMoneys = personalCenterService.selectTicketMoneyByUserName(user.getUname());  //电影票价格
        List<CommodityFront> FrontMoneys = personalCenterService.selectCommodityFrontMoneyByUserName(user.getUname()); //食品价格
        //商城价格  待完成
        //将四张表的消费金额相加
        double allMoneys=0;
        int count = 0;
        int index = 0;
        String key=",";
        for (int i = 0; i <TicketMoneys.size() ; i++) {
            String movieSeats = TicketMoneys.get(i).getMovieSeat();
            while ((index = movieSeats.indexOf(key, index)) != -1) {
                index = index + key.length();
                count++;
            }
            //System.out.println(count+"张电影票");
            allMoneys+=TicketMoneys.get(i).getMoviePrice();
        }
        System.out.println("加上电影票价格后总消费为:"+allMoneys);
        //计算总金额--食品价格
        for (int i = 0; i <FrontMoneys.size(); i++) {
            allMoneys+=FrontMoneys.get(i).getCommodityTotalprice();
        }
        System.out.println("再加上食品价格后总消费为:"+allMoneys);
        //查询会员等级  没有就是普通会员
        List<UserMember> userMembers = personalCenterService.selectMemberByUserName(user.getUname());  //会员充值价格
        if(userMembers!=null&&userMembers.size()!=0){
            model.addAttribute("memberType",userMembers.get(userMembers.size()-1).getType());
            //如果是会员查询该会员的到期时间
            Date endTime = personalCenterService.selectByUserMemberEndTime(user.getUname());
            model.addAttribute("endTime",endTime);
            //计算总金额--会员充值价格
            for (int i = 0; i <userMembers.size(); i++) {
                allMoneys+=userMembers.get(i).getMemberMoney();
            }
            System.out.println("再加上会员充值价格后总消费为:"+allMoneys);
        }else{
            model.addAttribute("memberType","普通会员");
        }
        model.addAttribute("allMoneys",allMoneys);
        return "Personal_center_layui";
    }

    //跳转充值会员页面   如果是会员那么就要改为续费
    @RequestMapping("/toUserMember")
    public String toUserMember(Model model,HttpSession session){
        //获取session中users对象得到id
        User user=(User) session.getAttribute("users");
        //查询会员等级  没有就是普通会员
        List<UserMember> userMembers = personalCenterService.selectMemberByUserName(user.getUname());
        if(userMembers!=null&&userMembers.size()!=0){
            model.addAttribute("memberType",userMembers.get(userMembers.size()-1).getType());
            //如果是会员查询该会员的到期时间
            Date endTime = personalCenterService.selectByUserMemberEndTime(user.getUname());
            model.addAttribute("endTime",endTime);
        }else{
            model.addAttribute("memberType","普通会员");
        }
        return "user_member_layui";
    }

    @GetMapping("/pay/aliPay/member/{orderId}/{amount}/{product}/{body}")
    @ResponseBody
    public String aliPay(@PathVariable String orderId,
                         @PathVariable String amount,
                         @PathVariable String product,
                         @PathVariable String body) throws AlipayApiException {

    //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AliPayConfig_member.gatewayUrl,
                AliPayConfig_member.app_id,
                AliPayConfig_member.merchant_private_key,
                "json",
                AliPayConfig_member.charset,
                AliPayConfig_member.alipay_public_key,
                AliPayConfig_member.sign_type);
//        page
        AlipayTradePagePayRequest alipayPageRequest = new AlipayTradePagePayRequest();
        alipayPageRequest.setReturnUrl(AliPayConfig_member.return_url);
        alipayPageRequest.setNotifyUrl(AliPayConfig_member.notify_url);


        //拼接参数
        alipayPageRequest.setBizContent("{\"out_trade_no\":\"" + orderId + "\","
                + "\"total_amount\":\"" + amount + "\","
                + "\"subject\":\"" + product + "\","
                + "\"body\":\"" + body + "\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        //请求
        return alipayClient.pageExecute(alipayPageRequest).getBody();
    }

    @RequestMapping("/toPayMember")
    public String toPayMember(String type,HttpSession session) throws UnsupportedEncodingException {
        System.out.println(type);
        if(type.equals("钻石会员")){
            session.setAttribute("typeMember","钻石会员");
            session.setAttribute("memberMoney",45);
        }else if(type.equals("铂金会员")){
            session.setAttribute("typeMember","铂金会员");
            session.setAttribute("memberMoney",25);
        }else if(type.equals("黄金会员")){
            session.setAttribute("typeMember","黄金会员");
            session.setAttribute("memberMoney",15);
        }
        //查询id
        List<UserMember> userMembers = userMemberService.selectAllMember();
        int id=userMembers.get(userMembers.size()-1).getMemberId()+1;
        Integer amount=(Integer) session.getAttribute("memberMoney");
        String body=(String)session.getAttribute("typeMember");
        String product="星空影城会员";
        return "redirect:/pay/aliPay/member/"+id+"/"+amount+"/"+URLEncoder.encode(product,"UTF-8")+"/"+URLEncoder.encode(body,"UTF-8")+"";
    }

    @RequestMapping("/doUserMember")
    public String doUserMember(Model model,HttpSession session){
        //获取session中users对象得到id
        User user=(User) session.getAttribute("users");
        //当前时间
        Date date = new Date();
        //添加月份
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(new Date());
        rightNow.add(Calendar.MONTH, 1);
        Date endTime = rightNow.getTime();
        //价格
        Integer amount=(Integer)session.getAttribute("memberMoney");
        //type
        String body=(String)session.getAttribute("typeMember");
        UserMember userMember=new UserMember();
        userMember.setUserName(user.getUname());
        userMember.setType(body);
        userMember.setStartingTime(date);
        userMember.setEndTime(endTime);
        userMember.setMemberMoney(Float.valueOf(amount));
        userMemberService.addMember(userMember);
        return "redirect:/toPersonalCenter";
    }

    @GetMapping("/pay/aliPay/member/renew/{orderId}/{amount}/{product}/{body}")
    @ResponseBody
    public String aliPay_member_renew(@PathVariable String orderId,
                         @PathVariable String amount,
                         @PathVariable String product,
                         @PathVariable String body) throws AlipayApiException {

        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AliPayConfig_renew_member.gatewayUrl,
                AliPayConfig_renew_member.app_id,
                AliPayConfig_renew_member.merchant_private_key,
                "json",
                AliPayConfig_renew_member.charset,
                AliPayConfig_renew_member.alipay_public_key,
                AliPayConfig_renew_member.sign_type);
//        page
        AlipayTradePagePayRequest alipayPageRequest = new AlipayTradePagePayRequest();
        alipayPageRequest.setReturnUrl(AliPayConfig_renew_member.return_url);
        alipayPageRequest.setNotifyUrl(AliPayConfig_renew_member.notify_url);


        //拼接参数
        alipayPageRequest.setBizContent("{\"out_trade_no\":\"" + orderId + "\","
                + "\"total_amount\":\"" + amount + "\","
                + "\"subject\":\"" + product + "\","
                + "\"body\":\"" + body + "\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        //请求
        return alipayClient.pageExecute(alipayPageRequest).getBody();
    }

    @RequestMapping("/toPayMemberRenew")
    public String toPayMemberRenew(String type,HttpSession session) throws UnsupportedEncodingException {
        System.out.println(type);
        if(type.equals("钻石会员")){
            session.setAttribute("typeMember","钻石会员");
            session.setAttribute("memberMoney",45);
        }else if(type.equals("铂金会员")){
            session.setAttribute("typeMember","铂金会员");
            session.setAttribute("memberMoney",25);
        }else if(type.equals("黄金会员")){
            session.setAttribute("typeMember","黄金会员");
            session.setAttribute("memberMoney",15);
        }
        //查询id
        List<UserMember> userMembers = userMemberService.selectAllMember();
        int id=100+userMembers.get(userMembers.size()-1).getMemberId()+1;
        Integer amount=(Integer) session.getAttribute("memberMoney");
        String body=(String)session.getAttribute("typeMember");
        String product="星空影城会员续费";
        return "redirect:/pay/aliPay/member/renew/"+id+"/"+amount+"/"+URLEncoder.encode(product,"UTF-8")+"/"+URLEncoder.encode(body,"UTF-8")+"";
    }

    //会员续费
    @RequestMapping("/doUserMemberRenew")
    public String doUserMemberRenew(Model model,HttpSession session){
        //获取session中users对象得到id
        User user=(User) session.getAttribute("users");
        //修改会员到期时间+消费金额
        List<UserMember> userMembers = personalCenterService.selectMemberByUserName(user.getUname());
        if(userMembers!=null&&userMembers.size()!=0){
            //得到会员到期的时间
            Date oldendTime = personalCenterService.selectByUserMemberEndTime(user.getUname());
            //得到消费金额
            float money=userMembers.get(userMembers.size()-1).getMemberMoney();
            //修改月份
            Calendar rightNow = Calendar.getInstance();
            rightNow.setTime(oldendTime);
            rightNow.add(Calendar.MONTH, 1);
            Date endTime = rightNow.getTime();
            System.out.println(endTime);
            //修改金额
            Integer amount=(Integer)session.getAttribute("memberMoney");
            UserMember userMember=userMembers.get(userMembers.size()-1);
//            System.out.println("==================");
//            System.out.println(userMember.toString());
            userMember.setEndTime(endTime);
            userMember.setMemberMoney(money+amount);
            userMemberService.updateMember(userMember);
        }else{
            System.out.println("会员续费操作失败");
        }
        return "redirect:/toPersonalCenter";
    }

    //跳转个人商城订单页面
    @RequestMapping("/toMallOrder")
    public String toMallOrder(){
        return "goods_order_layui";
    }

    //查询商城订单
    @RequestMapping("/goodsOderSelect")
    @ResponseBody
    public Map<String,Object> goodsOderSelect(HttpSession session){
        Map<String,Object> map=new HashMap<>();
        //当前页
        Integer page = 1;
        //每页的数量
        Integer size = 10;
        User user=(User)session.getAttribute("users");
        List<MallOrder>mallOrders=mallOrderService.selectAllMallOrderByUserName(user.getUname());
        map.put("start", (page - 1) * size);  //当前页的数量
        map.put("data",mallOrders);
        map.put("code",0);
        map.put("count",mallOrders.size());
        return map;
    }

    //查询单个商品的收获地址
    @RequestMapping("/addressById")
    @ResponseBody
    public Map<String,Object> addressById(Integer addId){
        Map<String,Object> map=new HashMap<>();
        HarvestAddress harvestAddress=harvestAddressService.selectById(addId);

        map.put("harvestAddress",harvestAddress);
        return map;
    }


}
