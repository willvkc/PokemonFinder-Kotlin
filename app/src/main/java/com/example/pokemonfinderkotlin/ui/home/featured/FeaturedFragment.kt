package com.example.pokemonfinderkotlin.ui.home.featured

import PokemonAdapter
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokemonfinderkotlin.R
import com.example.pokemonfinderkotlin.ui.pokemon.PokemonActivity
import kotlinx.android.synthetic.main.fragment_recyclerview.*

class FeaturedFragment : Fragment() {

    companion object {
        fun newInstance() = FeaturedFragment()
    }

    private lateinit var viewModel: FeaturedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_recyclerview, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(FeaturedViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel: FeaturedViewModel = ViewModelProviders.of(this).get(FeaturedViewModel::class.java)

        viewModel.pokemonsLiveData.observe(this, Observer {
            it?.let { pokemons ->
                with(recyclerView) {
                    layoutManager = LinearLayoutManager(this@FeaturedFragment.context)
                    adapter = PokemonAdapter(pokemons){pokemon ->
                        context.startActivity(PokemonActivity.getStartIntent(context, pokemon))
                    }
                }

            }
        })

        viewModel.getPokemons()

    }



}
