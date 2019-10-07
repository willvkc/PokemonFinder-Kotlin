package com.example.pokemonfinderkotlin.ui.pref

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pokemonfinderkotlin.data.ApiService
import com.example.pokemonfinderkotlin.data.model.ItemPokemon
import com.example.pokemonfinderkotlin.data.model.ItemType
import com.example.pokemonfinderkotlin.data.model.Preference
import com.example.pokemonfinderkotlin.data.response.type.TypeBodyResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PreferenceViewModel : ViewModel (){

    val preferenceViewData: MutableLiveData<Preference> = MutableLiveData()
    val typesLiveData: MutableLiveData<List<ItemType>> = MutableLiveData()

    fun getTypes() {
        ApiService.service.getTypes().enqueue(object : Callback<TypeBodyResponse> {

            override fun onResponse(call: Call<TypeBodyResponse>, response: Response<TypeBodyResponse>
            ) {
                if (response.isSuccessful){
                    val types: MutableList<ItemType> = mutableListOf()

                    response.body()?.let {typeBodyResponse ->
                        for (result in typeBodyResponse.typeResults){
                            val type = ItemType(
                                name = result.name,
                                thumbnailImage = result.thumbnailImage
                            )
                            types.add(type)
                        }
                    }
                    typesLiveData.value = types
                }
            }

            override fun onFailure(call: Call<TypeBodyResponse>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        })

    }


}