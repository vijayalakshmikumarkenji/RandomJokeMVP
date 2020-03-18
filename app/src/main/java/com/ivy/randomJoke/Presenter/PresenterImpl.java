package com.ivy.randomJoke.Presenter;

import com.ivy.randomJoke.Model.ApiInterface;
import com.ivy.randomJoke.Model.Network.RandomJokeResponse;
import com.ivy.randomJoke.Model.RetrofitInstance;
import com.ivy.randomJoke.View.IViewInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Presenter implementation classs to communicate between view and model.
 */
public class PresenterImpl implements IPresenterInterface {

    private IViewInterface mIviewInterface;
    ApiInterface mApiInterface;

    public PresenterImpl(IViewInterface iViewInterface) {
        this.mIviewInterface = iViewInterface;
    }

    @Override
    public void getRandomJoke() {
        mApiInterface = RetrofitInstance.getmRetrofitInstance().getRetrofit().create(ApiInterface.class);
        mIviewInterface.showProgress();
        Call<RandomJokeResponse> randomJokeResponseCall = mApiInterface.getRandomJokes();

        randomJokeResponseCall.enqueue(new Callback<RandomJokeResponse>() {
            @Override
            public void onFailure(Call<RandomJokeResponse> call, Throwable t) {
                mIviewInterface.hideProgress();
                mIviewInterface.onHandleError(t.getMessage());
            }

            @Override
            public void onResponse(Call<RandomJokeResponse> call, Response<RandomJokeResponse> response) {
                mIviewInterface.hideProgress();
                mIviewInterface.UpdateResults(response.body());
            }
        });


    }
}
