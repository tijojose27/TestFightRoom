package com.example.testfightroom;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testfightroom.Model.FlightsModel;
import com.example.testfightroom.Model.PlaneModel;

import java.util.ArrayList;
import java.util.List;

public class myAdapter extends RecyclerView.Adapter<myAdapter.myViewHolder> {

    class myViewHolder extends RecyclerView.ViewHolder{

        TextView flightTV;
        TextView planeTV;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            flightTV = itemView.findViewById(R.id.flight);
            planeTV = itemView.findViewById(R.id.plane);
        }
    }

    private final LayoutInflater inflater;
    private List<FlightsModel> flightsModelList= new ArrayList<>();
    private List<PlaneModel> planeModelList = new ArrayList<>();

    myAdapter(Context context){
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public myAdapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.list_item, parent, false);

        return new myViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull myAdapter.myViewHolder holder, int position) {
        int id = flightsModelList.get(position).getId();
        holder.flightTV.setText(String.valueOf(id));
    }

    void setFlightsModelList(List<FlightsModel> flights){
        flightsModelList = flights;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if(flightsModelList.size()>0 ){
            return flightsModelList.size();
        }
        return 0;
    }



}
