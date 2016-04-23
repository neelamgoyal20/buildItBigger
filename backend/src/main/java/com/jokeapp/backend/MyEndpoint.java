/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.jokeapp.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import java.util.Random;

import javax.inject.Named;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.jokeapp.com",
                ownerName = "backend.jokeapp.com",
                packagePath = ""
        )
)
public class MyEndpoint {

    /**
     * A simple endpoint method that takes a name and returns a joke
     */
    @ApiMethod(name = "tellAJoke")
    public MyBean tellAJoke(@Named("name") String name) {
        MyBean response = new MyBean();
        String finalJoke ="";
        if (name!= null && name.length()>0) {
            finalJoke = "Hi " + name + "\n";
        }
        com.library.jokes.JavaJokes jokeObj = new com.library.jokes.JavaJokes();
        String joke = jokeObj.getJavaJokes();
        finalJoke = finalJoke + joke;
        response.setJoke(finalJoke);
        return response;
    }



}
