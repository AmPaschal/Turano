package com.ampaschal.soilinfo.entities

data class SoilLayer (
    val layer: Int = 0,
    val appRes: Double = 0.0,
    val thickness: Double = 0.0,
    val depth: Double = 0.0,
    val description: String = ""
)