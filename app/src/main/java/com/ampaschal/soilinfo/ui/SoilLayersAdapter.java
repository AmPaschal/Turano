package com.ampaschal.soilinfo.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ampaschal.soilinfo.R;
import com.ampaschal.soilinfo.data.PlaceSummary;
import com.ampaschal.soilinfo.entities.SoilLayer;

import java.util.List;

public class SoilLayersAdapter extends RecyclerView.Adapter<SoilLayersAdapter.SoilLayerViewHolder> {

    private List<SoilLayer> soilLayers;

    public SoilLayersAdapter() {

    }

    @NonNull
    @Override
    public SoilLayerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.layer_detail_right_list, parent, false);
        return new SoilLayerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SoilLayerViewHolder holder, int position) {
        SoilLayer place = soilLayers.get(position);
        holder.bind(place);
    }

    @Override
    public int getItemCount() {
        return soilLayers != null ? soilLayers.size() : 0;
    }

    public void setData(List<SoilLayer> layers) {
        this.soilLayers = layers;
        notifyDataSetChanged();
    }


    class SoilLayerViewHolder extends RecyclerView.ViewHolder{
        View mView;
        TextView tvLayerNo;
        TextView tvAppRes;
        TextView tvThickness;
        TextView tvDepth;
        TextView tvDescription;

        public SoilLayerViewHolder(@NonNull View itemView) {
            super(itemView);
            mView = itemView;
            tvLayerNo = itemView.findViewById(R.id.tv_layer_no);
            tvAppRes = itemView.findViewById(R.id.tv_app_resistance_value);
            tvThickness = itemView.findViewById(R.id.tv_thickness_value);
            tvDepth = itemView.findViewById(R.id.tv_depth_value);
            tvDescription = itemView.findViewById(R.id.tv_description_text);
        }

        public void bind(final SoilLayer layer){
            tvLayerNo.setText(String.valueOf(layer.getLayer()));
            tvAppRes.setText(String.valueOf(layer.getAppRes()));
            tvThickness.setText(String.valueOf(layer.getThickness()));
            tvDepth.setText(String.valueOf(layer.getDepth()));
            tvDescription.setText(layer.getDescription());

        }

    }
}
