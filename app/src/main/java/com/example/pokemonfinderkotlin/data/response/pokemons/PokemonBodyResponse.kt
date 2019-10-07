package com.example.pokemonfinderkotlin.data.response.type

import com.example.pokemonfinderkotlin.data.response.pokemons.PokemonItemResponse
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PokemonBodyResponse(
    val pokemonResults: List<PokemonItemResponse>
) {
}