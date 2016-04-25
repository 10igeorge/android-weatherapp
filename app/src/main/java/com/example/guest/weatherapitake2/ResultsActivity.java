package com.example.guest.weatherapitake2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.IOException;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class ResultsActivity extends AppCompatActivity {
    @Bind(R.id.zipCode) TextView mZip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        ButterKnife.bind(this);

        Intent i = getIntent();
        String location = i.getStringExtra("location");
        mZip.setText(location);

        findWeather(location);
    }

    private void findWeather(String location){
        OpenWeatherService.getWeather(location, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try{
                    String jsonData = response.body().string();
                    if(response.isSuccessful()){
                        Log.v("hey", jsonData);
                    }
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        });
    }
}
