package com.example.pokemonfinderkotlin.ui.pref

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.pokemonfinderkotlin.R

class PreferenceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preference)

        supportActionBar?.title = "Preferencias"

    }


}
