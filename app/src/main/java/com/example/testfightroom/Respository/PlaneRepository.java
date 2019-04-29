package com.example.testfightroom.Respository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.testfightroom.DAO.PlaneDAO;
import com.example.testfightroom.Database.PlaneRoomDatabase;
import com.example.testfightroom.Model.PlaneModel;

import java.util.List;

public class PlaneRepository {

    private PlaneDAO mPlaneDao;
    private LiveData<List<PlaneModel>> allPlanes;

    public PlaneRepository(Application application) {
        PlaneRoomDatabase db = PlaneRoomDatabase.getDatabase(application);
        mPlaneDao = db.planeDAO();
        allPlanes = mPlaneDao.getAllPLanes();
    }

    public LiveData<List<PlaneModel>> getAllPlanes(){
        return allPlanes;
    }

    public void insert(PlaneModel planeModel){
        new insertAsyncTask(mPlaneDao).execute(planeModel);
    }

    private static class insertAsyncTask extends AsyncTask<PlaneModel, Void, Void> {

        private PlaneDAO mAsyncPlaneDao;

        insertAsyncTask(PlaneDAO mPlaneDao) {
            mAsyncPlaneDao = mPlaneDao;
        }


        @Override
        protected Void doInBackground(PlaneModel... planeModels) {
            mAsyncPlaneDao.insertPlane(planeModels[0]);
            return null;
        }
    }
}
