package com.kgc.movie.pojo;

import java.util.Date;

public class MovieTicket {
    private Integer movieId;

    private String userName;

    private Integer movieYingchengid;

    private String movieName;

    private Date movieDate;

    private String movieRoom;

    private Float moviePrice;

    private String movieWhether;

    private String movieSeat;

    private Integer enterId;

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Integer getMovieYingchengid() {
        return movieYingchengid;
    }

    public void setMovieYingchengid(Integer movieYingchengid) {
        this.movieYingchengid = movieYingchengid;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName == null ? null : movieName.trim();
    }

    public Date getMovieDate() {
        return movieDate;
    }

    public void setMovieDate(Date movieDate) {
        this.movieDate = movieDate;
    }

    public String getMovieRoom() {
        return movieRoom;
    }

    public void setMovieRoom(String movieRoom) {
        this.movieRoom = movieRoom == null ? null : movieRoom.trim();
    }

    public Float getMoviePrice() {
        return moviePrice;
    }

    public void setMoviePrice(Float moviePrice) {
        this.moviePrice = moviePrice;
    }

    public String getMovieWhether() {
        return movieWhether;
    }

    public void setMovieWhether(String movieWhether) {
        this.movieWhether = movieWhether == null ? null : movieWhether.trim();
    }

    public String getMovieSeat() {
        return movieSeat;
    }

    public void setMovieSeat(String movieSeat) {
        this.movieSeat = movieSeat == null ? null : movieSeat.trim();
    }

    public Integer getEnterId() {
        return enterId;
    }

    public void setEnterId(Integer enterId) {
        this.enterId = enterId;
    }
}