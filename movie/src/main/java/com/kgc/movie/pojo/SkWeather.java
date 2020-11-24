package com.kgc.movie.pojo;

public class SkWeather {
    private String date;
    private String CurrentTemperature;
    private String conditions;
    private String windDirection;
    private String todayTemperature;

    public SkWeather(String date, String currentTemperature, String conditions, String windDirection, String todayTemperature) {
        this.date = date;
        CurrentTemperature = currentTemperature;
        this.conditions = conditions;
        this.windDirection = windDirection;
        this.todayTemperature = todayTemperature;
    }

    @Override
    public String toString() {
        return "SkWeather{" +
                "date='" + date + '\'' +
                ", CurrentTemperature='" + CurrentTemperature + '\'' +
                ", conditions='" + conditions + '\'' +
                ", windDirection='" + windDirection + '\'' +
                ", todayTemperature='" + todayTemperature + '\'' +
                '}';
    }

    public String getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }

    public String getTodayTemperature() {
        return todayTemperature;
    }

    public void setTodayTemperature(String todayTemperature) {
        this.todayTemperature = todayTemperature;
    }

    public SkWeather() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCurrentTemperature() {
        return CurrentTemperature;
    }

    public void setCurrentTemperature(String currentTemperature) {
        CurrentTemperature = currentTemperature;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }
}
