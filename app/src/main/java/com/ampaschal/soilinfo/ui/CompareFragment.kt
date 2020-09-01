package com.ampaschal.soilinfo.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.NavArgs
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ampaschal.soilinfo.MainViewModel
import com.ampaschal.soilinfo.databinding.FragmentCompareBinding
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class CompareFragment : Fragment() {

    private val args: CompareFragmentArgs by navArgs()
    private val mainViewModel: MainViewModel by sharedViewModel()
    lateinit var rvCompare: RecyclerView
    var compareAdapter = CompareAdapter()
    lateinit var compareBinding: FragmentCompareBinding
    lateinit var tvDefaultLayer: TextView
    lateinit var tvCompareLayer: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        compareBinding =
            FragmentCompareBinding.inflate(
                inflater,
                container,
                false
            )

        tvDefaultLayer = compareBinding.tvDefaultLayer
        tvCompareLayer = compareBinding.tvCompareLayer

        rvCompare = compareBinding.rvCompareList
        val layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rvCompare.layoutManager = layoutManager
        rvCompare.adapter = compareAdapter
        return compareBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        args.let {
            tvDefaultLayer.text = it.defaultPlace.name

        }

        mainViewModel.getPlaceById(args.comparePlace.key) {
            it?.let { place ->
                tvCompareLayer.text = it.name
                compareAdapter.setData(args.defaultPlace.layers, place.layers)
            }
        }

    }
}