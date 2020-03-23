package com.jameni.jamenidialoglib;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;

import com.jameni.jamenidialoglib.adapter.SelectionAdapter;
import com.jameni.jamenidialoglib.dialog.ListDialog;
import com.jameni.jamenidialoglib.dialog.LoadingDialog;
import com.jameni.jamenidialoglib.dialog.NormalDialog;
import com.jameni.jamenidialoglib.dialog.SelectImageDialog;
import com.jameni.jamenidialoglib.dialog.SelectSexDialog;
import com.jameni.jamenidialoglib.dialog.SingleDialog;
import com.jameni.jamenidialoglib.i.DialogItemClickListener;
import com.jameni.jamenidialoglib.i.NormalDialogListener;
import com.jameni.jamenidialoglib.i.SelectImageListener;
import com.jameni.jamenidialoglib.i.SelectSexListener;
import com.jameni.jamenidialoglib.i.SingleDialogListener;

import java.util.List;

public class JameniDialog {

//    public JameniDialog(Builder builder) {
//    }

    private JameniDialog() {

    }

//    private JameniDialog(Builder builder) {
//
//    }


    public static class Builder {

        private Context context;
        private Activity activity;
        private SingleDialogListener singleDialogListener;
        private NormalDialogListener normalDialogListener;
        private SelectImageListener selectImageListener;
        private DialogItemClickListener dialogItemClickListener;
        private SelectSexListener selectSexListener;
        private String title;
        private String msg;
        private String leftText = "取消";
        private String rightText = "确定";
        private String singleBtnText = "确定";
        private String loadingText = "正在加载中";

        private Drawable progressColor;//loading progress drawable
        private boolean isClickOutSizeCancle;
        private boolean isUnknowVisiable = true; // when  select sex, to shwo unknow sex
        private boolean isDialogCenter = true;
        private float heightScale = 0.7f; //跟屏幕的百分比  值是0~1
        private List list;
        private SelectionAdapter adapter;
        private int tag;
        private Object data;

        public Builder(Context context) {
            this.context = context;
        }


        public Builder setActivity(Activity activity) {
            this.activity = activity;
            return this;
        }

        public Builder setSingleDialogListener(SingleDialogListener singleDialogListener) {
            this.singleDialogListener = singleDialogListener;
            return this;
        }

        public Builder setNormalDialogListener(NormalDialogListener normalDialogListener) {
            this.normalDialogListener = normalDialogListener;
            return this;
        }

        public Builder setSelectImageListener(SelectImageListener selectImageListener) {
            this.selectImageListener = selectImageListener;
            return this;
        }

        public Builder setDialogItemClickListener(DialogItemClickListener dialogItemClickListener) {
            this.dialogItemClickListener = dialogItemClickListener;
            return this;
        }

        public Builder setSelectSexListener(SelectSexListener selectSexListener) {
            this.selectSexListener = selectSexListener;
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setMsg(String msg) {
            this.msg = msg;
            return this;
        }

        public Builder setLeftText(String leftText) {
            this.leftText = leftText;
            return this;
        }

        public Builder setRightText(String rightText) {
            this.rightText = rightText;
            return this;
        }

        public Builder setSingleBtnText(String singleBtnText) {
            this.singleBtnText = singleBtnText;
            return this;
        }

        public Builder setLoadingText(String loadingText) {
            this.loadingText = loadingText;
            return this;
        }

        public Builder setProgressColor(Drawable progressColor) {
            this.progressColor = progressColor;
            return this;
        }

        public Builder setClickOutSizeCancle(boolean clickOutSizeCancle) {
            isClickOutSizeCancle = clickOutSizeCancle;
            return this;
        }

        public Builder setUnknowVisiable(boolean unknowVisiable) {
            isUnknowVisiable = unknowVisiable;
            return this;
        }

        public Builder setDialogCenter(boolean dialogCenter) {
            isDialogCenter = dialogCenter;
            return this;
        }

        public Builder setHeightScale(float heightScale) {
            this.heightScale = heightScale;
            return this;
        }

        public Builder setList(List list) {
            this.list = list;
            return this;
        }

        public Builder setAdapter(SelectionAdapter adapter) {
            this.adapter = adapter;
            return this;
        }

        public Builder setTag(int tag) {
            this.tag = tag;
            return this;
        }

        public Builder setData(Object data) {
            this.data = data;
            return this;
        }

        public NormalDialog showNormalDialog() {

            NormalDialog dialog = new NormalDialog(context);
            dialog.setNormalListener(this.normalDialogListener);
            dialog.show();
            dialog.setContentText(this.msg);
            if (this.leftText != null) {
                dialog.setLeftBtnText(this.leftText);
            }
            if (this.rightText != null) {
                dialog.setRightBtnText(this.rightText);
            }
            if (this.title != null) {
                dialog.setStrTitle(this.title);
            }
            dialog.setTag(this.tag);
            dialog.setObj(this.data);
            dialog.setCanceledOnTouchOutside(this.isClickOutSizeCancle);
            return dialog;
        }

        public SingleDialog showSingleDialog() {

            SingleDialog dialog = new SingleDialog(context);
            dialog.setSingleListener(this.singleDialogListener);
            dialog.show();
            dialog.setContentText(this.msg);
            if (this.leftText != null) {
                dialog.setBtnText(this.singleBtnText);
            }
            if (this.title != null) {
                dialog.setStrTitle(this.title);
            }

            dialog.setTag(this.tag);
            dialog.setObj(this.data);
            dialog.setCanceledOnTouchOutside(this.isClickOutSizeCancle);
            return dialog;
        }

        public SelectImageDialog showSelectImageDialog() {

            if (this.activity == null) return null;
            SelectImageDialog dialog = new SelectImageDialog(this.activity, this.selectImageListener, isDialogCenter);
            dialog.show();
            dialog.setTag(this.tag);
            dialog.setObj(this.data);
            dialog.setCanceledOnTouchOutside(this.isClickOutSizeCancle);
            return dialog;
        }

        public SelectSexDialog showSexDialog() {
            if (this.activity == null) return null;
            SelectSexDialog dialog = new SelectSexDialog(this.activity, this.selectSexListener, isDialogCenter);
            dialog.show();
            dialog.setTag(this.tag);
            dialog.setObj(this.data);
            dialog.setCanceledOnTouchOutside(this.isClickOutSizeCancle);
            return dialog;
        }

        public ListDialog showList() {

            if (this.activity == null) return null;
            ListDialog dialog = new ListDialog(this.activity, this.list, this.dialogItemClickListener, this.isDialogCenter);
            dialog.setHeightScale(this.heightScale);
            dialog.show();
            dialog.setTag(this.tag);
            dialog.setObj(this.data);
            dialog.setCanceledOnTouchOutside(this.isClickOutSizeCancle);

            return dialog;

        }

        public LoadingDialog showLoadingDialog() {

            LoadingDialog dialog = new LoadingDialog(this.context);
            dialog.setCanceledOnTouchOutside(isClickOutSizeCancle);
            dialog.show();
            dialog.setMsg(this.loadingText);
            dialog.setProgressColor(this.progressColor);

            return dialog;

        }


    }


}
