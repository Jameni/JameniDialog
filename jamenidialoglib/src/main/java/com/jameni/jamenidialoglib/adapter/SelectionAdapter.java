package com.jameni.jamenidialoglib.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jameni.jamenidialoglib.R;
import com.jameni.jamenidialoglib.i.SelectionItemModel;

public class SelectionAdapter extends ListBaseAdapter {


    public SelectionAdapter(Context context) {
        super(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_txt, null);

            holder = new ViewHolder();
            holder.tv = convertView.findViewById(R.id.tv);
            holder.rlSelectionItem = convertView.findViewById(R.id.rlSelectionItem);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }



        if (getItem(position) instanceof SelectionItemModel) {
            SelectionItemModel model = getItem(position);

            holder.tv.setText(model.getText() == null ? "" : model.getText());
            if (model.getTextSize()> 0) {
                holder.tv.setTextSize(model.getTextSize());
            }

            if (model.getTextColorResId() > 0) {
                holder.tv.setTextColor(mContext.getResources().getColor(model.getTextColorResId()));
            }

            if (model.getBackgroundColorResId() > 0) {
                holder.rlSelectionItem.setBackgroundResource(model.getBackgroundColorResId());
            }
        }




        return convertView;
    }

    class ViewHolder {
        public TextView tv;
        public RelativeLayout rlSelectionItem;
    }


}
