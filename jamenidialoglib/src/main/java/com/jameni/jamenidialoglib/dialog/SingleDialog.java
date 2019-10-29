package com.jameni.jamenidialoglib.dialog;

import android.content.Context;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.jameni.jamenidialoglib.R;


/**
 * @author Jameni
 * @Description: 封装了DILOG
 */
public class SingleDialog extends JameniBaseDialog implements OnClickListener {

    public SingleDialog(Context context) {
        super(context);
    }

    private TextView tvContent, btn, tvTitle;
    private String strContent = "", strBtn, strTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View view = LayoutInflater.from(context).inflate(R.layout.view_jameni_single_dialog, null);
        setContentView(view);
        tvContent = findViewById(R.id.message);
        tvTitle = findViewById(R.id.title);
        tvContent.setText(Html.fromHtml(strContent));
        btn = findViewById(R.id.btn);

        if (!isEmpty(strBtn)) {
            btn.setText(strBtn);
        }

        btn.setOnClickListener(this);
        if (!isEmpty(strTitle)) {
            tvTitle.setText(strTitle);
            tvTitle.setVisibility(View.VISIBLE);
        } else {
            tvTitle.setVisibility(View.GONE);
        }
    }

    @Override
    public void onClick(View v) {

        if (!isNull(singleListener)) {
            singleListener.onSingleOk(obj, Tag);
        }
        dismiss();

    }

    public void setContentText(String str) {
        this.strContent = str;
        if (tvContent != null && !isNull(str)) {
            tvContent.setText(strContent);
        }
    }

    public void setBtnText(String str) {
        this.strBtn = str;
        if (btn != null && !isNull(str)) {
            btn.setText(strBtn);
        }
    }

    public void setStrTitle(String str) {
        this.strTitle = str;
        if (tvTitle != null && !isNull(str)) {
            tvTitle.setText(str);
            tvTitle.setVisibility(View.VISIBLE);
        }
    }

    public TextView getTvContent() {
        return tvContent;
    }

    public TextView getBtn() {
        return btn;
    }

    public TextView getTvTitle() {
        return tvTitle;
    }
}

