package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;

/**
 * Created by E01090 on 4/23/2016.
 */
public class TestAsyncResultIsNotEmpty extends AndroidTestCase {

    public void testNonEmptyAsyncResult(){
        String result = null;
        EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask(getContext().getApplicationContext(), "dummy");
        endpointsAsyncTask.execute();
        try {
            result = endpointsAsyncTask.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertNotNull(result);
    }

}
