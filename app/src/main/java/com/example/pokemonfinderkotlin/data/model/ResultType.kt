package com.example.pokemonfinderkotlin.data.model

import com.squareup.moshi.Json
import java.util.*

class ResultType {
    @Json(name = "results")
    var results: ArrayList<ItemType>? = null
}