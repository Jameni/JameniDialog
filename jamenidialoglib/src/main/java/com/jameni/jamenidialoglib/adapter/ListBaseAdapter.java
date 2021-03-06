package com.jameni.jamenidialoglib.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.jameni.jamenidialoglib.i.SelectionItemModel;

import java.util.List;

/**
 * Listview Adapter
 */
public abstract class ListBaseAdapter<T extends SelectionItemModel> extends BaseAdapter {

    protected List<T> mList;
    protected Context mContext;

    public ListBaseAdapter(Context context) {
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return mList == null ? 0 : mList.size();
    }

    @Override
    public T getItem(int position) {
        return mList == null ? null : mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    abstract public View getView(int position, View convertView, ViewGroup parent);

    public void update(List<T> list) {
        this.mList = list;
        notifyDataSetChanged();
    }

    public List<T> getList() {
        return mList;
    }


}
