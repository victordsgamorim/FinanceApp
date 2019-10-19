package com.victor.financekotlinapp.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.victor.financekotlinapp.R
import com.victor.financekotlinapp.ui.frangment.ChartIncomingFragment
import com.victor.financekotlinapp.ui.frangment.FragmentManagerViewPager
import com.victor.financekotlinapp.ui.frangment.FragmentResource
import com.victor.financekotlinapp.ui.frangment.ChartOutgoingFragment
import kotlinx.android.synthetic.main.activity_main.*

class FinanceListActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManagerViewPager = FragmentManagerViewPager(supportFragmentManager)
        fragmentManagerViewPager.addFragment(
            FragmentResource(
                fragment = ChartOutgoingFragment(),
                title = "Outgoing"
            ),
            FragmentResource(
                fragment = ChartIncomingFragment(),
                title = "Incoming"
            )
        )

        activity_main_viewpager.adapter = fragmentManagerViewPager
        activity_main_tablayout.setupWithViewPager(activity_main_viewpager)


        /**Fab*/
//        activity_finance_fab.setOnClickListener {
//            AlertDialogConfig(context = this, viewGroup = viewGroup as ViewGroup).show()
//        }

    }


}


