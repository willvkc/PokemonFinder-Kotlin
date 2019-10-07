package com.example.pokemonfinderkotlin.ui.home.types

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pokemonfinderkotlin.R
import com.example.pokemonfinderkotlin.ui.adapter.TypesAdapter
import kotlinx.android.synthetic.main.fragment_recyclerview.*

class TypesFragment : Fragment() {

    companion object {
        fun newInstance() = TypesFragment()
    }

    private lateinit var viewModel: TypesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_recyclerview, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(TypesViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel: TypesViewModel = ViewModelProviders.of(this).get(TypesViewModel::class.java)

        viewModel.typesLiveData.observe(this, Observer {
            it?.let { types ->
                with(recyclerView) {
                    layoutManager = GridLayoutManager(
                        this@TypesFragment.context,
                        1,
                        GridLayoutManager.HORIZONTAL,
                        false
                    )
                    adapter = TypesAdapter(types)
                }
            }
        })

        viewModel.getTypes()

    }
}
