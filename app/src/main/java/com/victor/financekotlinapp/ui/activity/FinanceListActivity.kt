package com.victor.financekotlinapp.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.victor.financekotlinapp.R
import com.victor.financekotlinapp.ui.frangment.ChartIncomingFragment
import com.victor.financekotlinapp.ui.frangment.FragmentManagerViewPager
import com.victor.financekotlinapp.ui.frangment.FragmentResource
import com.victor.financekotlinapp.ui.frangment.ChartBalanceFragment
import kotlinx.android.synthetic.main.activity_main.*

class FinanceListActivity : AppCompatActivity() {

    private val fragmentManagerViewPager by lazy {
        FragmentManagerViewPager(supportFragmentManager)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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


