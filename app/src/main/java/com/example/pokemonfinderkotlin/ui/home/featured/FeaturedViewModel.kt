package com.example.pokemonfinderkotlin.ui.home.featured

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pokemonfinderkotlin.data.ApiService
import com.example.pokemonfinderkotlin.data.model.ItemPokemon
import com.example.pokemonfinderkotlin.data.response.pokemons.PokemonItemResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FeaturedViewModel : ViewModel() {
    // TODO: Implement the ViewModel

    val pokemonsLiveData: MutableLiveData<List<ItemPokemon>> = MutableLiveData()

    fun getPokemons() {

        ApiService.service.getPokemons().enqueue(object : Callback<List<PokemonItemResponse>> {

            override fun onResponse(call: Call<List<PokemonItemResponse>>, response: Response<List<PokemonItemResponse>>
            ) {
                if (response.isSuccessful){
                    val pokemons: MutableList<ItemPokemon> = mutableListOf()

                    response.body()?.let {pokemonBodyResponse ->
                        for (result in pokemonBodyResponse){
                            val pokemon = ItemPokemon(
                                abilities_list = result.abilities_list,
                                collectiblesSlug = result.collectiblesSlug,
                                detailPageURL = result.detailPageURL,
                                featured = result.featured,
                                height = result.height,
                                id = result.id,
                                name = result.name,
                                number = result.number,
                                slug = result.slug,
                                thumbnailAltText = result.thumbnailAltText,
                                thumbnailImage = result.thumbnailImage,
                                types_list = result.types_list,
                                weakness_list = result.weakness_list,
                                weight = result.weight
                            )
                            pokemons.add(pokemon)
                        }
                    }
                    pokemonsLiveData.value = pokemons
                }
            }

            override fun onFailure(call: Call<List<PokemonItemResponse>>, t: Throwable) {
                Log.i("Tatta", "error: " + t.message)
            }

        })

    }

}
