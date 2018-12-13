package com.jameni.jamenidialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.jameni.jamenidialoglib.dialog.ListDialog;
import com.jameni.jamenidialoglib.dialog.LoadingDialog;
import com.jameni.jamenidialoglib.dialog.NormalDialog;
import com.jameni.jamenidialoglib.dialog.SelectImageDialog;
import com.jameni.jamenidialoglib.dialog.SelectSexDialog;
import com.jameni.jamenidialoglib.dialog.SingleDialog;
import com.jameni.jamenidialoglib.i.NormalDialogListener;
import com.jameni.jamenidialoglib.i.SelectImageListener;
import com.jameni.jamenidialoglib.i.SelectSexListener;
import com.jameni.jamenidialoglib.i.SingleDialogListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SelectSexListener, SelectImageListener, NormalDialogListener, SingleDialogListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btn1(View view) {

        SingleDialog dialog = new SingleDialog(this);
        dialog.setContentText("abxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabx");
        dialog.setBtnText("ddd");
        dialog.setSingleListener(this);
        dialog.show();

    }

    public void btn2(View view) {

        NormalDialog dialog = new NormalDialog(this);
        dialog.setContentText("abxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabx");
        dialog.setLeftBtnText("leftdd");
        dialog.setRightBtnText("right");
        dialog.setNormalListener(this);
        dialog.show();

    }


    public void btn3(View view) {

        SelectImageDialog dialog = new SelectImageDialog(this, this, false);
        dialog.show();

    }

    public void btn4(View view) {

        SelectSexDialog dialog = new SelectSexDialog(this, this, true);
        dialog.show();

    }


    public void btn5(View view) {

        LoadingDialog dialog = new LoadingDialog(this);
        dialog.setCanceledOnTouchOutside(true);
        dialog.show();

    }

    public void btn6(View view) {

        List<ItemModel> datalist = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            datalist.add(new ItemModel(i + ""));
        }


        ListDialog dialog = new ListDialog(this, datalist, null, false);
        dialog.setHeightScale(0.8f);
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

    @Override
    public void selectPic() {
        tip("selectPic");
    }

    @Override
    public void takePic() {
        tip("takePic");
    }

    @Override
    public void selectSex(int sexType, String sexText) {
        tip(sexType + "===" + sexText);
    }
}
