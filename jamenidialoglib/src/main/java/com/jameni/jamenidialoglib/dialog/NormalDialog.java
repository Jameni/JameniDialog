package com.jameni.jamenidialoglib.dialog;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.jameni.jamenidialoglib.R;

/**
 * 两个按钮的对话框
 */
public class NormalDialog extends JameniBaseDialog implements View.OnClickListener {

    public NormalDialog(Context context) {
        super(context);
    }

    //	private Context context;
    private TextView tvContent, tvLeft, tvRight, tvTitle;
    private String strContent, strLeft, strRight, strTitle;

    private int dimen_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /**
         * 把tv_contentText宽度变为match_parent就不用动态设置dialog宽度
         * 如果tv_contentText宽度属性是wrap_content，如果文本不够长，则界面宽度会缩短，则要动态设置dialog宽度
         */
        View view = LayoutInflater.from(context).inflate(R.layout.view_normal_dialog, null);
        setContentView(view);
        tvContent = findViewById(R.id.message);
        tvTitle = findViewById(R.id.title);


        tvLeft = findViewById(R.id.no);
        tvRight = findViewById(R.id.yes);

        if (!isEmpty(strLeft)) {
            tvLeft.setText(strLeft);
        } else {
            tvLeft.setText("取消");
        }
        if (!isEmpty(strRight)) {
            tvRight.setText(strRight);
        } else {
            tvRight.setText("确定");
        }

        if (!isEmpty(strTitle)) {
            tvTitle.setText(strTitle);
            tvTitle.setVisibility(View.VISIBLE);
        } else {
            tvTitle.setVisibility(View.GONE);
        }

        tvContent.setText(isEmpty(strContent) ? "" : strContent);
        if (dimen_content > 0) {
            tvContent.setTextSize(dimen_content);
        }


        tvLeft.setOnClickListener(this);
        tvRight.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (!isNull(listener)) {

            if (v.getId() == R.id.no) {
                //左边
                listener.onLeftClick(obj, Tag);
            } else if (v.getId() == R.id.yes) {
                //右边
                listener.onRightClick(obj, Tag);
            }
        }

        dismiss();// 将当前对话框关闭
    }

    public void setContentText(String str) {
        this.strContent = str;
        if (!isNull(tvContent)) {
            tvContent.setText(strContent);
        }
    }

    public void setLeftBtnText(String str) {
        this.strLeft = str;
        if (!isNull(tvLeft)) {
            tvLeft.setText(strLeft);
        }
    }

    public void setRightBtnText(String str) {
        this.strRight = str;
        if (tvRight != null) {
            tvRight.setText(strRight);
        }
    }

    public void setStrTitle(String str) {
        this.strTitle = str;
        if (tvTitle != null) {
            tvTitle.setText(str);
            tvTitle.setVisibility(View.VISIBLE);
        }
    }

    public void setContentTextAlige_Left() {
        if (tvContent != null) {
            tvContent.setGravity(Gravity.LEFT | Gravity.CENTER_VERTICAL);
        }
    }

    public void setContentTextAlige(int gravity) {
        if (tvContent != null) {
            tvContent.setGravity(gravity);
        }
    }


    public void setContentTextSize_small() {
        setContentTextSize(12);
    }

    public void setContentTextSize_big() {
        setContentTextSize(16);
    }

    public void setContentTextSize_tiny() {
        setContentTextSize(10);
    }

    public void setContentTextSize(int dimen) {
        this.dimen_content = dimen;
        if (tvContent != null) {
            tvContent.setTextSize(dimen);
        }
    }



}
