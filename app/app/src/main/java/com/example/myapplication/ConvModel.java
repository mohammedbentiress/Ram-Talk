package com.example.myapplication;

import android.widget.TextView;

public class ConvModel {
    public TextView textView;
    public TextView textView2;
    public   Item item;




    @Override
    public String toString() {
        return "RowModel{" +
                "textView=" + textView.getText() +
                ", textView2=" + textView2.getText() +
                '}';
    }
}
