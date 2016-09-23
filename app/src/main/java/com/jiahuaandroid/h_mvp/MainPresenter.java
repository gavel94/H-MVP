package com.jiahuaandroid.h_mvp;

import com.jiahuaandroid.h_mvp.core.mvp.BasePresenter;

import java.util.ArrayList;


/**
 * Created by jhhuang on 2016/5/18.
 * QQ:781913268
 * Description：MainPresenter
 */
public class MainPresenter extends BasePresenter<MainView> {

    /**
     * 这里进行联网获取数据或者其他逻辑操作
     */
    public void initData() {
        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");
        list.add("g");
        list.add("h");
        list.add("i");
        list.add("j");
        list.add("k");
        list.add("l");
        list.add("m");
        list.add("n");
        list.add("o");
        list.add("p");
        list.add("q");
        list.add("r");
        list.add("s");
        list.add("t");
        list.add("u");
        list.add("v");
        list.add("w");
        list.add("x");
        list.add("y");
        list.add("z");
        list.add("...");

        /**
         * 基类使用了弱引用，每次使用之前应该判空，防止莫名空指针
         */
        if (isViewAttached()) {
            /**
             * Presenter需要MainActivity帮助
             */
            getMvpView().setData(list);
        }

    }
}
