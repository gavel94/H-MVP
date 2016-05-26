package com.jiahuaandroid.h_mvp;

import android.app.Application;

import com.jiahuaandroid.basetools.utils.CUtils;
import com.jiahuaandroid.basetools.utils.LogUtil;

/**
 * Created by jhhuang on 2016/5/26.
 * QQ:781913268
 * Description：MyApplication
 */
public class MyApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        CUtils.init(this);
        LogUtil.debug(LogUtil.VERBOSE);
    }
}
