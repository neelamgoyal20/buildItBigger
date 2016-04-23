package com.udacity.gradle.builditbigger;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.util.Pair;
import android.widget.Toast;

import com.androidlib.jokes.AndroidJokeActivity;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.jokeapp.backend.myApi.MyApi;

import java.io.IOException;

/**
 * Created by e01090 on 4/20/2016.
 */
public class EndpointsAsyncTask extends AsyncTask<Void, Void, String> {
    private static MyApi myApiService = null;
    private Context mContext;
    private ProgressDialog mProgressDialog;
    private String mProvidedText;

    public EndpointsAsyncTask(Context ctx, String providedText){
        mContext = ctx;
        mProvidedText = providedText;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
//        showProgressDialog();
    }

    @Override
    protected String doInBackground(Void... params) {
        if (myApiService == null) {
            /*MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });*/

            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://nanodegreeproject-1288.appspot.com/_ah/api/");
            myApiService = builder.build();
        }

        try {
            return myApiService.tellAJoke(mProvidedText).execute().getJoke();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        if (mProgressDialog != null) {
            if (mProgressDialog.isShowing()) {
                mProgressDialog.dismiss();
            }
            mProgressDialog = null;
        }
//        Toast.makeText(mContext, result, Toast.LENGTH_LONG).show();
        Intent intent = new Intent(mContext, AndroidJokeActivity.class);
        intent.putExtra("joke", result);
        mContext.startActivity(intent);
    }

    private void showProgressDialog(){
        if (mProgressDialog != null) {
            if (mProgressDialog.isShowing()) {
                mProgressDialog.dismiss();
            }
            mProgressDialog = null;
        }

        if(mContext!=null){
            mProgressDialog = ProgressDialog.show(mContext, "", "Fetching");
            mProgressDialog.setCancelable(false);
            mProgressDialog.setCanceledOnTouchOutside(false);
        } else {
            Log.e("EndpointAsync", "mContext is null");
        }
    }
}