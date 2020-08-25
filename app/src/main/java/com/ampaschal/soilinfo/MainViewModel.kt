package com.ampaschal.soilinfo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ampaschal.soilinfo.data.PlaceSummary
import com.ampaschal.soilinfo.data.PlacesRepository
import com.ampaschal.soilinfo.entities.Place
import com.ampaschal.soilinfo.entities.SoilLayer

class MainViewModel(private val placesRepository: PlacesRepository) : ViewModel() {

    private val _places = MutableLiveData<List<PlaceSummary>>()
    val places: LiveData<List<PlaceSummary>> = _places

    private val _currentPlace = MutableLiveData<Place>()
    val currentPlace: LiveData<Place> = _currentPlace

    val soilLayers = mutableListOf<SoilLayer>()

    fun getPlacesList() : LiveData<List<PlaceSummary>> {
        return placesRepository.getPlacesList()
    }

    fun getPlaceById(placeId: String) {
        placesRepository.getPlaceById(placeId) {
            it?.let {
                _currentPlace.value = it
            }
        }
    }


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