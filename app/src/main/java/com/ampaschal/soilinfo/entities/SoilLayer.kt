package com.ampaschal.soilinfo.entities

data class SoilLayer (
    val layer: Int,
    val appRes: Double,
    val thickness: Double,
    val depth: Double,
    val description: String
)