package com.leonardosilva.age2.api;

import com.leonardosilva.age2.model.Civilization;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface DataService {

    @GET("api/v1/civilization/{civilization}")
    Call<Civilization> getCivilization(@Path("civilization") String civilization);
}
