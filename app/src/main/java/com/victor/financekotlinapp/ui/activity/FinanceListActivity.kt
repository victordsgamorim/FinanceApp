package com.victor.financekotlinapp.ui.activity

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate
import com.victor.financekotlinapp.R
import com.victor.financekotlinapp.model.Balance
import com.victor.financekotlinapp.model.BalanceType
import com.victor.financekotlinapp.ui.adapter.FinanceAdapter
import com.victor.financekotlinapp.ui.dialog.AlertDialogConfig
import kotlinx.android.synthetic.main.activity_finance_list.*
import java.math.BigDecimal

class FinanceListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finance_list)

        val balances: List<Balance> = listOf(
            Balance(
                message = "Lunchsaldkajdklasjdklsajdlkajdakljdakldjalkdjakldjalkdjaldkaj",
                value = BigDecimal(100.0), type = BalanceType.OUTGOING
            ),
            Balance(message = "Wage", value = BigDecimal(300.0), type = BalanceType.INCOMING)
        )


        /**Pie Chart*/
        //TODO("not implemented") still need to config and refector.
        val entries = mutableListOf<PieEntry>()

        for (balance in balances) {
            entries.add(PieEntry(balance.value.toFloat(), balance.type.name))
        }

        val pieDataSet = PieDataSet(entries, "")
        pieDataSet.colors = ColorTemplate.createColors(ColorTemplate.JOYFUL_COLORS)

        val pieData = PieData(pieDataSet)
        pieData.setValueTextSize(20f)
        pieData.setValueTextColor(Color.WHITE)
        activity_list_piechart.data = pieData
        activity_list_piechart.invalidate()
        activity_list_piechart.setUsePercentValues(true)
        activity_list_piechart.description.isEnabled = false
        activity_list_piechart.setExtraOffsets(10f, 10f, 5f, 10f)
        activity_list_piechart.dragDecelerationFrictionCoef = 0.95f
        activity_list_piechart.isDrawHoleEnabled = true
        activity_list_piechart.setHoleColor(Color.WHITE)
        activity_list_piechart.transparentCircleRadius = 61f



        activity_finance_list.adapter =
            FinanceAdapter(this, balances)


        /**Fab*/
        val viewGroup = window.decorView as ViewGroup

        activity_finance_fab.setOnClickListener {
            AlertDialogConfig(context = this, viewGroup = viewGroup).show()
        }

    }


}


