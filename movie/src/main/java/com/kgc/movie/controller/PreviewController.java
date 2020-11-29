package com.kgc.movie.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.kgc.movie.pojo.CommodityFront;
import com.kgc.movie.pojo.MovieTicket;
import com.kgc.movie.pojo.User;
import com.kgc.movie.pojo.UserMember;
import com.kgc.movie.service.MovieTicketService;
import com.kgc.movie.service.UserMemberService;
import com.kgc.movie.tools.AliPayConfig;
import com.kgc.movie.tools.JuheDemo;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import org.json.JSONException;
import org.json.JSONObject;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
public class PreviewController {

    @Resource
    MovieTicketService movieTicketService;
    @Resource
    UserMemberService userMemberService;

    String movieId;
    String cityId;

    //按影片ID检索影片信息
    @RequestMapping("/preview/{movieId}/{city}")
    public String selectByMovieId(@PathVariable("movieId") String movieId, @PathVariable("city") String cityId,HttpSession session){
        this.movieId=movieId;
        this.cityId=cityId;
        System.out.println("影片id为:"+movieId);
        Object request8 = JuheDemo.getRequest8(Integer.parseInt(movieId));
        System.out.println(request8);
        request8 =request8.toString().replaceAll("\\null","");
        net.sf.json.JSONObject object = net.sf.json.JSONObject.fromObject(request8);
        session.setAttribute("info",object);
        return "preview";
    }

    //影片上映影院查询
    @RequestMapping("/previewyc")
    @ResponseBody
    public Map<String,Object> selectYC(){
        Map<String,Object> map=new HashMap<>();
        //影城
        Object request7 = JuheDemo.getRequest7(Integer.parseInt(movieId), Integer.parseInt(cityId));
        map.put("yc",request7);
        return map;
    }

    //影院上映影片信息
    @RequestMapping("/previewcc")
    @ResponseBody
    public Map<String,Object> selectCC(String cinemaId){
        Map<String,Object>map=new HashMap<>();
        System.out.println(cinemaId);
        System.out.println(movieId);
        Object request4 = JuheDemo.getRequest4(Integer.parseInt(cinemaId), Integer.parseInt(movieId));
        System.out.println(request4);
        map.put("cc",request4);
        return map;
    }

