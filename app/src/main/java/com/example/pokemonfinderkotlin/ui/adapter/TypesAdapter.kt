package com.example.pokemonfinderkotlin.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemonfinderkotlin.R
import com.example.pokemonfinderkotlin.data.model.ItemType
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_type.view.*

class TypesAdapter(val types: List<ItemType>) : RecyclerView.Adapter<TypesAdapter.TypesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TypesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_type, parent, false)
        return TypesViewHolder(view)
    }

    override fun getItemCount() = types.count()

    override fun onBindViewHolder(holder: TypesViewHolder, position: Int) {
        holder.bindView(types[position])
    }

    class TypesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val nameTextView = view.nameTextView
        private val thumbImageView = view.thumbImageView

        fun bindView(type: ItemType){
            nameTextView.text = type.name
            Picasso.get().load(type.thumbnailImage).into(thumbImageView)

        }
    }
}