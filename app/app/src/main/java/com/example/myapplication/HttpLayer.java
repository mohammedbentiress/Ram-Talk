package com.example.myapplication;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class HttpLayer {

    public Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://10.3.22.222")
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public IRequestHandler service = retrofit.create(IRequestHandler.class);

}
