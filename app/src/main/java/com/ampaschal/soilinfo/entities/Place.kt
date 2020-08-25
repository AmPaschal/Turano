package com.ampaschal.soilinfo.entities

import java.util.Collections

data class Place (
    val name: String = "",
    val type: String = "",
    val layers: List<SoilLayer> = Collections.emptyList()
)