package com.example.testfightroom.Model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Plane")
public class PlaneModel {

    @PrimaryKey
    int id;

    String type;
    int totalSeat;

    public String getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getTotalSeat() {
        return totalSeat;
    }

    public void setTotalSeat(int totalSeat) {
        this.totalSeat = totalSeat;
    }

    public PlaneModel(int id, String type, int totalSeat) {
        this.id = id;
        this.type = type;
        this.totalSeat = totalSeat;
    }
}
