package com.jameni.jamenidialoglib.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;

import com.jameni.jamenidialoglib.R;
import com.jameni.jamenidialoglib.i.NormalDialogListener;
import com.jameni.jamenidialoglib.i.SingleDialogListener;

public class JameniBaseDialog extends Dialog {

    protected Context context;
    protected NormalDialogListener listener;
    protected SingleDialogListener singleListener;
    protected int Tag;

    public JameniBaseDialog(Context context) {
        super(context, R.style.JameniDialogStyle);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);
    }

    public void setTag ( int tag){
        Tag = tag;
    }

    public void setNormalListener(NormalDialogListener listener) {
        this.listener = listener;
    }

    public void setSingleListener(SingleDialogListener singleListener) {
        this.singleListener = singleListener;
    }
}
