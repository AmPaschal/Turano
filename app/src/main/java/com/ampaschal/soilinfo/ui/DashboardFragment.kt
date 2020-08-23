package com.ampaschal.soilinfo.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ampaschal.soilinfo.MainViewModel
import com.ampaschal.soilinfo.R
import com.ampaschal.soilinfo.databinding.FragmentDashboardBinding
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


/**
 * A simple [Fragment] subclass.
 * Use the [DashboardFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DashboardFragment : Fragment() {

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

        return dashboardBinding.root
    }

}
