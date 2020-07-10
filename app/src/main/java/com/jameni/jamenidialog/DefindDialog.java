package com.jameni.jamenidialog;


import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.jameni.jamenidialoglib.dialog.JameniSimpleDialog;

public class DefindDialog extends JameniSimpleDialog {

    public DefindDialog(Context context) {
        super(context);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.view_defind_dialog;
    }

    @Override
    protected void initViews() {
//        setFullScreen();//左右全屏
        Button btn3 = findView(R.id.btn3);
        Button btn4 = findView(R.id.btn4);

        setOnclick(btn3);
        setOnclick(btn4);
    }


    @Override
    protected void onClickById(int viewId) {

        switch (viewId) {
            case R.id.btn3:
                tip("btn3");
                break;
            case R.id.btn4:
                tip("btn4");
                dismiss();
                break;
        }

    }

    public void tip(String str) {
        Toast.makeText(context, str, Toast.LENGTH_SHORT).show();
    }

}
