package com.example.testfightroom.Respository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.testfightroom.DAO.FlightsDAO;
import com.example.testfightroom.Database.FlightRoomDatabase;
import com.example.testfightroom.Model.FlightsModel;

import java.util.List;

public class FlightRepository {

    private FlightsDAO mFlightDao;
    private LiveData<List<FlightsModel>> allFlights;

    public FlightRepository(Application application) {
        FlightRoomDatabase db = FlightRoomDatabase.getDatabase(application);
        mFlightDao = db.flightsDAO();
        allFlights = mFlightDao.getAllFlghts();
    }

    public LiveData<List<FlightsModel>> getAllFlights(){
        return allFlights;
    }

    public void insert(FlightsModel flightsModel){
        new insertAsyncTask(mFlightDao).execute(flightsModel);
    }

    private static class insertAsyncTask extends AsyncTask<FlightsModel, Void, Void> {

        private FlightsDAO mAsyncFlightDAO;

        insertAsyncTask(FlightsDAO mFlightDao) {
            mAsyncFlightDAO = mFlightDao;
        }


        @Override
        protected Void doInBackground(FlightsModel... flightsModels) {
            mAsyncFlightDAO.insertFlight(flightsModels[0]);
            return null;
        }
    }
}
