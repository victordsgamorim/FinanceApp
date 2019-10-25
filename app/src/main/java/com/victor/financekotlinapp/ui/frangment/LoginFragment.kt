package com.victor.financekotlinapp.ui.frangment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.victor.financekotlinapp.R
import com.victor.financekotlinapp.extensions.getEditTextString
import com.victor.financekotlinapp.extensions.showToast
import com.victor.financekotlinapp.viewmodel.LoginFragmentViewModel
import kotlinx.android.synthetic.main.fragment_login.*
import org.koin.android.viewmodel.ext.android.viewModel

class LoginFragment : Fragment() {


    private val viewModel: LoginFragmentViewModel by viewModel()

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
            it?.let {
                showToast("Welcome ${it.firstName} ${it.surname}")
                goToBalanceFragment(it.id)
            } ?: showToast("Could not find user")
        })


    }

    private fun goToSignUpFragment() {

        val direcation =
            LoginFragmentDirections.actionLoginFragmentToSignupFragment()

        controller.navigate(direcation)
    }

    private fun goToBalanceFragment(id: Long) {
        val direction =
            LoginFragmentDirections.actionLoginFragmentToTablayoutFragment(id)

        controller.navigate(direction)
    }
}