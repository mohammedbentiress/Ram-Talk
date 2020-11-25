package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class update_username extends Fragment {
    private EditText old_username,new_username,password;
    private Button update;
    private HttpLayer layer;
    private  User user;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View root= inflater.inflate(R.layout.fragment_update_username, container, false);

        old_username= root.findViewById(R.id.old_username);
        new_username= root.findViewById(R.id.new_username);
        password= root.findViewById(R.id.up_password);
        update=root.findViewById(R.id.update);
        layer=new HttpLayer();

        user=(User)getArguments().getSerializable("current_user");


        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Call<User> result=layer.service.updateusername(old_username.getText().toString(),new_username.getText().toString(),password.getText().toString(),user.getId());
                result.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        User u=response.body();

                        if(u.isState()) {
                            Intent intent = new Intent(getContext(),homeactivity.class);
                            startActivity(intent);
                            getActivity().finish();
     }
                        else
                            CreateDialog(response.body().getMsg());
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        CreateDialog(t.getMessage());
                    }
                });
            }
        });


        return root;
    }
    public void CreateDialog(String msg) {

        new AlertDialog.Builder(getContext())
                .setMessage(msg)
                .show();

    }
}
