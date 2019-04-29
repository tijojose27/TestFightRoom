package com.example.testfightroom.ViewModel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.testfightroom.Model.FlightsModel;
import com.example.testfightroom.Respository.FlightRepository;

import java.util.List;

public class FlightViewModel extends AndroidViewModel {

    private FlightRepository flightRepository;

    public LiveData<List<FlightsModel>>  allFlights;

    public FlightViewModel(Application application){
        super(application);
        flightRepository = new FlightRepository(application);
        allFlights = flightRepository.getAllFlights();
    }

    public LiveData<List<FlightsModel>> getAllFlights(){return allFlights; }

    public void insert(FlightsModel flightsModel){ flightRepository.insert(flightsModel);}

}
