package com.jiahuaandroid.h_mvp;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.jiahuaandroid.basetools.adapter.OnRecyclerItemClickListener;
import com.jiahuaandroid.basetools.adapter.SwipItemTouchCallback;
import com.jiahuaandroid.basetools.utils.CUtils;
import com.jiahuaandroid.h_mvp.core.BaseActivity;
import com.jiahuaandroid.h_mvp.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity<MainView,MainPresenter> implements SwipItemTouchCallback.OnDragListener,MainView {
    private MainActivity self = MainActivity.this;
    private ActivityMainBinding binding;
    private List<String> data;
    private MainAdapter adapter;
    private ItemTouchHelper itemTouchHelper;
    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter();
    }

    @Override
    protected void getBinding() {
        binding = DataBindingUtil.setContentView(self, R.layout.activity_main);
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        super.initViews(savedInstanceState);
    }

    @Override
    protected void initData() {
        super.initData();
        data = new ArrayList<>();
        adapter = new MainAdapter(data);
        binding.mainRecyclerView.setHasFixedSize(true);
        binding.mainRecyclerView.setAdapter(adapter);
        binding.mainRecyclerView.setLayoutManager(new GridLayoutManager(self, 4));
//        binding.mainRecyclerView.addItemDecoration(new DividerGridItemDecoration(self));

        itemTouchHelper = new ItemTouchHelper(new SwipItemTouchCallback(adapter).setOnDragListener(this));
        itemTouchHelper.attachToRecyclerView(binding.mainRecyclerView);
        /**
         * 逻辑放在Presenter，比如获取数据
         */
        mPresenter.initData();
    }

    @Override
    protected void initListeners() {
        super.initListeners();
        binding.mainRecyclerView.addOnItemTouchListener(new OnRecyclerItemClickListener(binding.mainRecyclerView) {
            @Override
            public void onItemClick(RecyclerView.ViewHolder vh) {
                CUtils.showMsg(data.get(vh.getAdapterPosition()));
            }

            @Override
            public void onItemLongClick(RecyclerView.ViewHolder vh) {
                if (vh.getAdapterPosition()!=data.size()-1) {
                    itemTouchHelper.startDrag(vh);
                    CUtils.Vibrate(self, 70);
                }
            }
        });
    }

    @Override
    public void onFinishDrag() {
        CUtils.showMsg(getString(R.string.ok));
    }

    @Override
    public void setData(ArrayList<String> list) {
        data.addAll(list);
        adapter.notifyDataSetChanged();
    }
}
