package com.victor.financekotlinapp.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.victor.financekotlinapp.R
import com.victor.financekotlinapp.model.Balance
import com.victor.financekotlinapp.model.BalanceType
import com.victor.financekotlinapp.ui.PieChartView
import com.victor.financekotlinapp.ui.adapter.FinanceAdapter
import kotlinx.android.synthetic.main.activity_list_balance.*
import java.math.BigDecimal

class FinanceListActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_balance)

        /**View instantiated in PieChart in order to allow the config in other class*/
        val viewGroup = window.decorView

        /**Example of data*/
        //TODO("not implemented") ROOM implementation in order to save the transaction data
        val balances: List<Balance> = listOf(
            Balance(
                message = "Lunchsaldkajdklasjdklsajdlkajdakljdakldjalkdjakldjalkdjaldkaj",
                value = BigDecimal(100.0), type = BalanceType.OUTGOING
            ),
            Balance(message = "Wage", value = BigDecimal(300.0), type = BalanceType.INCOMING),
            Balance(message = "Car", value = BigDecimal(123.98), type = BalanceType.OUTGOING)
        )

        /**creates PieChart*/
        PieChartView(balances, viewGroup).show()

        /**Recycler View Items*/
        activity_finance_list.adapter =
            FinanceAdapter(this, balances)


        /**Fab*/
//        activity_finance_fab.setOnClickListener {
//            AlertDialogConfig(context = this, viewGroup = viewGroup as ViewGroup).show()
//        }

    }


}


