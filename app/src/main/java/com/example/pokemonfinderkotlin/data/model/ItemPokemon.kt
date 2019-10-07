package com.example.pokemonfinderkotlin.data.model

import com.squareup.moshi.Json

data class ItemPokemon(
    @Json(name = "abilities")
    val abilities_list: List<String>,
    @Json(name = "collectibles_slug")
    val collectiblesSlug: String,
    @Json(name = "detailPageURL")
    val detailPageURL: String,
    @Json(name = "featured")
    val featured: String,
    @Json(name = "height")
    val height: Double,
    @Json(name = "id")
    val id: Long,
    @Json(name = "name")
    val name: String,
    @Json(name = "number")
    val number: String,
    @Json(name = "slug")
    val slug: String,
    @Json(name = "thumbnailAltText")
    val thumbnailAltText: String,
    @Json(name = "thumbnailImage")
    val thumbnailImage: String,
    @Json(name = "type")
    val types_list: List<String>,
    @Json(name = "weakness")
    val weakness_list: List<String>,
    @Json(name = "weight")
    val weight: Double
) {


}