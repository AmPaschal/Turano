package com.ampaschal.soilinfo.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.ampaschal.soilinfo.MainViewModel
import com.ampaschal.soilinfo.R
import com.ampaschal.soilinfo.databinding.FragmentPlaceDetailBinding
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class PlaceDetailFragment : Fragment() {

    private val args: PlaceDetailFragmentArgs? by navArgs()
    private lateinit var placeDetailBinding: FragmentPlaceDetailBinding
    private val mainViewModel: MainViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? { // Inflate the layout for this fragment
        placeDetailBinding = FragmentPlaceDetailBinding.inflate(inflater, container, false)

        val rvSoilLayers = placeDetailBinding.rvLayerList
        val layersLayoutManager = LinearLayoutManager(
            context, LinearLayoutManager.VERTICAL, false
        )

        val soilLayersAdapter = SoilLayersAdapter()

        rvSoilLayers.layoutManager = layersLayoutManager
        rvSoilLayers.adapter = soilLayersAdapter

        mainViewModel.currentPlace.observe(viewLifecycleOwner, Observer {
            soilLayersAdapter.setData(it.layers)
        })

        placeDetailBinding.tvCompareDataNext.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_placeDetailFragment_to_CompareDataBottomDialogFragment)
        })

        placeDetailBinding.tvCompareImageNext.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_placeDetailFragment_to_CompareDataBottomDialogFragment)
        })

        return placeDetailBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        args?.let {
            placeDetailBinding.tvPlaceName.text = it.place.name

        }

    }

}