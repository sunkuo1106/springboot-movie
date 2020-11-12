package com.kgc.movie.controller;

import com.kgc.movie.pojo.MovieComment;
import com.kgc.movie.pojo.User;
import com.kgc.movie.service.MovieCommentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CommentController {
    @Resource
    MovieCommentService movieCommentService;
    @RequestMapping("/selecltAllComment")
    @ResponseBody
    public Map<String,Object>selecltAllComment(Integer movieid){
        Map<String,Object>map=new HashMap<>();
        List<MovieComment> movieComments = movieCommentService.selectAll(movieid);
        map.put("movieComments",movieComments);
        return map;
    }

    @RequestMapping("/AddComment")
    @ResponseBody
    public Map<String,Object>AddComment(MovieComment movieComment, HttpSession session){
        Map<String,Object>map=new HashMap<>();
        movieComment.setData(new Date());
        User user=(User) session.getAttribute("users");
        movieComment.setUsername(user.getUname());
        movieCommentService.add(movieComment);
        return map;
    }

    @RequestMapping("/comment_index")
    public String comment_index(Integer movieid, Model model){
        model.addAttribute("movieid",movieid);
        System.out.println("电影id"+movieid);
        return "comment_index";
    }

    @RequestMapping("/selecltBySize")
    @ResponseBody
    public Map<String,Object>selecltBySize(Integer movieid){
        Map<String,Object>map=new HashMap<>();
        int size = movieCommentService.getSize(movieid);
        map.put("size",size);
        return map;
    }
}
