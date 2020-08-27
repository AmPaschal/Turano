package com.ampaschal.soilinfo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import com.ampaschal.soilinfo.data.PlaceSummary
import com.ampaschal.soilinfo.data.PlacesRepository
import com.ampaschal.soilinfo.entities.Place
import com.ampaschal.soilinfo.entities.SoilLayer

class MainViewModel(private val placesRepository: PlacesRepository) : ViewModel() {

    private val _places = MutableLiveData<List<PlaceSummary>>()

    private val _buildState = MutableLiveData<Boolean>()
    val buildState: LiveData<Boolean> = _buildState

    private val _currentPlace = MutableLiveData<Place>()
    val currentPlace: LiveData<Place> = _currentPlace

    val soilLayers = mutableListOf<SoilLayer>()

    init {
        placesRepository.getPlacesList {
            _places.value = it
        }
    }

    fun getFilteredPlacesList(searchText: String = "") : LiveData<List<PlaceSummary>> {
        return _places.map { places ->
            places.filter {
                it.name.toLowerCase().contains(searchText.toLowerCase())
            }
        }
    }

    fun getPlaceById(placeId: String, func: (place: Place?) -> Unit) {
        placesRepository.getPlaceById(placeId, func)
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

    fun loadBuildState(buildVersion: String) {
        placesRepository.getBuildState(buildVersion) {
            _buildState.value = it
        }
    }

}