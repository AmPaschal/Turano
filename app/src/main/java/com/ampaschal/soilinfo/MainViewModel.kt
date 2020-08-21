package com.ampaschal.soilinfo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ampaschal.soilinfo.entities.Place
import com.ampaschal.soilinfo.data.PlacesRepository
import com.ampaschal.soilinfo.entities.SoilLayer

class MainViewModel(private val placesRepository: PlacesRepository) : ViewModel() {

    private val _places = MutableLiveData<List<Place>>()
    val places: LiveData<List<Place>> = _places

    val soilLayers = mutableListOf<SoilLayer>()


    fun addPlace(place: Place) {
        placesRepository.addPlace(place)
    }

    fun addLayer (layer: SoilLayer) {
        soilLayers.add(layer)
    }

    fun clearLayers() {
        soilLayers.clear()
    }

}