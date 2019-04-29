package com.example.testfightroom.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.testfightroom.Model.PlaneModel;
import com.example.testfightroom.Respository.PlaneRepository;

import java.util.List;

public class PlaneViewModel extends AndroidViewModel {

    private PlaneRepository planeRepository;
    private LiveData<List<PlaneModel>> allPlanes;

    public PlaneViewModel(@NonNull Application application) {
        super(application);
        planeRepository = new PlaneRepository(application);
        allPlanes = planeRepository.getAllPlanes();
    }

    LiveData<List<PlaneModel>> getAllPlanes(){
        return allPlanes;
    }

    public void insert(PlaneModel planeModel){planeRepository.insert(planeModel);}
}