    //选座购票
    @RequestMapping("/buyTicket")
    public String buyTicket(Model model, HttpSession session, String movieName, String movieDate, String movieRoom, String moviePrice, Integer yingchengid, String yingchengName){
        User user=(User) session.getAttribute("users");
        List<UserMember> userMembers = userMemberService.userMemberName(user.getUname());
        String type = userMembers.get(userMembers.size() - 1).getType();
        session.setAttribute("memberType",type);
        //第一步把电影信息存入数据库
        session.setAttribute("yingchengName",yingchengName);
        session.setAttribute("movieRoom",movieRoom);
        session.setAttribute("movieDate",movieDate);
        System.out.println(movieName);System.out.println(movieDate);System.out.println(movieRoom);System.out.println(moviePrice);System.out.println(yingchengid);
        SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd ");
        String time = formatter.format(new Date());//格式化数据bai
        movieDate+=":00";
        time+=movieDate;
        System.out.println(time);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = time;
        Date date=new Date();
        try {
            date = simpleDateFormat.parse(dateStr);
            System.out.println(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        MovieTicket movieTicket=new MovieTicket();
        movieTicket.setMovieName(movieName);
        movieTicket.setMovieDate(date);
        movieTicket.setMovieRoom(movieRoom);
        movieTicket.setMovieYingchengid(yingchengid);
        movieTicket.setMoviePrice(Float.parseFloat(moviePrice));
        //将购票信息存在session
        session.setAttribute("movieTicket",movieTicket);
        //把放映厅传送到页面
        model.addAttribute("movieRoom",movieRoom);
        if(movieRoom.equals("7号厅")){
            model.addAttribute("ting",7);
        }else if(movieRoom.equals("1号厅")){
            model.addAttribute("ting",1);
        }else if(movieRoom.equals("2号厅")){
            model.addAttribute("ting",2);
        }else if(movieRoom.equals("3号厅")){
            model.addAttribute("ting",3);
        }else if(movieRoom.equals("4号厅")){
            model.addAttribute("ting",4);
        }else if(movieRoom.equals("5号厅")){
            model.addAttribute("ting",5);
        }else if(movieRoom.equals("6号厅")){
            model.addAttribute("ting",6);
        }else{
            model.addAttribute("ting",0);
        }
        //把价格传到页面
        model.addAttribute("price",moviePrice);
        //把电影名称传到页面
        model.addAttribute("movieName",movieName);
        //把电影时间传到页面
        model.addAttribute("time",time);
        //产生随机数添加出售座位(根据场地区分)
        return "seatballot";
    }

    @RequestMapping("/buyMovie")//ajax
    @ResponseBody
    public Map<String,Object> buyMovie(HttpSession sessione){
        Map<String,Object>map=new HashMap<>();
        MovieTicket movieTicket = (MovieTicket) sessione.getAttribute("movieTicket");
        movieTicketService.addMovieTicket(movieTicket);
        return map;
    }

    private String testStatus(){
        Client client = Client.create();
        client.addFilter(new HTTPBasicAuthFilter(
                "api","e6a1137fb5ab17e9493e31e26ec520d8"));
        WebResource webResource = client.resource( "http://sms-api.luosimao.com/v1/status.json" );
        MultivaluedMapImpl formData = new MultivaluedMapImpl();
        ClientResponse response =  webResource.get( ClientResponse.class );
        String textEntity = response.getEntity(String.class);
        int status = response.getStatus();
        //System.out.print(status);
        //System.out.print(textEntity);
        return textEntity;
    }
    @RequestMapping("/doPhone2")
    @ResponseBody
    public Map<String,Object> doPhone2(HttpSession session, String phone){
        Map<String,Object> map=new HashMap<>();
        // just replace key here
        String yingchengName=(String) session.getAttribute("yingchengName");
        String seat=(String) session.getAttribute("seat");
          Integer suiJi=(Integer) session.getAttribute("suiJi2");
        String suiJi2=String.valueOf(suiJi);
        String movieDate=(String) session.getAttribute("movieDate");
        String[] str=seat.split("座");
        String newSeat="";
        for (String s : str) {
            newSeat+=s+"座、";
        }
        newSeat.replaceAll("、$",",");
        String movieRoom=(String) session.getAttribute("movieRoom");
        String movieName=(String) session.getAttribute("movieName");
        System.out.println(phone+","+yingchengName+","+movieName+","+newSeat+","+movieRoom+","+movieDate);
        SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd ");
        String time = formatter.format(new Date());
        Client client = Client.create();
        client.addFilter(new HTTPBasicAuthFilter(
                "api","e6a1137fb5ab17e9493e31e26ec520d8"));
        WebResource webResource = client.resource(
                "http://sms-api.luosimao.com/v1/send.json");
        MultivaluedMapImpl formData = new MultivaluedMapImpl();
        formData.add("mobile", phone);
        formData.add("message", "您于"+time+"在星空APP购买了"+yingchengName+movieRoom+"的《"+movieName+"》电影的"+str.length+"张电影票，座位是"+newSeat+"电影开始时间为今天"+movieDate+",电影开始前15分钟开始检票进场，" +
                "进场时凭"+suiJi2+"此码检票进场，请勿随意告诉他人，电影开始30分钟后禁止入内,请提前到场等候【铁壳测试】");
        ClientResponse response =  webResource.type( javax.ws.rs.core.MediaType.APPLICATION_FORM_URLENCODED ).
                post(ClientResponse.class, formData);
        String textEntity = response.getEntity(String.class);
        int status = response.getStatus();
        PreviewController api = new PreviewController();
        String httpResponse =  textEntity;
        try {
            JSONObject jsonObj = new JSONObject( httpResponse );
            int error_code = jsonObj.getInt("error");
            String error_msg = jsonObj.getString("msg");
            if(error_code==0){
                System.out.println("Send message success.");
            }else{
                System.out.println("Send message failed,code is "+error_code+",msg is "+error_msg);
            }
        } catch (JSONException ex) {
            Logger.getLogger(PreviewController.class.getName()).log(Level.SEVERE, null, ex);
        }

        httpResponse =  api.testStatus();
        try {
            JSONObject jsonObj = new JSONObject( httpResponse );
            int error_code = jsonObj.getInt("error");
            if( error_code == 0 ){
                int deposit = jsonObj.getInt("deposit");
                System.out.println("Fetch deposit success :"+deposit);
            }else{
                String error_msg = jsonObj.getString("msg");
                System.out.println("Fetch deposit failed,code is "+error_code+",msg is "+error_msg);
            }
        } catch (JSONException ex) {
            Logger.getLogger(PreviewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return map;
    }

    @GetMapping("/pay/aliPay/{orderId}/{amount}/{product}/{body}")
    @ResponseBody
    public String aliPay(@PathVariable String orderId,
                         @PathVariable String amount,
                         @PathVariable String product,
                         @PathVariable String body) throws AlipayApiException {

//获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AliPayConfig.gatewayUrl,
                AliPayConfig.app_id,
                AliPayConfig.merchant_private_key,
                "json",
                AliPayConfig.charset,
                AliPayConfig.alipay_public_key,
                AliPayConfig.sign_type);
//        page
        AlipayTradePagePayRequest alipayPageRequest = new AlipayTradePagePayRequest();
        alipayPageRequest.setReturnUrl(AliPayConfig.return_url);
        alipayPageRequest.setNotifyUrl(AliPayConfig.notify_url);


        //拼接参数
        alipayPageRequest.setBizContent("{\"out_trade_no\":\"" + orderId + "\","
                + "\"total_amount\":\"" + amount + "\","
                + "\"subject\":\"" + product + "\","
                + "\"body\":\"" + body + "\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        //请求
        return alipayClient.pageExecute(alipayPageRequest).getBody();
    }

    @RequestMapping("/zhifuyemian")
    public String zhifuyemian(HttpSession session,Float totalMoney, String seat, String movieName, Date movieDate, String movieRoom, String moviePrice, Integer yingchengid,String commodityName) throws UnsupportedEncodingException {
        User user=(User) session.getAttribute("users");

        Integer suiJi = (int) ((Math.random() * 9 + 1) * 100000);
        session.setAttribute("suiJi2",suiJi);
        session.setAttribute("seat",seat);
        session.setAttribute("movieName",movieName);
        int i = movieTicketService.movieById();
        System.out.println("265==========================="+i);
        //截取座位
        String searStr = seat.replaceAll("\\排", "_").replaceAll("\\座", ",");
        MovieTicket movieTicket=new MovieTicket();
        CommodityFront commodityFront=new CommodityFront();
        movieTicket.setMovieName(movieName);
        movieTicket.setMovieDate(movieDate);
        movieTicket.setMovieRoom(movieRoom);
        if(totalMoney!=0&&totalMoney.equals("0")==false){
            movieTicket.setMovieWhether("有");
            commodityFront.setEnterId(suiJi);
            commodityFront.setCommodityName(commodityName);
            commodityFront.setCommodityDate(new Date());
            commodityFront.setCommodityTotalprice(totalMoney);
            commodityFront.setUserName(user.getUname());
        }else{
            movieTicket.setMovieWhether("无");
        }
        movieTicket.setEnterId(suiJi);
        movieTicket.setMovieYingchengid(yingchengid);
        movieTicket.setMoviePrice(Float.parseFloat(moviePrice));
        movieTicket.setUserName(user.getUname());
        movieTicket.setMovieSeat(searStr);
        session.setAttribute("commodityFront",commodityFront);
        session.setAttribute("movieTicket",movieTicket);
        //跳转支付宝
        session.setAttribute("money",moviePrice);
        session.setAttribute("movieName",movieName);
        String product="电影票";


        return "redirect:/pay/aliPay/"+i+"/"+Float.parseFloat(moviePrice)+"/"+ URLEncoder.encode(product,"UTF-8")+"/"+URLEncoder.encode(movieName,"UTF-8");
    }

    @RequestMapping("/selectSeat")
    @ResponseBody
    public Map<String,Object> index(String yingpianname,Integer yingyuanid,Date datetime){
        Map<String,Object> map=new HashMap<>();
        List<MovieTicket> ceShis = movieTicketService.ceshiList(yingpianname,yingyuanid,datetime);
        System.out.println(ceShis.size());
        String[] list={};
        List<String> sList=new ArrayList<String>();
        if(ceShis.size()>0){
            map.put("status","true");
            for (MovieTicket ceShi : ceShis) {
                if(ceShi.getMovieSeat().contains(",")){
                    list=ceShi.getMovieSeat().split(",");
                    for (int i = 0; i < list.length; i++) {
                        String[] list2={list[i]};
                        for (String s : list2) {
                            sList.add(s);
                        }
                    }
                }else{
                    sList.add(ceShi.getMovieSeat());
                }
            }
            for (String s : sList) {
                System.out.println(s);
            }
            map.put("jie",sList);
            return map;
        }else{
            map.put("status","false");
        }
        return map;
    }

    @RequestMapping("/xiaLa")
    @ResponseBody
    public Map<String,Object> xiaLa(String cityIdStr){
        Map<String,Object> map=new HashMap<>();
        int cityId=Integer.parseInt(cityIdStr);
        Object o= JuheDemo.getRequest5(cityId);
        map.put("a",o);
        return map;
    }



}
