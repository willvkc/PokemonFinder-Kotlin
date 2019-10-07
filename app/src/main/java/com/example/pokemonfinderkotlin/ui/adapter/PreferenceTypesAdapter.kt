package com.example.pokemonfinderkotlin.ui.preference

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.pokemonfinderkotlin.R
import com.example.pokemonfinderkotlin.data.model.ItemType
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_spinner.view.*
import kotlinx.android.synthetic.main.item_spinner_drop.view.*


class PreferenceTypesAdapter(val context: Context, var types: List<ItemType>) : BaseAdapter() {

    val mInflater: LayoutInflater = LayoutInflater.from(context)


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View

        var type = types[position]
        if (convertView == null) {
            view = mInflater.inflate(R.layout.item_spinner, parent, false)
        } else {
            view = convertView
        }

        view.nameTextView.text = type.name
        return view
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        var type = types[position]
        if (convertView == null) {
            view = mInflater.inflate(R.layout.item_spinner_drop, parent, false)
        } else {
            view = convertView
        }

        view.nameTextViewDrop.text = type.name
        Picasso.get().load(type.thumbnailImage).into(view.thumbImageViewDrop)
        return view
    }

    override fun getCount(): Int {
        return types.count()
    }

    override fun getItem(position: Int): Any? {
        return null
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

}