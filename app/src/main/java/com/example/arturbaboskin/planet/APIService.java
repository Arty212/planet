package com.example.arturbaboskin.planet;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {

    @GET("get_planets.php")
    Call<List<Planet>> getPlanets();
}
