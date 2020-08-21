package com.ampaschal.soilinfo.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ampaschal.soilinfo.MainViewModel
import com.ampaschal.soilinfo.databinding.ActivityAddPlaceBinding
import com.ampaschal.soilinfo.entities.Place
import com.ampaschal.soilinfo.entities.SoilLayer
import org.koin.androidx.viewmodel.ext.android.viewModel

class AddPlaceActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModel()
    lateinit var addPlaceBinding: ActivityAddPlaceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addPlaceBinding = ActivityAddPlaceBinding.inflate(layoutInflater)
        setContentView(addPlaceBinding.root)

        addPlaceBinding.tvLayerItem.text = mainViewModel.soilLayers.size.toString()

        addPlaceBinding.btNextLayer.setOnClickListener {

            handleAddSoilLayer()
        }

        addPlaceBinding.btSubmit.setOnClickListener {

            handleAddPlace()

        }
    }

    private fun handleAddPlace() {
        if (mainViewModel.soilLayers.size < 5) {
            toast("There should be at least 5 layers entered before submitting")
            return
        }

        val name = addPlaceBinding.etPlaceName.text.trim().toString()
        val type = addPlaceBinding.etType.text.trim().toString()

        val place = Place(name, type, mainViewModel.soilLayers)

        mainViewModel.addPlace(place)

        addPlaceBinding.run {
            etPlaceName.text.clear()
            etType.text.clear()
        }

        mainViewModel.clearLayers()
        addPlaceBinding.tvLayerItem.text = mainViewModel.soilLayers.size.toString()
    }

    private fun handleAddSoilLayer() {
        val layerNo = addPlaceBinding.etLayerNo.text.trim().toString()
        val appRes = addPlaceBinding.etAppRes.text.trim().toString()
        val thickness = addPlaceBinding.etThickness.text.trim().toString()
        val depth = addPlaceBinding.etDepth.text.trim().toString()
        val description = addPlaceBinding.etDescription.text.trim().toString()

        if (layerNo.isNullOrEmpty() || appRes.isNullOrEmpty() || thickness.isNullOrEmpty()
            || depth.isNullOrEmpty() || description.isNullOrEmpty()
        ) {
            toast("All layer fields are compulsory")
            return
        }

        val soilLayer = SoilLayer(
            layer = layerNo.toInt(), appRes = appRes.toDouble(), thickness = thickness.toDouble(),
            depth = depth.toDouble(), description = description
        )

        mainViewModel.addLayer(soilLayer)

        addPlaceBinding.run {
            etLayerNo.text.clear()
            etAppRes.text.clear()
            etThickness.text.clear()
            etDepth.text.clear()
            etDescription.text.clear()
        }

        addPlaceBinding.tvLayerItem.text = mainViewModel.soilLayers.size.toString()

    }


    private fun toast(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }
}