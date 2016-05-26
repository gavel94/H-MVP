package com.jiahuaandroid.h_mvp.core.mvp;

/**
 * Created by jhhuang on 2016/5/17.
 * QQ:781913268
 * Description：Presenter
 */
public interface Presenter<V extends MvpView> {
    /**
     * 关联
     * @param mvpView
     */
    void attachView(V mvpView);

    /**
     * 解除关联
     */
    void detachView();
}
