package com.example.guest.weatherapitake2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  {
    @Bind(R.id.zipCodeEditText) EditText mZipSearch;
    @Bind(R.id.searchButton) Button mSearchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mSearchButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        if(v.getId() == R.id.searchButton){
            String location = mZipSearch.getText().toString();
            Intent i = new Intent(MainActivity.this, ResultsActivity.class);
            i.putExtra("location", location);
            startActivity(i);
        }
    }
}
