package com.ampaschal.soilinfo.data

import java.io.Serializable

data class PlaceSummary(
    val name: String = "",
    val type: String = "",
    var key: String = ""
): Serializable