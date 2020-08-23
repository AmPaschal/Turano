package com.ampaschal.soilinfo.ui;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ampaschal.soilinfo.PlacesAdapter;
import com.ampaschal.soilinfo.R;
import com.ampaschal.soilinfo.entities.Place;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PlacesFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class PlacesFragment extends Fragment {

    RecyclerView rvPlaces;
    ArrayList<Place> places = null;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PlacesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PlacesFragment newInstance(String param1, String param2) {
        PlacesFragment fragment = new PlacesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public PlacesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_places, container, false);

        places.add(new Place("Oroma-Ekiti-1", "VES 1"));
        places.add(new Place("Oroma-Ekiti-2", "VES 2"));
        places.add(new Place("Oroma-Ekiti-3", "VES 3"));
        places.add(new Place("Oroma-Ekiti-4", "VES 4"));
        places.add(new Place("Oroma-Ekiti-5", "VES 5"));
        places.add(new Place("Oroma-Ekiti-6", "VES 6"));
        places.add(new Place("Oroma-Ekiti-7", "VES 7"));
        places.add(new Place("Oroma-Ekiti-8", "VES 8"));
        places.add(new Place("Oroma-Ekiti-9", "VES 9"));
        places.add(new Place("Oroma-Ekiti-10", "VES 10"));

        rvPlaces = (RecyclerView) view.findViewById(R.id.list_places);
        LinearLayoutManager placesLayoutManager = new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, false);
        rvPlaces.setLayoutManager(placesLayoutManager);
        rvPlaces.setAdapter(new PlacesAdapter(places));

        return view;
    }
}