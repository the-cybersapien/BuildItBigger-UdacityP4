package com.udacity.gradle.builditbigger;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    private static final String LOG_TAG = MainFragment.class.getSimpleName();

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        final ProgressBar progressBar = rootView.findViewById(R.id.progress_view);
        Button jokesButton = rootView.findViewById(R.id.joke_button);
        Log.d(LOG_TAG, "onCreateView: ");
        jokesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JokeASyncTask jokeTask = new JokeASyncTask(getContext(), progressBar);
                Log.d(LOG_TAG, "onClick: ");
                jokeTask.execute();
            }
        });
        AdView adView = rootView.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        adView.loadAd(adRequest);
        return rootView;
    }

}
