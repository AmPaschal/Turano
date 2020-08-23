package com.ampaschal.soilinfo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ampaschal.soilinfo.entities.Place;

import java.util.ArrayList;

public class PlacesAdapter extends RecyclerView.Adapter<PlacesAdapter.PlaceViewHolder> {

    ArrayList<Place> places;

    public PlacesAdapter(ArrayList<Place> places) {
        this.places = places;
    }

    @NonNull
    @Override
    public PlaceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.list_places_item, parent, false);
        return new PlaceViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PlaceViewHolder holder, int position) {
        Place place = places.get(position);
        holder.bind(place);
    }

    @Override
    public int getItemCount() {
        return places.size();
    }


    public class PlaceViewHolder extends RecyclerView.ViewHolder{
        TextView tvPlace;
        TextView tvCity;

        public PlaceViewHolder(@NonNull View itemView) {
            super(itemView);
            tvPlace = (TextView) itemView.findViewById(R.id.tv_place);
            tvCity = (TextView) itemView.findViewById(R.id.tv_city_place) ;
        }

        public void bind(Place place){
            tvPlace.setText(place.getName());
            tvCity.setText(place.getName());
        }

    }
}
