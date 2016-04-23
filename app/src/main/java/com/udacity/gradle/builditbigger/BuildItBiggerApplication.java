package com.udacity.gradle.builditbigger;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

/**
 * Created by e01090 on 4/21/2016.
 */
public class BuildItBiggerApplication extends Application {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
