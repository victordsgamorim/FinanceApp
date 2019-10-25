package com.victor.financekotlinapp.ui.frangment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.victor.financekotlinapp.R
import com.victor.financekotlinapp.ui.adapter.FragmentManagerViewPager
import com.victor.financekotlinapp.viewmodel.TablayoutFragmentViewModel
import kotlinx.android.synthetic.main.fragment_tablayout.*
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