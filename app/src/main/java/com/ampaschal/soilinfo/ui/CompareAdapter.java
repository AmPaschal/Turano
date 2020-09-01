package com.ampaschal.soilinfo.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ampaschal.soilinfo.R;
import com.ampaschal.soilinfo.entities.SoilLayer;

import java.util.List;

public class CompareAdapter extends RecyclerView.Adapter<CompareAdapter.CompareViewHolder> {

    private List<SoilLayer> compareLayer1;
    private List<SoilLayer> compareLayer2;

    public CompareAdapter() {
    }

    @NonNull
    @Override
    public CompareViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View itemView = LayoutInflater.from(context).inflate(R.layout.compare_list_item,
                parent, false);
        return new CompareViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CompareViewHolder holder, int position) {
        SoilLayer layer_1 = compareLayer1.get(position);
        SoilLayer layer_2 = compareLayer2.get(position);
        holder.bind(layer_1, layer_2);
    }

    @Override
    public int getItemCount() {
        return compareLayer1 != null ? compareLayer1.size() : 0;
    }

    public void setData(List<SoilLayer> compareLayer1, List<SoilLayer> compareLayer2) {
        this.compareLayer1 = compareLayer1;
        this.compareLayer2 = compareLayer2;
        notifyDataSetChanged();
    }



    public class CompareViewHolder extends RecyclerView.ViewHolder {

        TextView tvAppResistanceValue;
        TextView tvThicknessValue;
        TextView tvDepthValue;
        TextView tvDescription;

        TextView tvAppResistanceValue_2;
        TextView tvThicknessValue_2;
        TextView tvDepthValue_2;
        TextView tvDescription_2;



        public CompareViewHolder(@NonNull View itemView) {
            super(itemView);
            tvAppResistanceValue = (TextView) itemView.findViewById(R.id.tv_app_resistance_value);
            tvThicknessValue = (TextView) itemView.findViewById(R.id.tv_thickness_value);
            tvDepthValue = (TextView) itemView.findViewById(R.id.tv_depth_value);
            tvDescription = (TextView) itemView.findViewById(R.id.tv_description_text);

            tvAppResistanceValue_2 = (TextView) itemView.findViewById(R.id.tv_app_resistance_value_red);
            tvThicknessValue_2 = (TextView) itemView.findViewById(R.id.tv_thickness_value_red);
            tvDepthValue_2 = (TextView) itemView.findViewById(R.id.tv_depth_value_red);
            tvDescription_2 = (TextView) itemView.findViewById(R.id.tv_description_text_red);
        }

        public void bind(SoilLayer compareLayer_1, SoilLayer compareLayer_2){
            tvAppResistanceValue.setText(String.valueOf(compareLayer_1.getAppRes()));
            tvThicknessValue.setText(String.valueOf(compareLayer_1.getThickness()));
            tvDepthValue.setText(String.valueOf(compareLayer_1.getDepth()));
            tvDescription.setText(compareLayer_1.getDescription());

            tvAppResistanceValue_2.setText(String.valueOf(compareLayer_2.getAppRes()));
            tvThicknessValue_2.setText(String.valueOf(compareLayer_2.getThickness()));
            tvDepthValue_2.setText(String.valueOf(compareLayer_2.getDepth()));
            tvDescription_2.setText(compareLayer_2.getDescription());
        }
    }
}
