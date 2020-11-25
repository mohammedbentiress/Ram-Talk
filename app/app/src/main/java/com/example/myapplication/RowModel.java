package com.example.myapplication;

import android.widget.Button;
import android.widget.TextView;

public class RowModel {

    public TextView textView;
    public TextView textView2;
    public Button button;

    public   Item item;



    @Override
    public String toString() {
        return "RowModel{" +
                "textView=" + textView.getText() +
                "textView2=" + textView.getText() +
                '}';
    }
}
