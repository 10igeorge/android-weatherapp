package com.example.guest.weatherapitake2;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.guest.weatherapitake2.R;

import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class ForecastDetailFragment extends Fragment {
    @Bind(R.id.dayTextView) TextView mDay;
    @Bind(R.id.highTempTextView) TextView mHigh;
    @Bind(R.id.lowTempTextView) TextView mLow;
    @Bind(R.id.precTextView) TextView mPrecipitation;
    private Forecast mForecast;


//
//
//    public ForecastDetailFragment() {
//        // Required empty public constructor
//    }

    public static ForecastDetailFragment newInstance(Forecast forecast){
        ForecastDetailFragment forecastDetailFragment = new ForecastDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("forecast", Parcels.wrap(forecast));
        forecastDetailFragment.setArguments(args);
        return forecastDetailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        mForecast = Parcels.unwrap(getArguments().getParcelable("forecast"));
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_forecast_detail, container, false);
        ButterKnife.bind(this, view);
        mDay.setText(mForecast.getDay());
        mLow.setText("Low " + mForecast.getLo());
        mHigh.setText("High " + mForecast.getHi());

        return view;
    }

}
