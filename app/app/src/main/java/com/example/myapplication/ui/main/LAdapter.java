package com.example.myapplication.ui.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.RowModel;

import java.util.List;

public class LAdapter extends ArrayAdapter<RowModel> {

    private RowModel row,line;
    public LAdapter(Context context, int resource, List<RowModel> items) {
        super(context, resource, items);
    }

    public View getView(int position, View convertView, ViewGroup parent) {



        if (convertView == null) {
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.row,parent,false);
        }

        row =(RowModel)convertView.getTag();

        if(row==null){
            row=new RowModel();
            row.textView=convertView.findViewById(R.id.titlehhh);
            row.button=convertView.findViewById(R.id.detalis);
            row.textView2=convertView.findViewById(R.id.sub_title);
        }
        line= getItem(position);
        row.textView.setText(line.textView.getText());
        row.textView2.setText(line.textView2.getText());
        row.item=line.item;

        Button b = convertView.findViewById(R.id.detalis);
        final TextView v=convertView.findViewById(R.id.sub_title);
        final String i=line.item.getSubtitle();

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String test=((Button)view).getText().toString();
                if(test.equals("+")){
                    v.setVisibility(View.VISIBLE);
                    v.setText(i);
                    ((Button)view).setText("-");
                }
                else if(test.equals("-")){
                    v.setVisibility(View.GONE);
                    v.setText("");
                    ((Button)view).setText("+");
                }
            }
        });
        return convertView;
    }

}

