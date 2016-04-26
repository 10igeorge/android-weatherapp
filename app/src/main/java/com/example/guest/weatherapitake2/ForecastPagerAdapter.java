package com.example.guest.weatherapitake2;



import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Guest on 4/26/16.
 */
public class ForecastPagerAdapter extends FragmentPagerAdapter{
    private ArrayList<Forecast> mForecasts;

    public ForecastPagerAdapter(FragmentManager fm, ArrayList<Forecast> forecasts){
        super(fm);
        mForecasts = forecasts;
    }

    @Override
    public Fragment getItem(int position){
        return ForecastDetailFragment.newInstance(mForecasts.get(position));
    }

    @Override public int getCount(){
        return mForecasts.size();
    }

    @Override
    public CharSequence getPageTitle(int position){
        return mForecasts.get(position).getDay();
    }

}
