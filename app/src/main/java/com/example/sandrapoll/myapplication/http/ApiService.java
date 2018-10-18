package com.example.sandrapoll.myapplication.http;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("http://www.mocky.io/v2/5bc78dc5320000053b0b08db")
    Call<CarResponce> getCars();
}
