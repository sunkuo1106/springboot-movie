package com.kgc.movie.service;

import com.kgc.movie.pojo.MovieTicket;

import java.util.List;

public interface UserOderService {
    List<MovieTicket>selectAllOrder(String userName);
}
