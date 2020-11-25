package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private Button login;
    private EditText username;
    private EditText password;
    private HttpLayer layer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        layer = new HttpLayer();

        login=findViewById(R.id.login);
        password=findViewById(R.id.password);
        username=findViewById(R.id.username);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String suser=username.getText().toString();
                String spswd=password.getText().toString();
                //LauncherActivity();

                Call<User> result = layer.service.login(suser,spswd);

                result.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        User user = response.body();

                        if(user.isState()){
                            LauncherActivity(user);
                        }
                        else{
                            //CreateDialog(user.getUsername()+user.getId()+user.isState());
                            CreateDialog("username or password isn't correct");
                        }
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        CreateDialog(t.getMessage());
                    }
                });


            }
        });


    }

    public void CreateDialog(String msg) {

        new AlertDialog.Builder(this)
                .setMessage(msg)
                .show();

    }

    public  void LauncherActivity(User user){
        Intent intent = new Intent(this,homeactivity.class);
        intent.putExtra("current_user",user);
        startActivity(intent);
        finish();
    }

}
