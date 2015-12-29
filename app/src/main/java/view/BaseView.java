package view;

/**
 * Created by SHIBW-PC on 2015/12/29.
 */
public interface BaseView<T>{

    void showData(T t);
    void showProgress();
    void hideProgress();
}
