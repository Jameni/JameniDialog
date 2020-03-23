package com.jameni.jamenidialoglib.dialog;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.jameni.jamenidialoglib.R;


/**
 * 加载框
 */
public class LoadingDialog extends JameniBaseDialog implements OnClickListener {

    public LoadingDialog(Context context) {
        super(context, R.style.JameniLoadingDialogStyle);
    }

    private TextView tvMsg;
    private ProgressBar pBar;
    private String strMsg = "";
    private Drawable pbColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View view = LayoutInflater.from(context).inflate(R.layout.view_jameni_loading_dialog, null);
        setContentView(view);
        tvMsg = findViewById(R.id.tvMsg);
        pBar = findViewById(R.id.pBar);
        if (strMsg != null && !strMsg.equals("")) {
            tvMsg.setText(Html.fromHtml(strMsg));
            setMsgVisiable(true);
        } else {
            setMsgVisiable(false);
        }

        if (pbColor != null) {
            pBar.setIndeterminateDrawable(pbColor);
        }


    }

    @Override
    public void onClick(View v) {

        if (!isNull(singleListener)) {
            singleListener.onSingleOk(obj, Tag);
        }
        dismiss();

    }

    //设置信息
    public void setMsg(String str) {
        this.strMsg = str;
        if (tvMsg != null && !isNull(str)) {
            tvMsg.setText(str);
            setMsgVisiable(true);
        }
    }

    public void setMsgVisiable(boolean visiable) {

        if (isNull(tvMsg)) return;

        if (visiable) {
            tvMsg.setVisibility(View.VISIBLE);
        } else {
            tvMsg.setVisibility(View.GONE);
        }

    }

    public void setProgressColor(Drawable progressColor) {
        this.pbColor = progressColor;
        if (pBar != null && progressColor != null) {
            pBar.setIndeterminateDrawable(progressColor);
        }
    }


    public TextView getTvMsg() {
        return tvMsg;
    }

    public ProgressBar getpBar() {
        return pBar;
    }
}

