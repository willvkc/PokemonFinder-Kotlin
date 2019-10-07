package com.example.pokemonfinderkotlin.ui.splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.pokemonfinderkotlin.R
import com.example.pokemonfinderkotlin.ui.preference.PreferenceActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val intent = Intent(this, PreferenceActivity::class.java)
        startActivity(intent)
    }
}
