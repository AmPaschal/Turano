package com.ampaschal.soilinfo.data

import com.ampaschal.soilinfo.entities.Place

interface PlacesRepository {

    fun addPlace(place: Place)

    fun getPlacesList(func: (List<PlaceSummary>) -> Unit)

    fun getPlaceById(placeId: String, func: (place: Place?) -> Unit)
    fun getBuildState(buildVersion: String, func: (state: Boolean) -> Unit)
    fun getRecentPlaces(): List<PlaceSummary>
    fun addRecentPlace(placeSummary: PlaceSummary)
}