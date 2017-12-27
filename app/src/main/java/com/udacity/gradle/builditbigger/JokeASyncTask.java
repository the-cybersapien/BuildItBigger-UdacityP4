package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

import xyz.cybersapien.jokeviewer.JokeViewer;


/**
 * Created by ogcybersapien on 27/12/17.
 */

public class JokeASyncTask extends AsyncTask<Void, Void, String> {

    private static final String LOG_TAG = JokeASyncTask.class.getSimpleName();
    private Context context;
    private ProgressBar progressBar;
    public static final String ERROR_MESSAGE = "error";
    private static MyApi myApiService = null;

    public JokeASyncTask(Context context, ProgressBar progressBar) {
        this.context = context;
        this.progressBar = progressBar;
    }

    @Override
    protected void onPreExecute() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onPostExecute(String result) {
        if (result.equals(ERROR_MESSAGE)) {
            Toast.makeText(context, R.string.error_getting_joke, Toast.LENGTH_SHORT).show();
        } else {
            Log.d(LOG_TAG, "onPostExecute: " + result);
            Intent viewerIntent = JokeViewer.getIntent(context, result);
            context.startActivity(viewerIntent);
        }
        progressBar.setVisibility(View.GONE);
    }

    @Override
    protected String doInBackground(Void... voids) {
        if (myApiService == null) {
            // As explained https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints#2-connecting-your-android-app-to-the-backend
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> request) throws IOException {
                            request.setDisableGZipContent(true);
                        }
                    });
            myApiService = builder.build();
        }
        try {
            return myApiService.getJoke().execute().getJoke();
        } catch (IOException e) {
            Log.e(LOG_TAG, "doInBackground: ", e);
            return ERROR_MESSAGE;
        }
    }
}
