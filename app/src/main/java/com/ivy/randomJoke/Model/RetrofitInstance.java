package com.ivy.randomJoke.Model;

import com.ivy.randomJoke.StringConstants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Retrofit instance class to define all retrofit related components.
 */
public class RetrofitInstance {

    private static RetrofitInstance mRetrofitInstance;
    private Retrofit mRetrofit;

    private RetrofitInstance() {
    }

    /**
     * Method to get the retrofit class instance.
     *
     * @return RetrofitInstance mRetrofitInstance
     */
    public static synchronized RetrofitInstance getmRetrofitInstance() {

        if (mRetrofitInstance == null) {

            mRetrofitInstance = new RetrofitInstance();

        }
        return mRetrofitInstance;
    }


    /**
     * Method to return Retrofit 2 instance.
     *
     * @return Retrofit mRetrofit
     */
    public Retrofit getRetrofit() {

        mRetrofit = new retrofit2.Retrofit.Builder().baseUrl(StringConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();

        return mRetrofit;
    }
}
