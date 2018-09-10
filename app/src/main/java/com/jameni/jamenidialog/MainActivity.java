package com.jameni.jamenidialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.jameni.jamenidialoglib.dialog.NormalDialog;
import com.jameni.jamenidialoglib.dialog.SingleDialog;
import com.jameni.jamenidialoglib.i.NormalDialogListener;
import com.jameni.jamenidialoglib.i.SingleDialogListener;

public class MainActivity extends AppCompatActivity implements NormalDialogListener, SingleDialogListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btn1(View view) {

        SingleDialog dialog = new SingleDialog(this);
        dialog.setContentText("abx");
        dialog.setBtnText("ddd");
        dialog.setSingleListener(this);
        dialog.show();

    }

    public void btn2(View view) {

        NormalDialog dialog = new NormalDialog(this);
        dialog.setContentText("abx");
        dialog.setLeftBtnText("leftdd");
        dialog.setRightBtnText("right");
        dialog.setNormalListener(this);
        dialog.show();

    }

    @Override
    public void onLeftClick(Object obj, int actionTag) {
        tip("left");
    }

    @Override
    public void onRightClick(Object obj, int actionTag) {
        tip("right");
    }

    public void tip(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSingleOk(Object obj, int actionTag) {
        tip("onSingleOk");
    }
}
