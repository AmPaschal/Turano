package com.ampaschal.soilinfo.entities

data class Place (
    val name: String,
    val type: String,
    val layers: List<SoilLayer>
)