package com.ampaschal.soilinfo.ui

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.cardview.widget.CardView
import androidx.core.widget.addTextChangedListener
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ampaschal.soilinfo.MainViewModel
import com.ampaschal.soilinfo.data.PlaceSummary
import com.ampaschal.soilinfo.databinding.FragmentCompareDataBottomDialogBinding
import com.ampaschal.soilinfo.interfaces.OnPlacesListItemInteractionListener
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [CompareDataBottomDialogFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CompareDataBottomDialogFragment : BottomSheetDialogFragment(),
    OnPlacesListItemInteractionListener {

    private val args: CompareDataBottomDialogFragmentArgs by navArgs()
    lateinit var rvComparePlace: RecyclerView
    lateinit var searchImage: CardView
    lateinit var etCompareSearch: EditText
    private val mainViewModel: MainViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val compareDataBottomDialogBinding =
            FragmentCompareDataBottomDialogBinding.inflate(
                inflater,
                container,
                false
            )

        searchImage = compareDataBottomDialogBinding.imageSearch
        searchImage.setOnClickListener {
            compareDataBottomDialogBinding.imageSearch.visibility = View.INVISIBLE
            compareDataBottomDialogBinding.tvCompareTitle.visibility = View.INVISIBLE
            compareDataBottomDialogBinding.etSearch.visibility = View.VISIBLE
        }

        val compareAdapter = CompareDataBottomDialogAdapter(this)
        etCompareSearch = compareDataBottomDialogBinding.etSearch
        etCompareSearch.addTextChangedListener { it ->
            mainViewModel.getFilteredPlacesList(it.toString())
                .observe(viewLifecycleOwner, androidx.lifecycle.Observer {
                    compareAdapter.setData(it)
                })
        }

        rvComparePlace = compareDataBottomDialogBinding.rvCompareBottomSheetListPlace
        val compareLayout = LinearLayoutManager(
            context,
            LinearLayoutManager.VERTICAL, false
        )

        mainViewModel.getFilteredPlacesList()
            .observe(viewLifecycleOwner, androidx.lifecycle.Observer {
                compareAdapter.setData(it)
            })


        rvComparePlace.layoutManager = compareLayout
        rvComparePlace.adapter = compareAdapter

        return compareDataBottomDialogBinding.root
    }

    override fun onPlaceClicked(comparePlace: PlaceSummary) {
        mainViewModel.getPlaceById(args.place.key) {
            it?.let { place ->
                val action = CompareDataBottomDialogFragmentDirections.actionCompareDataBottomDialogFragmentToCompareFragment(place, comparePlace)
                findNavController().navigate(action)
            }
        }

    }

}


