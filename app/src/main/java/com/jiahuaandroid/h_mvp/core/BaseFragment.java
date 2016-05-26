package com.jiahuaandroid.h_mvp.core;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.jiahuaandroid.h_mvp.core.mvp.BasePresenter;
import com.jiahuaandroid.h_mvp.core.mvp.MvpView;


/**
 * Created by jhhuang on 2016/5/18.
 * QQ:781913268
 * Description：BaseFragment
 */
public abstract class BaseFragment<V extends MvpView,T extends BasePresenter<V>> extends Fragment {
    protected BaseFragment self = BaseFragment.this;
    protected Activity mActivity;
    protected T mPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = getActivity();
        mPresenter = createPresenter();
        mPresenter.attachView((V) this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        self.initViews(savedInstanceState);
        self.initData();
        self.initListeners();
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }

    /**
     * initialize the view in the layout
     * @param savedInstanceState
     */
    protected void initViews(Bundle savedInstanceState) {

    }

    /**
     * initialize the Activity data
     */
    protected void initData() {

    }

    /**
     * initialize
     */
    protected void initListeners() {

    }

    /**
     * create presenter
     * @return
     */
    protected abstract T createPresenter();
}
