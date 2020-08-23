package com.ampaschal.soilinfo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ampaschal.soilinfo.data.PlaceSummary;

import java.util.List;

public class PlacesAdapter extends RecyclerView.Adapter<PlacesAdapter.PlaceViewHolder> {

    List<PlaceSummary> places;

    public PlacesAdapter() {}

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
        PlaceSummary place = places.get(position);
        holder.bind(place);
    }

    @Override
    public int getItemCount() {
        return places != null ? places.size() : 0;
    }

    public void setData(List<PlaceSummary> places) {
        this.places = places;
        notifyDataSetChanged();
    }


    public static class PlaceViewHolder extends RecyclerView.ViewHolder{
        TextView tvPlace;
        TextView tvCity;

        public PlaceViewHolder(@NonNull View itemView) {
            super(itemView);
            tvPlace = itemView.findViewById(R.id.tv_place_name);
            tvCity = itemView.findViewById(R.id.tv_place_type);
        }

        public void bind(PlaceSummary place){
            tvPlace.setText(place.getName());
            tvCity.setText(place.getType());
        }

    }
}
