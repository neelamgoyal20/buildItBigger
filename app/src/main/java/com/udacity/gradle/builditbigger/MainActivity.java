package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.androidlib.jokes.AndroidJokeActivity;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view){
        Toast.makeText(this, "derp", Toast.LENGTH_SHORT).show();
    }

    public void getJokeFromJavaLib(View view){
//        JavaJokes jokeObj = new JavaJokes();
//        String joke = jokeObj.getJavaJokes();
//        Toast.makeText(this, joke, Toast.LENGTH_SHORT).show();
        /*Intent intent = new Intent(this, AndroidJokeActivity.class);
        intent.putExtra("joke", joke);
        startActivity(intent);*/

        EndpointsAsyncTask edpAsync = new EndpointsAsyncTask(this, "Endpoint Async");
        edpAsync.execute();
    }


}
