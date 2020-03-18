package com.ivy.randomJoke.Model;

import com.ivy.randomJoke.Model.Network.RandomJokeResponse;

import retrofit2.Call;
import retrofit2.http.GET;


/**
 * Api interface to declare network api calls components.
 */
public interface ApiInterface {

    @GET("/random_joke")
    public Call<RandomJokeResponse> getRandomJokes();
}
