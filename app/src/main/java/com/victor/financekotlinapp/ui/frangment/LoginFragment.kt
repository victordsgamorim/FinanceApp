package com.victor.financekotlinapp.ui.frangment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.victor.financekotlinapp.R
import com.victor.financekotlinapp.database.AppDatabase
import com.victor.financekotlinapp.repository.UserRepository
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment() {

    private val dao by lazy {
        context?.let { AppDatabase.getInstance(it).getUserDao() }
            ?: throw IllegalArgumentException("Cannot reach the context")
    }

    private val repository by lazy {
        UserRepository(dao)
    }

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


            val userNameField = fragment_login_username.editText
                ?: throw NullPointerException("Username value is null")
            val username = userNameField.text.toString()

            val passwordField = (fragment_login_user_password.editText
                ?: throw NullPointerException("Password value is null"))
            val password = passwordField.text.toString()

            repository.get(username, password, onFinish = {


                if (it != null) {
                    Toast.makeText(
                        context,
                        "Welcome ${it.firstName} ${it.surname}",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                } else {
                    Toast.makeText(context, "Could not find user", Toast.LENGTH_SHORT)
                        .show()
                }

            })


            goToBalanceFragment()
        }

        fragment_login_sign_up.setOnClickListener {
            goToSignUpFragment()
        }
    }

    private fun goToSignUpFragment() {

        val direcation =
            LoginFragmentDirections.actionLoginFragmentToSignupFragment()

        controller.navigate(direcation)
    }

    private fun goToBalanceFragment() {
        val direction =
            LoginFragmentDirections.actionLoginFragmentToTablayoutFragment()

        controller.navigate(direction)
    }
}