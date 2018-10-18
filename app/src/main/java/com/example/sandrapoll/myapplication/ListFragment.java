package com.example.sandrapoll.myapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sandrapoll.myapplication.http.ApiClient;
import com.example.sandrapoll.myapplication.http.ApiService;
import com.example.sandrapoll.myapplication.http.CarResponce;

import org.w3c.dom.Text;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListFragment extends Fragment {
    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();

        final TextView textView = getView().findViewById(R.id.textView);

        ApiClient apiClient = new ApiClient();
        ApiService apiService = apiClient.getApiService();

        apiService.getCars().enqueue(new Callback<CarResponce>() {
            @Override
            public void onResponse(Call<CarResponce> call, Response<CarResponce> response) {
                Log.d("!!!!!!!", "Responce: " + response);
                textView.setText(response.body().toString());
            }

            @Override
            public void onFailure(Call<CarResponce> call, Throwable t) {

            }
        });
    }
}
