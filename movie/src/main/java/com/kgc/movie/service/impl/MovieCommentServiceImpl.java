package com.kgc.movie.service.impl;

import com.kgc.movie.dao.MovieCommentMapper;
import com.kgc.movie.pojo.MovieComment;
import com.kgc.movie.pojo.MovieCommentExample;
import com.kgc.movie.service.MovieCommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MovieCommentServiceImpl  implements MovieCommentService {
    @Resource
    MovieCommentMapper movieCommentMapper;
    @Override
    public List<MovieComment> selectAll(Integer movieid) {
        MovieCommentExample example=new MovieCommentExample();
        MovieCommentExample.Criteria criteria = example.createCriteria();
        criteria.andMovieidEqualTo(movieid);
        example.setOrderByClause("id desc");
        return movieCommentMapper.selectByExample(example);
    }

    @Override
    public void add(MovieComment movieComment) {
        movieCommentMapper.insertSelective(movieComment);
    }

    @Override
    public int getSize(Integer movieid) {
        MovieCommentExample example=new MovieCommentExample();
        MovieCommentExample.Criteria criteria = example.createCriteria();
        criteria.andMovieidEqualTo(movieid);
        int size = movieCommentMapper.selectByExample(example).size();
        return size;
    }
}
