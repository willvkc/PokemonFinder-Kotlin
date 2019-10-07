package com.example.pokemonfinderkotlin.data.response.type

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TypeItemResponse(
    val name: String,
    val thumbnailImage: String
) {


}