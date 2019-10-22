package com.victor.financekotlinapp.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.victor.financekotlinapp.R

class MainActivity : AppCompatActivity() {

    private val controller by lazy {
        findNavController(R.id.nav_host_fragment)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        controller.addOnDestinationChangedListener { _, destination, _ ->

            when (destination.id) {
                R.id.loginFragment -> supportActionBar?.hide()
                else -> supportActionBar?.show()
            }

        }
    }


}


