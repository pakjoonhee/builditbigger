package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.joonheepak.myapplication.backend.myApi.MyApi;
import com.example.myandroidlibrary.jokes;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.jokes.Joker;

import java.io.IOException;
import java.util.concurrent.ExecutionException;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    String retrievedJoke;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        Button jokeButton = (Button)root.findViewById(R.id.joke_button);
        final TextView joke = (TextView)root.findViewById(R.id.the_joke);
        final Joker myJoker = new Joker();
        jokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                joke.setText(myJoker.getJoke());
            }
        });
        Button androidJokebutton = (Button)root.findViewById(R.id.android_joke_button);
        androidJokebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchLibraryActivity();
            }
        });


        try {
            retrievedJoke = new EndpointsAsyncTask().execute(new Pair<Context, String>(getActivity(), "Manfred")).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return root;
    }

    public void launchLibraryActivity(){
        Intent myIntent = new Intent(getActivity(), jokes.class);
        myIntent.putExtra("joke", retrievedJoke);
        startActivity(myIntent);
    }


}
