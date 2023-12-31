package com.example.uasandroiddimazfebuari;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    public static Retrofit retrofit = null;
    public static Retrofit getClient(String baseUrl){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        if(retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl(baseUrl).client(okHttpClient).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
