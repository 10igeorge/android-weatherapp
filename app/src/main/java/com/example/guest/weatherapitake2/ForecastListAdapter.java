package com.example.guest.weatherapitake2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Guest on 4/25/16.
 */
public class ForecastListAdapter extends RecyclerView.Adapter<ForecastListAdapter.ForecastViewHolder> {
    private ArrayList<Forecast> mForecasts = new ArrayList<>();
    private Context mContext;

    public ForecastListAdapter(Context context, ArrayList<Forecast> restaurants) {
        mContext = context;
        mForecasts = restaurants;
    }

    @Override
    public ForecastListAdapter.ForecastViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.forecast_list_item, parent, false);
        ForecastViewHolder viewHolder = new ForecastViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ForecastListAdapter.ForecastViewHolder holder, int position) {
        holder.bindForecast(mForecasts.get(position));
    }

    @Override
    public int getItemCount() {
        return mForecasts.size();
    }

    public class ForecastViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.dayTextView) TextView mDayTextView;
        @Bind(R.id.tempTextView) TextView mTempTextView;
        @Bind(R.id.mainTextView) TextView mMainTextView;
        @Bind(R.id.descriptionTextView) TextView mDescriptionTextView;
        private Context mContext;


        public ForecastViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    int itemPosition = getLayoutPosition();
                    Intent i = new Intent(mContext, ForecastDetailActivity.class);
                    i.putExtra("position", itemPosition+"");
                    i.putExtra("restaurants", Parcels.wrap(mForecasts));
                    mContext.startActivity(i);
                }
            });


        }

        public void bindForecast(Forecast forecast) {
            mDayTextView.setText(forecast.getDay());
            mTempTextView.setText(forecast.getTemp());
            mMainTextView.setText(forecast.getMain());
            mDescriptionTextView.setText(forecast.getDescription());
        }
    }
}
