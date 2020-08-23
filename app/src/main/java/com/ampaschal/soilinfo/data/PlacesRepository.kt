package com.ampaschal.soilinfo.data

import androidx.lifecycle.MutableLiveData
import com.ampaschal.soilinfo.entities.Place

interface PlacesRepository {

    fun addPlace(place: Place)

    fun getPlacesList(): MutableLiveData<List<PlaceSummary>>
}