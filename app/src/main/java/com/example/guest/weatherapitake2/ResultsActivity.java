package com.example.guest.weatherapitake2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class ResultsActivity extends AppCompatActivity {
    public ArrayList<Forecast> mForecasts = new ArrayList<>();
    @Bind(R.id.zipCode) TextView mZip;
    @Bind(R.id.recyclerView)
    RecyclerView mRecyclerView;
    private ForecastListAdapter mAdapter;

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
        final OpenWeatherService openWeatherService = new OpenWeatherService();
        OpenWeatherService.getWeather(location, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) {
                mForecasts = openWeatherService.processResults(response);

                ResultsActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run(){
                        mAdapter = new ForecastListAdapter(getApplicationContext(), mForecasts);
                        mRecyclerView.setAdapter(mAdapter);
                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ResultsActivity.this);
                        mRecyclerView.setLayoutManager(layoutManager);
                        mRecyclerView.setHasFixedSize(true);
                    }
                });
            }
        });
    }
}
