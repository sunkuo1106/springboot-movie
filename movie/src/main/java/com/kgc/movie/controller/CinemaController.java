package com.kgc.movie.controller;

import com.kgc.movie.tools.JuheDemo;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class CinemaController {

    @RequestMapping("/selectCityCinema")
    @ResponseBody
    public Map<String,Object> selectCityCinema(Integer cityId){
        Map<String,Object> map=new HashMap<>();
        Object request3 = JuheDemo.getRequest3(cityId);
        map.put("CinemaList",request3);
        return map;
    }
    @RequestMapping("/selectByCinema")
    @ResponseBody
    public Map<String,Object>selectByCinema(int cinemaId,String yingchengName, HttpSession session){
        Map<String,Object>map=new HashMap<>();
        session.setAttribute("cinemaId",cinemaId);
        session.setAttribute("yingchengName",yingchengName);
        map.put("status","true");
        return map;
    }
    @RequestMapping("/selectCinema")
    @ResponseBody
    public Map<String,Object>selectCinema(HttpSession session){
        Map<String,Object>map=new HashMap<>();
        int cinemaId=(int)session.getAttribute("cinemaId");
        Object request4 = JuheDemo.getRequest4(cinemaId);
        map.put("o",request4);
        return map;
    }
    @RequestMapping("/selectCinemaByMovie")
    @ResponseBody
    public Map<String,Object> selectCinemaByMovie(int movieId){
        Map<String,Object>map=new HashMap<>();
        Object request8 = JuheDemo.getRequest8(movieId);
        request8 =request8.toString().replaceAll("null","123");
        JSONObject object = JSONObject.fromObject(request8);
        //System.out.println(request8);
        map.put("o",object);
        System.out.println(map.get("o"));
        return map;
    }
    @RequestMapping("/toPreviewycCinema")
    public String toPreviewycCinema(Integer cinemaId, Integer movieId, Model model){
        model.addAttribute("cinemaId",cinemaId);
        model.addAttribute("movieId",movieId);
        System.out.println(movieId);
        Object request8 = JuheDemo.getRequest8(movieId);
        request8 =request8.toString().replaceAll("null","123");
        JSONObject object = JSONObject.fromObject(request8);
        System.out.println(object);
        model.addAttribute("info",object);
        return "preview_cinema";
    }
    @RequestMapping("/previewycCinema")
    @ResponseBody
    public Map<String,Object>previewycCinema(int cinemaId,int movieId){
        Map<String,Object>map=new HashMap<>();
        Object request4 = JuheDemo.getRequest4(cinemaId,movieId);
        map.put("cc",request4);
        map.put("status","true");
        return map;
    }
    @RequestMapping("/baidu")
    public String baidu(){
        return "baidu_index";
    }
    @RequestMapping("/baidu_Chuan")
    public String baidu_Chuan(String lat, String lng, Model model){
        model.addAttribute("lat",lat);
        model.addAttribute("lng",lng);
        System.out.println(lat+","+lng);
        return "index_cinema2";
    }
    @RequestMapping("/baiduCha")
    @ResponseBody
    public Map<String,Object>baiducha(String lng,String lat){
        Map<String,Object>map=new HashMap<>();
        Object request2 = JuheDemo.getRequest2(lat, lng);
        map.put("cc",request2);
        map.put("status","true");
        return map;
    }

    @RequestMapping("/toindex_cinema")
    public String toindex_cinema(){
        return "index_cinema";
    }
    @RequestMapping("/toCinema")
    public String toCinema(){
        return "Cinema";
    }
}
