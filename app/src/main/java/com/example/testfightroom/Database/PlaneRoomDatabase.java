package com.example.testfightroom.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.testfightroom.DAO.PlaneDAO;
import com.example.testfightroom.Model.PlaneModel;

@Database(entities = {PlaneModel.class}, version = 1, exportSchema = false)
public abstract class PlaneRoomDatabase extends RoomDatabase{

        public abstract PlaneDAO planeDAO();

        private static volatile PlaneRoomDatabase INSTANCE;

        public static PlaneRoomDatabase getDatabase(final Context context){
            if(INSTANCE == null){
                synchronized (PlaneRoomDatabase.class){
                    if (INSTANCE ==null){
                        INSTANCE = Room.databaseBuilder(context.getApplicationContext(), PlaneRoomDatabase.class, "plane_database").build();
                    }
                }
            }
            return INSTANCE;
        }
}
