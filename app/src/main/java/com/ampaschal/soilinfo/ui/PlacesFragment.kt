package com.ampaschal.soilinfo.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ampaschal.soilinfo.MainViewModel
import com.ampaschal.soilinfo.data.PlaceSummary
import com.ampaschal.soilinfo.databinding.FragmentPlacesBinding
import com.ampaschal.soilinfo.interfaces.OnPlacesListItemInteractionListener
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class PlacesFragment : Fragment(), OnPlacesListItemInteractionListener {
    lateinit var rvPlaces: RecyclerView
    private val mainViewModel: MainViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? { // Inflate the layout for this fragment
        val placesBinding =
            FragmentPlacesBinding.inflate(
                inflater,
                container,
                false
            )

        rvPlaces = placesBinding.listPlaces

        val placesLayoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.VERTICAL, false
        )
        val placesAdapter = PlacesAdapter(this)
        rvPlaces.layoutManager = placesLayoutManager
        rvPlaces.adapter = placesAdapter

        mainViewModel.getFilteredPlacesList().observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            placesAdapter.setData(it)
        })

        val tvAddPlace = placesBinding.tvAddPlace
        tvAddPlace.setOnClickListener {
            val intent = Intent(activity, AddPlaceActivity::class.java)
            startActivity(intent)
        }

        val etSearch = placesBinding.etSearch
        etSearch.addTextChangedListener {
            mainViewModel.getFilteredPlacesList(it.toString()).observe(viewLifecycleOwner, androidx.lifecycle.Observer {
                placesAdapter.setData(it)
            })
        }

        return placesBinding.root
    }

    override fun onPlaceClicked(place: PlaceSummary) {
        val action =
            PlacesFragmentDirections.actionPlacesFragmentToPlaceDetailFragment(place)
        findNavController().navigate(action)
    }
}