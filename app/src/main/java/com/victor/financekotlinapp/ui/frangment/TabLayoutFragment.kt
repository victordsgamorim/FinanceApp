package com.victor.financekotlinapp.ui.frangment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import com.victor.financekotlinapp.R
import com.victor.financekotlinapp.extensions.showSnackbar
import com.victor.financekotlinapp.ui.adapter.FragmentManagerViewPager
import com.victor.financekotlinapp.viewmodel.TablayoutFragmentViewModel
import kotlinx.android.synthetic.main.fragment_tablayout.*
import kotlinx.android.synthetic.main.snackbar_information.*
import org.koin.android.viewmodel.ext.android.viewModel

class TabLayoutFragment : BaseFragment() {

    private val viewModel: TablayoutFragmentViewModel by viewModel()
    private val arguments by navArgs<TabLayoutFragmentArgs>()
    private val userId by lazy {
        arguments.userId
    }

    private val fragmentManagerViewPager by lazy {
        activity?.let { FragmentManagerViewPager(it.supportFragmentManager) }
            ?: throw IllegalArgumentException("Cannot load supportFragmentManager")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.save(userId)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tablayout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getUser(userId).observe(this, Observer {
            it?.let {
                showSnackbar(snackbar_action, "Welcome ${it.firstName} ${it.surname}")
            }
        })


        tabLayoutConfiguration()
    }

    private fun tabLayoutConfiguration() {

        addFragmentToTab()

        activity_main_viewpager.adapter = fragmentManagerViewPager
        activity_main_tablayout.setupWithViewPager(activity_main_viewpager)
    }

    private fun addFragmentToTab() {
        fragmentManagerViewPager.addFragment(
            FragmentResource(
                fragment = ChartBalanceFragment(),
                title = "Balance"
            ),
            FragmentResource(
                fragment = ChartIncomingFragment(),
                title = "Incoming"
            )
        )
    }
}