package com.kgc.movie.controller;

import com.kgc.movie.pojo.MovieTicket;
import com.kgc.movie.pojo.User;
import com.kgc.movie.service.UserOderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserOderController {
    @Resource
    UserOderService userOderService;
    @RequestMapping("/userOderSelect")
    @ResponseBody
    public Map<String,Object>userOderSelect(HttpSession session){
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
}
