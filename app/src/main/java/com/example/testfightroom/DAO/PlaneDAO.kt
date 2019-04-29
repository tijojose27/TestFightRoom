package com.example.testfightroom.DAO

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.testfightroom.Model.PlaneModel

@Dao
interface PlaneDAO: BaseDAO<PlaneModel>{

    @Insert
    fun insertPlane(planeModel: PlaneModel)

    @Query("SELECT * FROM PLANE")
    fun getAllPLanes():LiveData<List<PlaneModel>>

    @Query("SELECT * FROM PLANE where id = :id")
    fun getPlaneForID(id: Int):LiveData<List<PlaneModel>>

    @Query("DELETE FROM plane")
    fun deleteAllPlanes()

}