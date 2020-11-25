package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

public class ConAdapter extends ArrayAdapter<ConvModel> {
    private ConvModel row,line;


    public ConAdapter(Context context, int resource, List<ConvModel> items) {
        super(context, resource, items);
    }

    public View getView(int position, View convertView, ViewGroup parent) {



        if (convertView == null) {
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.conv_row,parent,false);
        }

        row =(ConvModel) convertView.getTag();

        if(row==null){
            row=new ConvModel();
            row.textView=convertView.findViewById(R.id.conv_title);
            row.textView2=convertView.findViewById(R.id.conv_subtitle);
        }
        line= getItem(position);
        row.textView.setText(line.textView.getText());
        row.textView2.setText(line.textView2.getText());
        row.item=line.item;


        return convertView;
    }
}
