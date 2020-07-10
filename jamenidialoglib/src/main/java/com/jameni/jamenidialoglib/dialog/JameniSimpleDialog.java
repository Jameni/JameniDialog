package com.jameni.jamenidialoglib.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RelativeLayout;

import com.jameni.jamenidialoglib.R;

public abstract class JameniSimpleDialog extends Dialog implements View.OnClickListener {

    protected Context context;
    protected int Tag;
    protected Object obj;//用来存数据
    protected boolean isCenter;//是否在屏幕中间展示
    public View contentView;
    public RelativeLayout rlContent;
    public View childContent;

    public JameniSimpleDialog(Context context) {
        super(context, R.style.JameniDialogStyle);
        this.context = context;
    }

    public JameniSimpleDialog(Context context, int themeResId) {
        super(context, themeResId);
        this.context = context;
    }

    public JameniSimpleDialog(Context context, boolean isCenter) {
        super(context, isCenter ? R.style.JameniDialogStyle : R.style.jameni_dialog_from_bottom);
        this.isCenter = isCenter;
        this.context = context;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        contentView = LayoutInflater.from(context).inflate(R.layout.view_jameni_dialog_container, null);
        setContentView(contentView);
        rlContent = contentView.findViewById(R.id.rlContent);
        childContent = LayoutInflater.from(context).inflate(getLayoutId(), null);
        rlContent.addView(childContent);

        //子视图撑满父视图
        childContent.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT));
        initViews();
    }

    protected <T extends View> T findView(int viewId) {
        return rlContent.findViewById(viewId);
    }

    public void setTag(int tag) {
        Tag = tag;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public Object getObj() {
        return obj;
    }


    protected abstract int getLayoutId();

    protected abstract void initViews();

    protected abstract void onClickById(int viewId);

    protected void setOnclick(View view) {
        view.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        onClickById(v.getId());
    }

    //设置左右全屏
    public void setFullScreen() {
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    }

    public void setWindowWidth(int dimen) {
        if (dimen > 0) {
            getWindow().setLayout(dimen, ViewGroup.LayoutParams.WRAP_CONTENT);
        }
    }

}
