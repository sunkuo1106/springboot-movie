package com.kgc.movie.service;

import com.kgc.movie.pojo.MovieTicket;

import java.util.Date;
import java.util.List;

public interface MovieTicketService {
    void addMovieTicket(MovieTicket movieTicket);
    List<MovieTicket> ceshiList(String yingpianname, Integer yingyuanid, Date datetime);
    int movieById();
}
