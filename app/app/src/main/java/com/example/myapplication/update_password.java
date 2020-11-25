package com.example.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class update_password extends Fragment {

    private EditText username,old_password,new_password;
    private Button update;
    private HttpLayer layer;
    private  User user;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root= inflater.inflate(R.layout.fragment_update_password, container, false);

        username= root.findViewById(R.id.up_username);
        new_password= root.findViewById(R.id.new_password);
        old_password= root.findViewById(R.id.old_password);
        update=root.findViewById(R.id.update_2);
        layer=new HttpLayer();

        user=(User)getArguments().getSerializable("current_user");

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<User> resultat= layer.service.updatepassword(username.getText().toString(),old_password.getText().toString(),new_password.getText().toString(),user.getId());
                resultat.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        User u=response.body();
                        if(u.isState()) {
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
