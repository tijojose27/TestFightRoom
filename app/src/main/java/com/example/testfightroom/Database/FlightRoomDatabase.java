package com.example.testfightroom.Database;


import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.testfightroom.DAO.FlightsDAO;
import com.example.testfightroom.Model.FlightsModel;


@Database(entities = {FlightsModel.class}, version = 1, exportSchema = false)
public abstract class FlightRoomDatabase extends RoomDatabase {

    public abstract FlightsDAO flightsDAO();

    private static volatile FlightRoomDatabase INSTANCE;

    public static FlightRoomDatabase getDatabase(final Context context){
        if(INSTANCE == null){
            synchronized (FlightRoomDatabase.class){
                if (INSTANCE ==null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            FlightRoomDatabase.class, "flight_database")
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback(){
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            new PopulateDbAsync(INSTANCE).execute();
        }
    };

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final FlightsDAO flightsDAO;

        public PopulateDbAsync(FlightRoomDatabase db) {
            flightsDAO = db.flightsDAO();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            flightsDAO.deleteAll();
            FlightsModel flightsModel = new FlightsModel(0,1,342,"COK", "IAH");
            flightsDAO.insertFlight(flightsModel);
            return null;
        }
    }
}
