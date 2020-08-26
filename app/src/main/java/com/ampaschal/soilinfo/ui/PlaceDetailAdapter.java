package com.ampaschal.soilinfo.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ampaschal.soilinfo.R;
import com.ampaschal.soilinfo.data.PlaceSummary;
import com.ampaschal.soilinfo.entities.SoilLayer;

import java.util.List;

public class PlaceDetailAdapter extends RecyclerView.Adapter<PlaceDetailAdapter.PlaceDetailViewHolder> {

    List<SoilLayer> soilLayers;

    public PlaceDetailAdapter() { }

    @NonNull
    @Override
    public PlaceDetailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View itemView;
        if ((viewType % 2) == 0){
                itemView = LayoutInflater.from(context)
                .inflate(R.layout.layer_detail_left_list, parent, false);
        } else{
            itemView = LayoutInflater.from(context)
                    .inflate(R.layout.layer_detail_right_list, parent, false);
        }
        return new PlaceDetailViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PlaceDetailViewHolder holder, int position) {
        SoilLayer soilLayer = soilLayers.get(position);
        holder.bind(soilLayer);
    }

    @Override
    public int getItemCount() {
        return (soilLayers != null) ? soilLayers.size() : 0;
    }

    public void setData(List<SoilLayer> soilLayers) {
        this.soilLayers = soilLayers;
        notifyDataSetChanged();
    }

    public class PlaceDetailViewHolder extends RecyclerView.ViewHolder {

        public PlaceDetailViewHolder(@NonNull View itemView) {
            super(itemView);

        }

        public void bind(SoilLayer soilLayer) {
            //TODO bind the views to the itemView
        }
    }
}
