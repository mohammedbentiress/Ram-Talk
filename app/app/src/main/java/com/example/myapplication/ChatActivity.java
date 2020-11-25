package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChatActivity extends AppCompatActivity {

    private int id_emetteur,id_recepteur;
    private HttpLayer layer;
    private ImageButton send;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        layer=new HttpLayer();
        send=findViewById(R.id.send);
        textView=findViewById(R.id.msg_text);

        Intent intent=getIntent();
        id_emetteur=(int)intent.getExtras().get("id_emetteur");
        id_recepteur=(int)intent.getExtras().get("id_recepteur");
        String str=(String)intent.getExtras() .get("nom_prenom");


        setTitle(str);
        final List<Messages> list = new ArrayList<>();
        final ListView lv=findViewById(R.id.messages_view);
        final List<MessageModel> rows = new ArrayList<>();
        Call<List<Messages>> result= layer.service.affichagemessages(id_emetteur,id_recepteur);
        result.enqueue(new Callback<List<Messages>>() {
            @Override
            public void onResponse(Call<List<Messages>> call, Response<List<Messages>> response) {
                List<Messages> lm=response.body();
                list.addAll(lm);
                for(Messages messages:list){
                    MessageModel messageModel = new MessageModel();
                    messageModel.textViewleft= CreateTextView();
                    messageModel.textViewright= CreateTextView();
                    messageModel.rightRow=CreateTablerow();
                    messageModel.leftRow=CreateTablerow();
                    if(messages.getSide().equals("right")) {
                        messageModel.leftRow.setVisibility(View.GONE);
                        messageModel.rightRow.setVisibility(View.VISIBLE);
                        messageModel.textViewright.setText(messages.getText());
                    }
                    if(messages.getSide().equals("left")){
                        messageModel.rightRow.setVisibility(View.GONE);
                        messageModel.leftRow.setVisibility(View.VISIBLE);
                        messageModel.textViewleft.setText(messages.getText());
                    }

                    messageModel.message=messages;
                    rows.add(messageModel);
                }
                MessageAdapter adapter = CreateMessageAdapter(rows);
                lv.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Messages>> call, Throwable t) {
                CreateDialog("ghyh");

            }
        });
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msg=textView.getText().toString();
                Call<Boolean> resultat=layer.service.Envoyer(id_emetteur,id_recepteur,msg);
                resultat.enqueue(new Callback<Boolean>() {
                    @Override
                    public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                    }

                    @Override
                    public void onFailure(Call<Boolean> call, Throwable t) {
                        CreateDialog(t.getMessage());
                    }
                });
                MessageModel messageModel = new MessageModel();
                messageModel.textViewleft= CreateTextView();
                messageModel.textViewright= CreateTextView();
                messageModel.rightRow=CreateTablerow();
                messageModel.leftRow=CreateTablerow();
                messageModel.leftRow.setVisibility(View.GONE);
                messageModel.rightRow.setVisibility(View.VISIBLE);
                messageModel.textViewright.setText(msg);
                rows.add(messageModel);
                MessageAdapter adapter = CreateMessageAdapter(rows);
                lv.setAdapter(adapter);
                textView.setText("");
            }
        });

    }
    public void CreateDialog(String msg) {

        new AlertDialog.Builder(this)
                .setMessage(msg)
                .show();
    }
    public MessageAdapter CreateMessageAdapter(List<MessageModel> rows){
        return  new MessageAdapter(this,R.layout.message_row,rows);
    }
    public  TextView CreateTextView(){
        return new TextView(this);
    }
    public TableRow CreateTablerow(){
        return new TableRow(this);
    }
}
