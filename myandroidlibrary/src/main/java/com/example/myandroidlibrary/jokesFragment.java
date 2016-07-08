package com.example.myandroidlibrary;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jokes.Joker;

/**
 * Created by joonheepak on 7/6/16.
 */
public class jokesFragment extends Fragment{

    public jokesFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_image, container, false);
        Bundle bundle = getActivity().getIntent().getExtras();
        String joke = bundle.getString("joke");
        Joker jokeIntent = new Joker();
        TextView javaJoke = (TextView)root.findViewById(R.id.java_joke);
        javaJoke.setText(joke);
        return root;

    }
}
