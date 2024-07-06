package com.example.vehiclebuyingapp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vehiclebuyingapp.R;
import com.example.vehiclebuyingapp.model.Car;

import java.util.List;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.CarViewHolder> {

    private List<Car> CarList;

    public CarAdapter(List<Car> CarList){
        this.CarList = CarList;
    }

    @NonNull
    @Override
    public CarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.iterm_car, parent,false);
        return new CarViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarViewHolder holder , int position){
        Car car = CarList.get(position);
        holder.ViewCarType.setText(car.getType());
        holder.ViewCarColor.setText(car.getColor());
        holder.ViewCarPrice.setText(String.valueOf(car.getPrice()));
        holder.ViewCarYear.setText(String.valueOf(car.getYear()));
    }

    @Override
    public int getItemCount(){
        return CarList.size();
    }

    public void updateList(List<Car> newList){
        CarList = newList;
        notifyDataSetChanged();
    }

    public static class CarViewHolder extends RecyclerView.ViewHolder{
        TextView ViewCarType, ViewCarColor, ViewCarPrice, ViewCarYear;

        public CarViewHolder (@NonNull View itemView){
            super(itemView);
            ViewCarType = itemView.findViewById(R.id.ViewCarType);
            ViewCarColor = itemView.findViewById(R.id.ViewCarColor);
            ViewCarPrice = itemView.findViewById(R.id.ViewCarPrice);
            ViewCarYear = itemView.findViewById(R.id.ViewCarYear);
        }
    }
}
