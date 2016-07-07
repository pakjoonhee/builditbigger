package com.example.myandroidlibrary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class jokes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokes);
    }

    public void launchLibraryActivity(View view){
        Intent myIntent = new Intent(this, jokes.class);
        startActivity(myIntent);
    }
}

