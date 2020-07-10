package com.jameni.jamenidialog;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.jameni.jamenidialoglib.JameniDialog;
import com.jameni.jamenidialoglib.i.DialogItemClickListener;
import com.jameni.jamenidialoglib.i.NormalDialogListener;
import com.jameni.jamenidialoglib.i.SelectImageListener;
import com.jameni.jamenidialoglib.i.SelectSexListener;
import com.jameni.jamenidialoglib.i.SingleDialogListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SelectSexListener, SelectImageListener, NormalDialogListener, SingleDialogListener, DialogItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btn1(View view) {

//        SingleDialog dialog = new SingleDialog(this);
//        dialog.setContentText("abxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabx");
//        dialog.setBtnText("ddd");
//        dialog.setSingleListener(this);
//        dialog.show();

        new JameniDialog.Builder(this)
                .setSingleDialogListener(this)
                .setMsg("提示信息1")
                .setTitle("这是标题1")
                .setSingleBtnText("确定1")
                .showSingleDialog();


    }

    public void btn2(View view) {

//        NormalDialog dialog = new NormalDialog(this);
//        dialog.setContentText("abxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabxabx");
//        dialog.setLeftBtnText("leftdd");
//        dialog.setRightBtnText("right");
//        dialog.setNormalListener(this);
//        dialog.show();

        new JameniDialog.Builder(this)
                .setNormalDialogListener(this)
                .setMsg("提示信息2")
//                .setTitle("这是标题2")
                .setLeftText("left2")
                .setRightText("right2")
                .showNormalDialog();


    }


    public void btn3(View view) {

//        SelectImageDialog dialog = new SelectImageDialog(this, this, false);
//        dialog.show();

        new JameniDialog.Builder(this)
                .setActivity(this)
                .setClickOutSizeCancle(true)
                .setSelectImageListener(this)
                .setDialogCenter(false)
                .showSelectImageDialog();

    }

    public void btn4(View view) {

//        SelectSexDialog dialog = new SelectSexDialog(this, this, true);
//        dialog.show();

        new JameniDialog.Builder(this)
                .setActivity(this)
                .setSelectSexListener(this)
                .setClickOutSizeCancle(true)
                .setDialogCenter(false)
                .showSexDialog();
    }


    public void btn5(View view) {

//        LoadingDialog dialog = new LoadingDialog(this);
//        dialog.setCanceledOnTouchOutside(true);
//        dialog.show();

        new JameniDialog.Builder(this)
                .setLoadingText("顶顶顶顶顶顶顶顶顶顶大大大")
                .setClickOutSizeCancle(true)
                .showLoadingDialog();



    }

    public void btn6(View view) {

        List<ItemModel> datalist = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            datalist.add(new ItemModel(i + ""));
        }
//        ListDialog dialog = new ListDialog(this, datalist, null, false);
//        dialog.setHeightScale(0.8f);
//        dialog.show();
        new JameniDialog.Builder(this)
                .setActivity(this)
                .setList(datalist)
                .setDialogItemClickListener(this)
                .setClickOutSizeCancle(true)
                .setDialogCenter(false)
                .showList();

    }
    public void btn7(View view) {

        DefindDialog dialog = new DefindDialog(this);
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

    @Override
    public void dialogItemClick(Object obj, int position, int flag) {

        ItemModel data = (ItemModel) obj;
        tip(data.toString());
    }
}
