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
import com.ampaschal.soilinfo.interfaces.OnPlacesListItemInteractionListener;

import java.util.List;

public class CompareDataBottomDialogAdapter extends RecyclerView.Adapter<CompareDataBottomDialogAdapter.CompareDataBottomDialogViewHolder> {

    private List<PlaceSummary> comparePlaces;
    private OnPlacesListItemInteractionListener listener;

    public CompareDataBottomDialogAdapter(OnPlacesListItemInteractionListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public CompareDataBottomDialogViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.list_places_item, parent, false);
        return new CompareDataBottomDialogViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CompareDataBottomDialogViewHolder holder, int position) {
        PlaceSummary place = comparePlaces.get(position);
        holder.bind(place);
    }

    @Override
    public int getItemCount() {
        return comparePlaces.size();
    }

    public void setData(List<PlaceSummary> places) {
        this.comparePlaces = places;
        notifyDataSetChanged();
    }

    public class CompareDataBottomDialogViewHolder extends RecyclerView.ViewHolder {
        View mView;
        TextView tvPlace;
        TextView tvCity;

        public CompareDataBottomDialogViewHolder(@NonNull View itemView) {
            super(itemView);
            mView = itemView;
            tvPlace = itemView.findViewById(R.id.tv_place_name);
            tvCity = itemView.findViewById(R.id.tv_place_type);
        }

        public void bind(final PlaceSummary place){
            tvPlace.setText(place.getName());
            tvCity.setText(place.getType());
            mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onPlaceClicked(place);
                }
            });
        }
    }
}