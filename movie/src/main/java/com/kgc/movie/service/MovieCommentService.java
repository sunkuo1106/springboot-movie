package com.kgc.movie.service;

import com.kgc.movie.pojo.MovieComment;

import java.util.List;

public interface MovieCommentService {
    List<MovieComment>selectAll(Integer movieid);
    void add(MovieComment movieComment);
    int getSize(Integer movieid);
}
