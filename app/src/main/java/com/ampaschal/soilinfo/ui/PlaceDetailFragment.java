package com.ampaschal.soilinfo.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ampaschal.soilinfo.R;
import com.ampaschal.soilinfo.databinding.FragmentPlaceDetailBinding;
import com.ampaschal.soilinfo.entities.SoilLayer;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;


public class PlaceDetailFragment extends Fragment {

    RecyclerView rvPlaceDetail;
    private ArrayList<SoilLayer> placeDetails;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        @NotNull FragmentPlaceDetailBinding placeDetailBinding = FragmentPlaceDetailBinding.inflate(inflater, container, false);

        rvPlaceDetail = placeDetailBinding.rvLayerList;

        LinearLayoutManager placesLayoutManager = new LinearLayoutManager(
                getContext(),
                LinearLayoutManager.VERTICAL, false
        );




        return placeDetailBinding.getRoot();
    }
}