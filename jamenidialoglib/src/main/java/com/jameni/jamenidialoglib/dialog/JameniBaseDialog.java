package com.jameni.jamenidialoglib.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.jameni.jamenidialoglib.R;
import com.jameni.jamenidialoglib.i.NormalDialogListener;
import com.jameni.jamenidialoglib.i.SingleDialogListener;

public class JameniBaseDialog extends Dialog {

    protected Context context;
    protected NormalDialogListener listener;
    protected SingleDialogListener singleListener;
    protected int Tag;
    protected Object obj;//用来存数据
    protected boolean isCenter;//是否在屏幕中间展示


    public JameniBaseDialog(Context context) {
        super(context, R.style.JameniDialogStyle);
        this.isCenter = true;
        this.context = context;
    }

    public JameniBaseDialog(Context context, int themeResId) {
        super(context, themeResId);
        this.context = context;
    }

    public JameniBaseDialog(Context context, boolean isCenter) {
        super(context, isCenter ? R.style.JameniDialogStyle : R.style.jameni_dialog_from_bottom);
        this.isCenter = isCenter;
        this.context = context;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);
    }

    public void setTag(int tag) {
        Tag = tag;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public void setNormalListener(NormalDialogListener listener) {
        this.listener = listener;
    }

    public void setSingleListener(SingleDialogListener singleListener) {
        this.singleListener = singleListener;
    }

    protected static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    protected static boolean isNull(Object obj) {
        return obj == null;
    }

}
