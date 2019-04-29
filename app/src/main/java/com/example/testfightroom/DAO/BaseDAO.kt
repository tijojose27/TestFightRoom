package com.example.testfightroom.DAO

import androidx.room.*

@Dao
interface BaseDAO<in T> {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(t: T)

    @Update
    fun update(type: T)

    @Delete
    fun delete(type: T)

}
