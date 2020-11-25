package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Update_account extends AppCompatActivity {

    private HttpLayer layer;
    private  User user;
    private  Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_account);
        layer = new HttpLayer();



        Intent i=getIntent();
        user=(User)i.getSerializableExtra("current_user");
        String str=i.getStringExtra("fragment");

        bundle =new Bundle();
        bundle.putSerializable("current_user",user);

        if(str.equals("up_username")){
            update_username frag1= new update_username();
            frag1.setArguments(bundle);
            LauncherFragment(frag1);
        }
        else if(str.equals("up_password")) {
            update_password frag2=new update_password();
            frag2.setArguments(bundle);
            LauncherFragment(frag2);

        }
    setTitle(user.getUsername());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater =  getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId()) {

            case R.id.username:
                update_username frag1= new update_username();
                frag1.setArguments(bundle);
                LauncherFragment(frag1);
                break;
            case R.id.pwd:
                update_password frag2=new update_password();
                frag2.setArguments(bundle);
                LauncherFragment(frag2);
                break;
            case R.id.deco:

                Call<String> result= layer.service.deco(user.getId());
                result.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        String str=response.body();
                        CreateDialog("succes:"+response.message());
                        LauncherActivity(new String[]{},new String[]{},MainActivity.class );
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        CreateDialog(t.getMessage());
                    }
                });

                break;
            default: break;

        }
    return true;
    }

    public void LauncherFragment(Fragment fragment){

        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.fragment_container,fragment);
        ft.commit();

    }

    public void LauncherActivity(String[] key,String[] value,Class cl){
        Intent intent = new Intent(this,cl);
        for(int i=0;i<key.length;i++){
            intent.putExtra(key[i],value[i]);
        }
        startActivity(intent);
        finish();
    }

    public void CreateDialog(String msg) {

        new AlertDialog.Builder(this)
                .setMessage(msg)
                .show();

    }

}
