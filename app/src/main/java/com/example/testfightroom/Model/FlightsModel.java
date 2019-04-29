package com.example.testfightroom.Model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.ArrayList;

@Entity(tableName = "Flights")
public class FlightsModel {

    @PrimaryKey
    @NonNull
    int id;

    int code;
    double price;
    String origin;
    String destination;

    @Ignore
    private ArrayList<PlaneModel> modelArrayList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public ArrayList<PlaneModel> getModelArrayList() {
        return modelArrayList;
    }

    public void setModelArrayList(ArrayList<PlaneModel> modelArrayList) {
        this.modelArrayList = modelArrayList;
    }

    public FlightsModel(int id, int code, double price, String origin, String destination) {
        this.id = id;
        this.code = code;
        this.price = price;
        this.origin = origin;
        this.destination = destination;
    }
}
