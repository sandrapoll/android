package com.example.sandrapoll.myapplication.http;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private ApiService apiService;

    public ApiClient () {
        OkHttpClient httpClient = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient)
                .baseUrl("http://www.mocky.io/")
                .build();

        apiService = retrofit.create(ApiService.class);
    }
    public ApiService getApiService() {
        return apiService;
    }
}
