package com.example.guest.weatherapitake2;

/**
 * Created by Guest on 4/25/16.
 */
public class Forecast {
    private String mCity;
    private String mCountry;
    private String mDay;
    private String mTemp;
    private String mMain;
    private String mDescription;

    public Forecast(String city, String country, String day, String temp, String main, String description) {
        this.mCity = city;
        this.mCountry = country;
        this.mDay = day;
        this.mTemp = temp;
        this.mMain = main;
        this.mDescription = description;
    }

    public String getCity() {
        return mCity;
    }

    public String getCountry() {
        return mCountry;
    }

    public String getDay() {
        return mDay;
    }

    public String getTemp() {
        return mTemp;
    }

    public String getMain(){
        return mMain;
    }

    public String getDescription(){
        return mDescription;
    }
}
