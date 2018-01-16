package com.example.arturbaboskin.planet;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public final class APIHelper {

    private static final String HOST = "http://region39.info/";

    interface OnPlanetLoad{
        void success(ArrayList<Planet> result);
        void error();
    }

    private static APIHelper instance;
    private APIService apiService;

    private APIHelper() {}

    private APIService getApiService(){
        if (apiService == null){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(HOST)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            apiService = retrofit.create(APIService.class);
        }
        return apiService;
    }

    public static APIHelper getInstance(){
        if (instance==null)
            instance = new APIHelper();
        return instance;
    }

    public void loadPlanets(final OnPlanetLoad callback){
        Call<List<Planet>> call = getApiService().getPlanets();
        call.enqueue(new Callback<List<Planet>>() {
            @Override
            public void onResponse(Call<List<Planet>> call, Response<List<Planet>> response) {
                callback.success(new ArrayList<>(response.body()));
            }

            @Override
            public void onFailure(Call<List<Planet>> call, Throwable t) {
                callback.error();
            }
        });
    }



}
