package com.jiahuaandroid.h_mvp.core;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.jiahuaandroid.h_mvp.core.mvp.BasePresenter;
import com.jiahuaandroid.h_mvp.core.mvp.MvpView;


/**
 * Created by jhhuang on 2016/5/17.
 * QQ:781913268
 * Description：BaseActivity
 */
public abstract class BaseActivity<V extends MvpView,T extends BasePresenter<V>> extends AppCompatActivity {
    protected T mPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getBinding();
        mPresenter = createPresenter();
        mPresenter.attachView((V)this);


        this.initViews(savedInstanceState);
        this.initData();
        this.initListeners();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }

    /**
     * create presenter
     * @return
     */
    protected abstract T createPresenter();

    /**
     * databinding setContentView()
     */
    protected abstract void getBinding();

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
}
