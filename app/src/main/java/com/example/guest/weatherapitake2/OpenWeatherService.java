package com.example.guest.weatherapitake2;

import android.util.Log;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by Guest on 4/25/16.
 */
public class OpenWeatherService {
    public static void getWeather(String location, Callback callback) {
        String OPEN_WEATHER_KEY = Constants.OPEN_WEATHER_KEY;

        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        Log.d("tag", "" + HttpUrl.parse(Constants.OPEN_WEATHER_BASE_URL));
        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.OPEN_WEATHER_BASE_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.OPEN_WEATHER_LOCATION_QUERY_PARAMETER, location);
        urlBuilder.addQueryParameter("appid", OPEN_WEATHER_KEY);
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }
}
