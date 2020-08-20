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

}
