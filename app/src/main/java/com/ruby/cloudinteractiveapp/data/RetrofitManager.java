package com.ruby.cloudinteractiveapp.data;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitManager {

    private static RetrofitManager mInstance;
    private ApiService mApiService;

    private RetrofitManager(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mApiService = retrofit.create(ApiService.class);

    }

    public static RetrofitManager getInstance(){
        if(mInstance == null){
            synchronized (RetrofitManager.class){
                if(mInstance == null) {
                    mInstance = new RetrofitManager();
                }
            }
        }
        return mInstance;
    }

    public ApiService getApi(){
        return mApiService;
    }
}
