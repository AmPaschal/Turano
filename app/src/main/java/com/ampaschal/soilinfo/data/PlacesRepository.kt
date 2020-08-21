package com.ampaschal.soilinfo.data

import com.ampaschal.soilinfo.entities.Place

interface PlacesRepository {

    fun addPlace(place: Place)
}