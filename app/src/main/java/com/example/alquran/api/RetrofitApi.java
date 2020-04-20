package com.example.alquran.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Harri Pratomo on 20/04/2020.
 * <p>
 * harrypratomo135@gmail.com
 */
public class RetrofitApi {

    public static final String BASE_URL = " https://al-quran-8d642.firebaseio.com/";
    public static Retrofit retrofit = null;

    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
