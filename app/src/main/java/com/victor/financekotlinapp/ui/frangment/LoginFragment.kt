package com.victor.financekotlinapp.ui.frangment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.victor.financekotlinapp.R
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment() {

    private val controller by lazy {
        findNavController()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragment_login_button.setOnClickListener {
            val direction =
                LoginFragmentDirections.actionLoginFragmentToTablayoutFragment()

            controller.navigate(direction)
        }
    }
}