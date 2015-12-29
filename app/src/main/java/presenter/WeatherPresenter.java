package presenter;

import android.os.Handler;
import android.os.Message;

import model.Weather;
import view.WeatherView;

/**
 * Created by SHIBW-PC on 2015/12/29.
 */
public class WeatherPresenter implements BasePresenter<WeatherView> {

    private WeatherView mWeatherView;
    private Handler mHandler;
    @Override
    public void attachView(WeatherView weatherView) {
        this.mWeatherView = weatherView;
    }

    @Override
    public void detachView() {
        mWeatherView = null;
    }

    public void loadData(){
        if (mHandler== null){
            mHandler = new Handler(){
                @Override
                public void handleMessage(Message msg) {
                    mWeatherView.showData((Weather)msg.obj);
                    mWeatherView.hideProgress();
                }
            };
        }
        mWeatherView.showProgress();

        new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Weather weather = new Weather();
                weather.setCity("city");
                weather.setWs("ws");
                weather.setWd("wd");
                weather.setTime("time");

                Message message = Message.obtain();
                message.obj = weather;
                mHandler.sendMessage(message);

            }
        }.start();
    }
}
