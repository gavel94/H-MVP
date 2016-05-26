package com.jiahuaandroid.h_mvp;


import com.jiahuaandroid.h_mvp.core.mvp.MvpView;

import java.util.ArrayList;

/**
 * Created by jhhuang on 2016/5/18.
 * QQ:781913268
 * Description：MainView
 */
public interface MainView extends MvpView {

    /**
     * 已经获取到数据，需要MainActivity显示数据
     * @param list
     */
    void setData(ArrayList<String> list);
}
