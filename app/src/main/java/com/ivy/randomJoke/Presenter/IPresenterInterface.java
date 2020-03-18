package com.ivy.randomJoke.Presenter;

/**
 * Presenter interface which will communicate to model class and
 * get the results from model and give back to view.
 */
public interface IPresenterInterface {

    // Method to call the api which will get invoked from view.
    public void getRandomJoke();
}
