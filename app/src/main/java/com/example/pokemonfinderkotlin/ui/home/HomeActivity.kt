package com.example.pokemonfinderkotlin.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.pokemonfinderkotlin.R
import com.example.pokemonfinderkotlin.ui.home.featured.FeaturedFragment
import com.example.pokemonfinderkotlin.ui.home.types.TypesFragment

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        supportActionBar?.title = "teste"

        addFragmentTo(R.id.typesFrameLayout, createTypeFragment())
        addFragmentTo(R.id.featuredFrameLayout, createFeaturedFragment())
    }

   private fun AppCompatActivity.addFragmentTo(containerId: Int, fragment: Fragment, tag: String = "") {
        supportFragmentManager.beginTransaction().add(containerId, fragment, tag).commit()
    }

    fun createTypeFragment(): TypesFragment {
        return TypesFragment.newInstance()
    }

    fun createFeaturedFragment(): FeaturedFragment {
        return FeaturedFragment.newInstance()
    }


}
