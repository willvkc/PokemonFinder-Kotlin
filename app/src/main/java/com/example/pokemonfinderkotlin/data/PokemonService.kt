package com.example.pokemonfinderkotlin.data

import com.example.pokemonfinderkotlin.data.response.pokemons.PokemonItemResponse
import com.example.pokemonfinderkotlin.data.response.type.TypeBodyResponse
import retrofit2.Call
import retrofit2.http.GET


interface PokemonService {

    @GET("types.json")
    fun getTypes(): Call<TypeBodyResponse>

    @GET("pokemons.json")
    fun getPokemons(): Call<List<PokemonItemResponse>>

    companion object {

        val URL = "https://vortigo.blob.core.windows.net/files/pokemon/data/"
    }
}