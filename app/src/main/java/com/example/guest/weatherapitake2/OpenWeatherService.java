package com.example.guest.weatherapitake2;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Guest on 4/25/16.
 */
public class OpenWeatherService {
    public static void getWeather(String location, Callback callback) {
        String OPEN_WEATHER_KEY = Constants.OPEN_WEATHER_KEY;

        OkHttpClient client = new OkHttpClient.Builder()
                .build();
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

    public ArrayList<Forecast> processResults(Response response) {
        ArrayList<Forecast> forecasts = new ArrayList<>();

        try {
            String jsonData = response.body().string();
            Log.d("tag", "" + jsonData);
            if (response.isSuccessful()) {

                JSONObject openWeatherJSON = new JSONObject(jsonData);
                JSONArray forecastJSON = openWeatherJSON.getJSONArray("list");
                String[] days = new String[] { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
                for (int i = 0; i < forecastJSON.length(); i++) {
                    JSONObject infoJSON = forecastJSON.getJSONObject(i);
                    String city = openWeatherJSON.getJSONObject("city").getString("name");
                    Log.d("CITY", city);
                    String country = openWeatherJSON.getJSONObject("city").getString("country");
                    String day = days[i];
                    String temp = infoJSON.getJSONObject("temp").getString("day");
                    String hi = infoJSON.getJSONObject("temp").getString("max");
                    String lo = infoJSON.getJSONObject("temp").getString("min");
                    String main = infoJSON.getJSONArray("weather").getJSONObject(0).getString("main");
                    String description = infoJSON.getJSONArray("weather").getJSONObject(0).getString("description");
                    Forecast forecast = new Forecast(city, country, day, temp, main, description, hi, lo);
                    forecasts.add(forecast);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return forecasts;
    }
}
