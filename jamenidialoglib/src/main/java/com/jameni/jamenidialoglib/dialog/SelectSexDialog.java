package com.jameni.jamenidialoglib.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.TextView;

import com.jameni.jamenidialoglib.R;
import com.jameni.jamenidialoglib.i.SelectImageListener;
import com.jameni.jamenidialoglib.i.SelectSexListener;

/**
 * 选图对话框
 */

public class SelectSexDialog extends JameniBaseDialog implements OnClickListener {

    private Activity activity;
    private TextView tvBoy, tvGirl, tvUnknow, tvCancle;
    private SelectSexListener listener;
    private boolean isShowUnknow = true;//是否显示未知 按钮

    public SelectSexDialog(Activity activity, SelectSexListener listener, boolean isCenter) {
        super(activity, isCenter);
        this.activity = activity;
        this.listener = listener;
    }

    public SelectSexDialog(Activity activity, SelectSexListener listener) {
        super(activity, false);
        this.activity = activity;
        this.listener = listener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        View view = LayoutInflater.from(activity).inflate(R.layout.view_jameni_dialog_select_sex, null);
        setContentView(view);
        tvBoy = view.findViewById(R.id.tvBoy);
        tvGirl = view.findViewById(R.id.tvGirl);
        tvUnknow = view.findViewById(R.id.tvUnknow);
        tvCancle = view.findViewById(R.id.tvCancle);

        tvBoy.setOnClickListener(this);
        tvGirl.setOnClickListener(this);
        tvUnknow.setOnClickListener(this);
        tvCancle.setOnClickListener(this);

        if (isCenter) {
            tvCancle.setVisibility(View.GONE);
        } else {
            getWindow().setLayout(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
            getWindow().setGravity(Gravity.BOTTOM | Gravity.CENTER);
        }

        setUnknowVisiable(isShowUnknow);
    }

    public void setUnknowVisiable(boolean visiable) {

        if (isNotNull(tvUnknow)) {
            if (visiable) {
                tvUnknow.setVisibility(View.VISIBLE);
            } else {
                tvUnknow.setVisibility(View.GONE);
            }
        }
    }

    public void setShowUnknow(boolean showUnknow) {
        isShowUnknow = showUnknow;
        setUnknowVisiable(showUnknow);
    }

    @Override
    public void onClick(View v) {

        if (isNotNull(listener)) {
            if (v.getId() == R.id.tvBoy) {
                listener.selectSex(1, "男");
            } else if (v.getId() == R.id.tvGirl) {
                listener.selectSex(2, "女");
            } else if (v.getId() == R.id.tvUnknow) {
                listener.selectSex(0, "未知");
            }
        }

        dismiss();
    }


    private boolean isNotNull(Object obj) {
        return null != obj;
    }

    public void setListener(SelectSexListener listener) {
        this.listener = listener;
    }

    public TextView getTvBoy() {
        return tvBoy;
    }

    public TextView getTvGirl() {
        return tvGirl;
    }

    public TextView getTvUnknow() {
        return tvUnknow;
    }

    public TextView getTvCancle() {
        return tvCancle;
    }
}
