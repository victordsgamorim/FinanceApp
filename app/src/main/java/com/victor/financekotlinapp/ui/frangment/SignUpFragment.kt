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
import com.victor.financekotlinapp.database.AppDatabase
import com.victor.financekotlinapp.extensions.getEditTextString
import com.victor.financekotlinapp.model.User
import com.victor.financekotlinapp.repository.UserRepository
import kotlinx.android.synthetic.main.fragment_user_signup.*
import kotlinx.android.synthetic.main.fragment_user_signup.fragment_signup_user_first_name
import kotlinx.coroutines.*
import java.lang.IllegalArgumentException

class SignUpFragment : Fragment() {

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

        return inflater.inflate(R.layout.fragment_user_signup, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val direction = SignUpFragmentDirections.actionGlobalLoginFragment()

        fragment_cancel_button.setOnClickListener {
            controller.navigate(direction)
        }

        fragment_done_button.setOnClickListener {
            createUser()
            controller.navigate(direction)
        }

    }

    private fun createUser() {

        val firstName = getEditTextString(fragment_signup_user_first_name)
        val surname = getEditTextString(fragment_signup_user_surname)
        val username = getEditTextString(fragment_signup_user_name)
        val password = getEditTextString(fragment_signup_user_password)
        val passwordConfirm = getEditTextString(fragment_signup_user_confirm_password)

        val user = User(
            firstName = firstName,
            surname = surname,
            userName = username,
            password = password
        )

        repository.add(user)

    }


}