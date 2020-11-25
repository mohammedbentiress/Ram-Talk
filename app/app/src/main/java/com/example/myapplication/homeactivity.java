package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.example.myapplication.ui.main.SectionsPagerAdapter;
import com.google.android.material.tabs.TabLayout;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class homeactivity extends AppCompatActivity {

    private TextView title;
    private androidx.appcompat.widget.Toolbar toolbar;
    private HttpLayer layer;
    private User user;
    private  Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homeactivity);
        Intent b= getIntent();
        user=(User)b.getSerializableExtra("current_user");
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager(),user);
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        layer = new HttpLayer();
        toolbar =  findViewById(R.id.toolbar2);


        Call<String> res=layer.service.getusername(user.getId());
        res.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {

                toolbar.setTitle(response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });
        toolbar.inflateMenu(R.menu.menu);





        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int i=item.getItemId();
                switch (i){
                    case R.id.username:
                        LauncherActivity(user,"up_username",Update_account.class);
                        break;
                    case R.id.pwd:
                        LauncherActivity(user,"up_password",Update_account.class);
                        break;
                    case R.id.deco:

                        Call<String> result= layer.service.deco(user.getId());
                        result.enqueue(new Callback<String>() {
                            @Override
                            public void onResponse(Call<String> call, Response<String> response) {
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
        });

    }

    public void LauncherActivity(String[] key,String[] value,Class cl){
        Intent intent = new Intent(this,cl);
        for(int i=0;i<key.length;i++){
            intent.putExtra(key[i],value[i]);
        }
        startActivity(intent);
        finish();
    }

    public  void LauncherActivity(User user, String str, Class cl){
        Intent intent = new Intent(this,cl);
        intent.putExtra("current_user",user);
        intent.putExtra("fragment",str);
        startActivity(intent);
    }

    public void CreateDialog(String msg) {
        new AlertDialog.Builder(this)
                .setMessage(msg)
                .show();
    }
    public void LauncherFragment(Fragment fragment){

        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.view_pager,fragment);
        ft.commit();

    }
    public void onBackPressed(){
        moveTaskToBack(true);
    }
}