package com.kgc.movie.controller;

import com.kgc.movie.pojo.HarvestAddress;
import com.kgc.movie.pojo.MovieTicket;
import com.kgc.movie.pojo.User;
import com.kgc.movie.service.HarvestAddressService;
import com.kgc.movie.service.UserOderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class PersonalController {
    @Resource
    UserOderService userOderService;

    @Resource
    HarvestAddressService harvestAddressService;

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
        return "Shipping_address_layui";
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
        return "Shipping_address_layui";
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
        return "Shipping_address_layui";
    }

    //跳转个人中心页面
    @RequestMapping("/toPersonalCenter")
    public String toPersonalCenter(Model model,HttpSession session){
        return "Personal_center_layui";
    }

    @RequestMapping("/toTest")
    public String toTest(Model model,HttpSession session){
        return "user_member_layui";
    }


}
