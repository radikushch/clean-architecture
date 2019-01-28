package com.radik.testing.testapplication.data.web;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkClient {

    private static final String BASE_URL = "http://demo1655807.mockable.io";

    private static final NetworkClient instance = new NetworkClient();
    private Retrofit retrofit;

    private NetworkClient() {

    }

    public static NetworkClient getInstance() {
        return instance;
    }

    private void create() {
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
        }
    }

    public AccountDataService getAccountDataService() {
        if(retrofit == null) create();
        return retrofit.create(AccountDataService.class);
    }
}
