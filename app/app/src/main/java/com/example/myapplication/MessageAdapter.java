package com.example.myapplication;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.RequiresApi;

import java.util.List;

public class MessageAdapter extends ArrayAdapter<MessageModel> {

    private MessageModel row,line;


    public MessageAdapter(Context context, int resource, List<MessageModel> items) {
        super(context, resource, items);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public View getView(int position, View convertView, ViewGroup parent) {



        if (convertView == null) {
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.message_row,parent,false);
        }

        row =(MessageModel) convertView.getTag();

        if(row==null){
            row=new MessageModel();
            row.textViewleft=convertView.findViewById(R.id.message_left);
            row.textViewright=convertView.findViewById(R.id.message_right);
            row.leftRow=convertView.findViewById(R.id.row_left);
            row.rightRow=convertView.findViewById(R.id.row_right);
        }
        line= getItem(position);
        row.textViewleft.setText(line.textViewleft.getText());
        row.textViewright.setText(line.textViewright.getText());
        row.leftRow.setVisibility(line.leftRow.getVisibility());
        row.rightRow.setVisibility(line.rightRow.getVisibility());
        row.message=line.message;


        return convertView;
    }
}
