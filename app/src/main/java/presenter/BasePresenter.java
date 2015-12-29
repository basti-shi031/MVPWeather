package presenter;

/**
 * Created by SHIBW-PC on 2015/12/29.
 */
public interface BasePresenter<V> {

    void attachView(V v);

    void detachView();

}
