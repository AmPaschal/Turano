package com.ampaschal.soilinfo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ampaschal.soilinfo.entities.Place
import com.ampaschal.soilinfo.data.PlacesRepository

class MainViewModel(private val placesRepository: PlacesRepository) : ViewModel() {

    private val _places = MutableLiveData<List<Place>>()
    val places: LiveData<List<Place>> = _places


    fun addPlace(place: Place) {
        placesRepository.addPlace(place)
    }
}