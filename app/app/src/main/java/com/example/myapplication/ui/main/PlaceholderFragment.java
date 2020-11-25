package com.example.myapplication.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.myapplication.ChatActivity;
import com.example.myapplication.ConAdapter;
import com.example.myapplication.Contact;
import com.example.myapplication.ConvModel;
import com.example.myapplication.Conversation;
import com.example.myapplication.HttpLayer;
import com.example.myapplication.Item;
import com.example.myapplication.R;
import com.example.myapplication.RowModel;
import com.example.myapplication.Service;
import com.example.myapplication.User;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";
    private HttpLayer layer;
    private PageViewModel pageViewModel;
    private User user;
    List<Conversation> lconv;

    public static PlaceholderFragment newInstance(int index) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    public static PlaceholderFragment newInstance(int index, Bundle bundle) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        pageViewModel.setIndex(index);


    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_homeactivity, container, false);

        final ListView lv = (ListView) root.findViewById(R.id.lv);

        final List<Item> list = new ArrayList<>();
        final List<RowModel> rows = new ArrayList<>();
        final List<ConvModel> convs=new ArrayList<>();
        layer =new HttpLayer();
        switch (pageViewModel.getIndex()) {

            case 0:
                user=(User)getArguments().getSerializable("current_user");
                Call<List<Conversation>>  res=layer.service.getConversation(user.getId());
                res.enqueue(new Callback<List<Conversation>>() {
                    @Override
                    public void onResponse(Call<List<Conversation>> call, Response<List<Conversation>> response) {
                         lconv=response.body();
                        list.addAll(lconv);

                        for(Item i:list){
                            Log.i("id:",i.getId()+"");
                            i.setTitle();
                            i.setSubtitle();
                            ConvModel convModel=new ConvModel();
                            convModel.textView=new TextView(getContext());
                            convModel.textView2=new TextView(getContext());
                            convModel.textView.setText(i.getTitle());
                            convModel.textView2.setText(i.getSubtitle());
                            convModel.item=i;
                            convs.add(convModel);
                        }

                        ConAdapter adapter = new ConAdapter(getContext(),R.layout.conv_row,convs);
                        lv.setAdapter(adapter);
                        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                               LauncherActivity(lconv.get(i).getRecepteur().getNom()+" "+lconv.get(i).getRecepteur().getPrenom(),lconv.get(i).getEmetteur().getId(),lconv.get(i).getRecepteur().getId());
                            }
                        });
                    }

                    @Override
                    public void onFailure(Call<List<Conversation>> call, Throwable t) {
                        CreateDialog(t.getMessage());
                    }
                });
                pageViewModel.setData(list);
                break;
            case 1:
                Call<List<Service>> result=layer.service.affichageservice();
                result.enqueue(new Callback<List<Service>>() {
                    @Override
                    public void onResponse(Call<List<Service>> call, Response<List<Service>> response) {
                        List<Service> ls=response.body();
                        list.addAll(ls);
                        for(Item i : list) {

                            i.setTitle();
                            i.setSubtitle();
                            RowModel rowModel = new RowModel();
                            rowModel.textView = new TextView(getContext());
                            rowModel.textView2= new TextView(getContext());
                            rowModel.button= new Button(getContext());
                            rowModel.textView.setText(i.getTitle());
                            rowModel.textView2.setText("");
                            rowModel.item=i;
                            rows.add(rowModel);
                        }
                        LAdapter adapter = new LAdapter(getContext(),R.layout.row,rows);
                        lv.setAdapter(adapter);
                    }
                    @Override
                    public void onFailure(Call<List<Service>> call, Throwable t) {
                        CreateDialog(t.getMessage());
                    }
                });
                pageViewModel.setData(list);
                break;
            case 2:
                user=(User)getArguments().getSerializable("current_user");
                Call<List<Contact>> resultat=layer.service.affichagecontact(user.getId());
                resultat.enqueue(new Callback<List<Contact>>() {
                    @Override
                    public void onResponse(Call<List<Contact>> call, Response<List<Contact>> response) {
                        List<Contact> lc=response.body();
                        list.addAll(lc);
                        for(Item i : list) {
                            i.setTitle();
                            i.setSubtitle();
                            RowModel rowModel = new RowModel();
                            rowModel.textView = new TextView(getContext());
                            rowModel.textView2= new TextView(getContext());
                            rowModel.button= new Button(getContext());
                            rowModel.textView.setText(i.getTitle());
                            rowModel.textView2.setText("");
                            rowModel.item=i;
                            rows.add(rowModel);
                        }
                            LAdapter adapter = new LAdapter(getContext(),R.layout.row,rows);
                            lv.setAdapter(adapter);


                    }
                    @Override
                    public void onFailure(Call<List<Contact>> call, Throwable t) {
                        CreateDialog(t.getMessage());
                    }
                });
                pageViewModel.setData(list);
                break;
            default: break;
        }



        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });

        return root;
    }

    public void click(View v) {

    }

    public void setSubtitle(String str,TextView textView){
        textView.setText(str);
    }

    public void CreateDialog(String msg) {

        new AlertDialog.Builder(getContext())
                .setMessage(msg)
                .show();

    }
    public  void LauncherActivity(String str,int id1,int id2){
        Intent intent = new Intent(getContext(), ChatActivity.class);
        intent.putExtra("id_emetteur",id1);
        intent.putExtra("id_recepteur",id2);
        intent.putExtra("nom_prenom",str);
        startActivity(intent);
    }

}