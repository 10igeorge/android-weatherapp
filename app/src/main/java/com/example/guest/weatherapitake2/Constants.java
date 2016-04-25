package com.example.guest.weatherapitake2;

import android.os.Build;

/**
 * Created by Guest on 4/25/16.
 */
public class Constants {
    public static final String OPEN_WEATHER_KEY = BuildConfig.OPEN_WEATHER_KEY;

    public static final String OPEN_WEATHER_BASE_URL = "http://api.openweathermap.org/data/2.5/forecast/daily?units=metric&cnt=7&";
    public static final String OPEN_WEATHER_LOCATION_QUERY_PARAMETER = "q";

}
