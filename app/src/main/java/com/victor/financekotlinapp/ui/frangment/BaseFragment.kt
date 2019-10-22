package com.victor.financekotlinapp.ui.frangment

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.victor.financekotlinapp.NavGraphDirections
import com.victor.financekotlinapp.R

abstract class BaseFragment : Fragment() {

    private val controller by lazy {
        findNavController()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_option_back_login, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {


        if (item.itemId == R.id.menu_ic_back_login) goBackToLoginScreen()

        return super.onOptionsItemSelected(item)


    }

    private fun goBackToLoginScreen() {
        val direction = NavGraphDirections.actionGlobalLoginFragment()
        controller.navigate(direction)
    }
}