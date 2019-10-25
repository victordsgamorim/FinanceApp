package com.victor.financekotlinapp.ui.frangment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.victor.financekotlinapp.R
import com.victor.financekotlinapp.database.AppDatabase
import com.victor.financekotlinapp.extensions.getEditTextString
import com.victor.financekotlinapp.extensions.showToast
import com.victor.financekotlinapp.factory.LoginFragmentViewModelFactory
import com.victor.financekotlinapp.repository.UserRepository
import com.victor.financekotlinapp.viewmodel.LoginFragmentViewModel
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment() {

    private val viewModel by lazy {
        val dao = context?.let { AppDatabase.getInstance(it).getUserDao() }
            ?: throw IllegalArgumentException("Cannot reach the context")
        val repository = UserRepository(dao)
        val factory = LoginFragmentViewModelFactory(repository)
        val provider = ViewModelProviders.of(this, factory)
        provider.get(LoginFragmentViewModel::class.java)
    }

    private val dao by lazy {

    }

    private val repository by lazy {

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
            checkUserLogin()
        }

        fragment_login_sign_up.setOnClickListener {
            goToSignUpFragment()
        }
    }

    private fun checkUserLogin() {

        val username = getEditTextString(fragment_login_username)
        val password = getEditTextString(fragment_login_user_password)

        viewModel.get(username, password).observe(this, Observer {

            if (it != null) {
                showToast("Welcome ${it.firstName} ${it.surname}")
                goToBalanceFragment()

            } else {
                showToast("Could not find user")
            }
        })



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