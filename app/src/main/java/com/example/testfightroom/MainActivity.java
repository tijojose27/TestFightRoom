package com.example.testfightroom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.testfightroom.Model.FlightsModel;
import com.example.testfightroom.ViewModel.FlightViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private FlightViewModel flightViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        flightViewModel = ViewModelProviders.of(this).get(FlightViewModel.class);




        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        final myAdapter adapter = new myAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        flightViewModel.getAllFlights().observe(this, new Observer<List<FlightsModel>>() {
            @Override
            public void onChanged(List<FlightsModel> flightsModels) {
                adapter.setFlightsModelList(flightsModels);
            }
        });

    }
}
