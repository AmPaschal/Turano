package com.ampaschal.soilinfo.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ampaschal.soilinfo.MainViewModel

import com.ampaschal.soilinfo.R
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
        val view = inflater.inflate(R.layout.fragment_dashboard, container, false)

        mainViewModel.places.observe(viewLifecycleOwner, Observer {

        })

        val place = generateAndAddPlace(true)
        val newPlace = generateAndAddPlace(false)

        mainViewModel.addPlace(place)
        mainViewModel.addPlace(newPlace)

        /*val database = FirebaseDatabase.getInstance()
        val ref = database.getReference("places")
        ref.setValue("Abuja")
        ref.child("cities").setValue("Ikeja")
        ref.child("states").push().setValue("Abia")
        ref.child("states").push().setValue("Anambra")

        val newRef = database.getReference("users")
        newRef.setValue("users@user.com")*/

        return view
    }

    private fun generateAndAddPlace(type: Boolean): Place {
        val soilLayer1 = SoilLayer(1, 12.2, 12.4, 23.0, "Top layer")
        val soilLayer2 = SoilLayer(2, 12.2, 12.4, 23.0, "Bottom layer")

        val list = mutableListOf<SoilLayer>()
        list.add(soilLayer1)
        list.add(soilLayer2)

        return Place(
            name = if (type) "Place 1" else "Place 2",
            type = if (type) "Type 1" else "Type 2",
            layers = list
        )
    }

}
