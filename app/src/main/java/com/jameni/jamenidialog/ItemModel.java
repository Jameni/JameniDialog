package com.jameni.jamenidialog;

import com.jameni.jamenidialoglib.i.SelectionItemModel;

public class ItemModel implements SelectionItemModel {


    private int textColorResId;
    private int backgroundColorResId;
    private String text;
    private float textSize;


    public ItemModel(String text) {
        this.text = text;
    }

    public ItemModel(int textColorResId, String text) {
        this.textColorResId = textColorResId;
        this.text = text;
    }

    public ItemModel(int textColorResId, int backgroundColorResId, String text) {
        this.textColorResId = textColorResId;
        this.backgroundColorResId = backgroundColorResId;
        this.text = text;
    }

    public void setTextSize(float textSize) {
        this.textSize = textSize;
    }

    public void setTextColorResId(int textColorResId) {
        this.textColorResId = textColorResId;
    }


    public void setBackgroundColorResId(int backgroundColorResId) {
        this.backgroundColorResId = backgroundColorResId;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String getText() {
        return this.text;
    }

    @Override
    public float getTextSize() {
        return textSize;
    }

    @Override
    public int getTextColorResId() {
        return textColorResId;
    }

    @Override
    public int getBackgroundColorResId() {
        return backgroundColorResId;
    }

    @Override
    public String toString() {
        return "ItemModel{" +
                "text='" + text + '\'' +
                '}';
    }
}
