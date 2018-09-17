package com.jameni.jamenidialoglib.dialog;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.jameni.jamenidialoglib.R;
import com.jameni.jamenidialoglib.adapter.SelectionAdapter;
import com.jameni.jamenidialoglib.i.DialogItemClickListener;
import com.jameni.jamenidialoglib.i.SelectSexListener;
import com.jameni.jamenidialoglib.i.SelectionItemModel;

import java.util.List;

/**
 * 列表
 */

public class ListDialog extends JameniBaseDialog implements AdapterView.OnItemClickListener {

    private ListView dialogList;
    private DialogItemClickListener listener;
    private SelectionAdapter adapter;
    private List datalist;

    public ListDialog(Context context, List list) {
        super(context, true);
        this.datalist = list;
    }

    public ListDialog(Context context, List list, DialogItemClickListener listener) {
        super(context, true);
        this.listener = listener;
        this.datalist = list;
    }

    public ListDialog(Activity activity, List list, DialogItemClickListener listener, boolean isCenter) {
        super(activity, isCenter);
        this.listener = listener;
        this.datalist = list;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        View view = LayoutInflater.from(context).inflate(R.layout.view_jameni_dialog_list, null);
        setContentView(view);
        dialogList = view.findViewById(R.id.dialogList);
        adapter = new SelectionAdapter(context);
        dialogList.setAdapter(adapter);
        adapter.update(datalist);
        dialogList.setOnItemClickListener(this);

        if (isCenter) {


        } else {
            getWindow().setLayout(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
            getWindow().setGravity(Gravity.BOTTOM | Gravity.CENTER);
        }

    }


    public void setListener(DialogItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        if (!isNull(listener)) {
            listener.dialogItemClick(adapter.getItem(i), i, Tag);
        }

        dismiss();

    }
}
