package com.ampaschal.soilinfo.interfaces

import com.ampaschal.soilinfo.data.PlaceSummary

interface OnPlacesListItemInteractionListener {
    fun onPlaceClicked(place: PlaceSummary)
}