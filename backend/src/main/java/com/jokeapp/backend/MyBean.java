package com.jokeapp.backend;

/**
 * The object model for the data we are sending through endpoints
 */
public class MyBean {

    private String mJoke;

    public String getJoke() {
        return mJoke;
    }

    public void setJoke(String joke) {
        mJoke = joke;
    }
}