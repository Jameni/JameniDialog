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

/**
 * 选图对话框
 */

public class SelectImageDialog extends Dialog implements OnClickListener {

    private Activity activity;
    private TextView tvAlbum, tvCammera, tvCancle;
    private SelectImageListener listener;
    private boolean isCenter;//是否在屏幕中间展示

    public SelectImageDialog(Activity activity, SelectImageListener listener, boolean isCenter) {
        super(activity, isCenter ? R.style.JameniDialogStyle : R.style.jameni_dialog_from_bottom);
        this.activity = activity;
        this.listener = listener;
        this.isCenter = isCenter;
    }


    public SelectImageDialog(Activity activity, SelectImageListener listener) {
        super(activity, R.style.jameni_dialog_from_bottom);
        this.activity = activity;
        this.listener = listener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        View view = LayoutInflater.from(activity).inflate(R.layout.view_jameni_dialog_select_img, null);
        setContentView(view);
        tvAlbum = view.findViewById(R.id.tvAlbum);
        tvCammera = view.findViewById(R.id.tvCammera);
        tvCancle = view.findViewById(R.id.tvCancle);

        tvAlbum.setOnClickListener(this);
        tvCammera.setOnClickListener(this);
        tvCancle.setOnClickListener(this);


        if (isCenter) {
            tvCancle.setVisibility(View.GONE);
        } else {
            getWindow().setLayout(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
            getWindow().setGravity(Gravity.BOTTOM | Gravity.CENTER);
        }

    }

    @Override
    public void onClick(View v) {

        if (isNotNull(listener)) {
            if (v.getId() == R.id.tvAlbum) {
                listener.selectPic();
            } else if (v.getId() == R.id.tvCammera) {
                listener.takePic();
            } else if (v.getId() == R.id.tvCancle) {
            }
        }

        dismiss();// 将当前对话框关闭
    }


    private boolean isNotNull(Object obj) {
        return null != obj;
    }

    public void setListener(SelectImageListener listener) {
        this.listener = listener;
    }
}
