package com.jiahuaandroid.h_mvp;

import android.view.View;
import android.view.ViewGroup;

import com.jiahuaandroid.basetools.adapter.BaseRecyclerViewAdapter;
import com.jiahuaandroid.basetools.adapter.SwipItemTouchCallback;

import java.util.Collections;
import java.util.List;

/**
 * Created by jhhuang on 2016/5/26.
 * QQ:781913268
 * Description：MainAdapter
 */
public class MainAdapter extends BaseRecyclerViewAdapter<String,MainAdapter.MyViewHolder> implements SwipItemTouchCallback.ItemTouchAdapter{
    /**
     * @param list the datas to attach the adapter
     */
    public MainAdapter(List<String> list) {
        super(list);
    }

    @Override
    protected void bindDataToItemView(MyViewHolder myViewHolder, String item) {
        myViewHolder.setText(R.id.item_dec, item);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(inflateItemView(parent,R.layout.item_main));
    }

    @Override
    public void onMove(int fromPosition, int toPosition) {
        if (fromPosition==mList.size()-1 || toPosition==mList.size()-1){
            return;
        }
        if (fromPosition < toPosition) {
            for (int i = fromPosition; i < toPosition; i++) {
                Collections.swap(mList, i, i + 1);
            }
        } else {
            for (int i = fromPosition; i > toPosition; i--) {
                Collections.swap(mList, i, i - 1);
            }
        }
        notifyItemMoved(fromPosition, toPosition);
    }

    @Override
    public void onSwiped(int position) {
        mList.remove(position);
        notifyItemRemoved(position);
    }

    public class MyViewHolder extends BaseRecyclerViewAdapter.SparseArrayViewHolder {
        public MyViewHolder(View itemView) {
            super(itemView);
        }
    }
}
