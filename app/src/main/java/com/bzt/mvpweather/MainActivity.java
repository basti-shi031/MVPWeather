package com.bzt.mvpweather;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.TextView;

import model.Weather;
import presenter.WeatherPresenter;
import view.WeatherView;

public class MainActivity extends AppCompatActivity {
    WeatherPresenter mWeatherPresenter;
    WeatherView weatherView;
    ProgressDialog progressDialog;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        textView = (TextView) findViewById(R.id.text);
        mWeatherPresenter = new WeatherPresenter();
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("loading");
        weatherView = new WeatherView(){
            @Override
            public void showData(Weather weather) {
                Log.i("TAG","showData");
                textView.setText(weather.toString());
            }

            @Override
            public void showProgress() {
                Log.i("TAG", "showProgress");
                progressDialog.show();
            }

            @Override
            public void hideProgress() {
                Log.i("TAG", "hideProgress");
                progressDialog.dismiss();
            }
        };
        mWeatherPresenter.attachView(weatherView);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mWeatherPresenter.loadData();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
