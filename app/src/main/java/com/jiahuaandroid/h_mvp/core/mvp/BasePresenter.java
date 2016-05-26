package com.jiahuaandroid.h_mvp.core.mvp;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * Created by jhhuang on 2016/5/17.
 * QQ:781913268
 * Description：BasePresenter
 */
public class BasePresenter<V extends MvpView> implements Presenter<V> {
    //    private V mMvpView;
    protected Reference<V> mMvpView;

    @Override
    public void attachView(V mvpView) {
        this.mMvpView = new WeakReference<>(mvpView);
    }

    @Override
    public void detachView() {
        if (this.mMvpView != null) {
            this.mMvpView.clear();
            this.mMvpView = null;
        }
    }

    /**
     * 是否已经关联
     *
     * @return
     */
    public boolean isViewAttached() {
        return mMvpView != null && mMvpView.get() != null;
    }

    /**
     * 获取接口
     *
     * @return
     */
    public V getMvpView() {
        return mMvpView.get();
    }

    /**
     * 检查是否关联并抛出自定义异常
     */
    public void checkViewAttached() {
        if (!isViewAttached()) throw new MvpViewNotAttachedException();
    }


    public static class MvpViewNotAttachedException extends RuntimeException {
        public MvpViewNotAttachedException() {
            super("Please call Presenter.attachView(MvpView) before" +
                    " requesting data to the Presenter");
        }
    }
}
