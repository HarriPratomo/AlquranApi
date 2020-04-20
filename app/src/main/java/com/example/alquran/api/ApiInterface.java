package com.example.alquran.api;

import com.example.alquran.model.ResponseSurat;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Harri Pratomo on 20/04/2020.
 * <p>
 * harrypratomo135@gmail.com
 */
public interface ApiInterface {
    @GET("/data.json")
    Call<List<ResponseSurat>> getSurat();
}
