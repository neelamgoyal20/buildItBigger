package com.androidlib.jokes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AndroidJokeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_joke);
        Bundle bundle = getIntent().getExtras();
        TextView tvJoke = (TextView)findViewById(R.id.jokeText);
        if (bundle!=null){
            String joke = bundle.getString("joke");
            tvJoke.setText("Joke: \n" + joke);
        } else {
            tvJoke.setText(R.string.sorry_no_joke);
        }
    }
}
