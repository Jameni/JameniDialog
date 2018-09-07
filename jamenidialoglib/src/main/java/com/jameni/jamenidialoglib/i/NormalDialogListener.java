package com.jameni.jamenidialoglib.i;

public interface NormalDialogListener {
    /**
     * 确定按钮方法 传入一个动作标记，标记动作的功能
     */
    public void onLeftClick(Object obj, int actionTag);
    /**
     * 取消按钮方法
     */
    public void onRightClick(Object obj, int actionTag);

}
