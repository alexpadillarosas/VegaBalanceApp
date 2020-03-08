package com.example.vegabalanceapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.vegabalanceapp.adapters.PlateRecyclerViewAdapter;
import com.example.vegabalanceapp.models.Plate;

import java.util.ArrayList;
import java.util.List;

public class MyPlatesActivity extends AppCompatActivity {

    List<Plate> plates;
    PlateRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_plates);

        Intent activityThatCalled = getIntent();

        plates = (ArrayList<Plate>) activityThatCalled.getSerializableExtra(Constants.PLATES_KEY);

        Log.i("DAD", plates.toString());

        RecyclerView myPlatesRecyclerView = findViewById(R.id.my_plates_recyclerView);

        adapter = new PlateRecyclerViewAdapter(this, plates);

//        my_recycler_view.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        myPlatesRecyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));

        myPlatesRecyclerView.setAdapter(adapter);


    }



}
