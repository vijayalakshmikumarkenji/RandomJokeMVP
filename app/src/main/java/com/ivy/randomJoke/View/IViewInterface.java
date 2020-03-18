package com.ivy.randomJoke.View;

import com.ivy.randomJoke.Model.Network.RandomJokeResponse;

/**
 * Interface for view component which will get called from presenter.
 */
public interface IViewInterface {
    // To show Progress when network call happening.
    void showProgress();

    //Method to hide the progress bar if incase of success or error response from api call,
    void hideProgress();

    // Method to handle the error scenario.
    void onHandleError(String errorMessage);

    // Method to get the results from api response.
    void UpdateResults(RandomJokeResponse randomJokeResponse);

}
