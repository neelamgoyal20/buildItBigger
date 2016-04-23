package com.library.jokes;

import java.util.Random;

public class JavaJokes {
    public String getJavaJokes(){
        return generateJoke();
    }

    private String generateJoke(){
        String randomJoke = null;
        Random random = new Random();
        String[] jokeList = new String[5];
        jokeList[0] = "Joke1";
        jokeList[1] = "Joke2";
        jokeList[2] = "Joke3";
        jokeList[3] = "Joke4";
        jokeList[4] = "Joke5";

        randomJoke = jokeList[random.nextInt(jokeList.length)];
        return randomJoke;
    }
}
