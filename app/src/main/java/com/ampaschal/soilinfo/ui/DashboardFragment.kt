package com.ampaschal.soilinfo.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.ampaschal.soilinfo.MainViewModel
import com.ampaschal.soilinfo.R
import com.ampaschal.soilinfo.data.PlaceSummary
import com.ampaschal.soilinfo.databinding.FragmentDashboardBinding
import com.ampaschal.soilinfo.interfaces.OnPlacesListItemInteractionListener
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


/**
 * A simple [Fragment] subclass.
 * Use the [DashboardFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DashboardFragment : Fragment(), OnPlacesListItemInteractionListener {

    private val mainViewModel: MainViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val dashboardBinding = FragmentDashboardBinding.inflate(inflater, container, false)


        dashboardBinding.tvViewPlaces.setOnClickListener {
            findNavController().navigate(R.id.action_dashboardFragment_to_placesFragment)
        }

        val rvRecentPlaces = dashboardBinding.listRecent

        val placesLayoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.VERTICAL, false
        )
        val placesAdapter = PlacesAdapter(this)
        rvRecentPlaces.layoutManager = placesLayoutManager
        rvRecentPlaces.adapter = placesAdapter

        placesAdapter.setData(mainViewModel.getRecentPlaces())

        return dashboardBinding.root
    }

    override fun onPlaceClicked(placeSummary: PlaceSummary) {
        mainViewModel.addRecentPlace(placeSummary)
        val action =
            DashboardFragmentDirections.actionDashboardFragmentToPlaceDetailFragment(placeSummary)
        findNavController().navigate(action)
    }

}
