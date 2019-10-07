package com.example.pokemonfinderkotlin.data

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object ApiService {

    private fun initRetrofit() : Retrofit{
        val retrofit = Retrofit.Builder()
            .baseUrl(PokemonService.URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        return retrofit
    }

    val service: PokemonService = initRetrofit().create(PokemonService::class.java)

}