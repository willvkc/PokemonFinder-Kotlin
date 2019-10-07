package com.example.pokemonfinderkotlin.data.response.type

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TypeBodyResponse(
    @Json(name = "results")
    val typeResults: List<TypeItemResponse>
) {
}