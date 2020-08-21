package com.ampaschal.soilinfo.ui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ampaschal.soilinfo.MainViewModel

import com.ampaschal.soilinfo.R
import com.ampaschal.soilinfo.databinding.FragmentDashboardBinding
import com.ampaschal.soilinfo.entities.Place
import com.ampaschal.soilinfo.entities.SoilLayer
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

        dashboardBinding.tvWelcome.setOnClickListener {
            val intent = Intent(activity, AddPlaceActivity::class.java)
            startActivity(intent)
        }

        return dashboardBinding.root
    }

}
