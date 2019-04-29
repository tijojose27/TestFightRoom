package com.example.testfightroom.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.testfightroom.Model.FlightsModel;

import java.util.List;

@Dao
public interface FlightsDAO extends BaseDAO<FlightsModel> {

    @Insert
    void insertFlight(FlightsModel flightsModel);

    @Query("DELETE FROM flights")
    void deleteAll();

    @Query("SELECT * FROM flights ORDER BY id DESC")
    LiveData<List<FlightsModel>> getAllFlghts();
}
