package com.victor.financekotlinapp.ui.frangment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import com.victor.financekotlinapp.R
import com.victor.financekotlinapp.model.User
import kotlinx.android.synthetic.main.fragment_user_signup.*
import kotlinx.android.synthetic.main.fragment_user_signup.fragment_signup_user_first_name
import java.lang.IllegalArgumentException

class SignUpFragment : Fragment() {


    private val controller by lazy {
        findNavController()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_user_signup, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val direction = SignUpFragmentDirections.actionGlobalLoginFragment()

        fragment_cancel_button.setOnClickListener {
            controller.navigate(direction)
        }

        fragment_done_button.setOnClickListener {
            //createUser()
            controller.navigate(direction)


        }

    }

    private fun createUser(): User {

        val firstNameField = fragment_signup_user_first_name.editText
        val surnameNameField = fragment_signup_user_surname.editText
        val userNameField = fragment_signup_user_name.editText
        val passwordField = fragment_signup_user_password.editText
        val confirmPasswordField = fragment_signup_user_confirm_password.editText

        val primeiroNome = firstNameField?.let { it.text.toString() }
        val surname = surnameNameField?.let { it.text.toString() }
        val userName = userNameField?.let { it.text.toString() }
        val password = passwordField?.let { it.text.toString() }
        val confirmPassword = confirmPasswordField?.let { it.text.toString() }

        return User(
            firstName = primeiroNome,
            surname = surname,
            userName = userName,
            password = password
        )

    }


}