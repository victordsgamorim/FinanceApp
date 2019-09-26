package com.victor.financekotlinapp.ui

import android.content.Context
import android.graphics.Color
import android.view.View
import androidx.core.content.ContextCompat
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate
import com.victor.financekotlinapp.R
import com.victor.financekotlinapp.extensions.formatCurrecytToEuro
import com.victor.financekotlinapp.model.Balance
import kotlinx.android.synthetic.main.activity_list_balance.view.*
import java.math.BigDecimal

class PieChartView(
    private val transaction: List<Balance>,
    private val view: View,
    private val context: Context
) {

    private val entries = mutableListOf<PieEntry>()
    private val statistics = PieChartStatistics(transaction)

    fun show() {
        //TODO("not implemented") still need to config

        addEntries()
        val pieDataSet = configDataSet()
        val pieData = configData(pieDataSet)
        configDataView(pieData)
        configTotalBalance()
    }

    //TODO("not implemented") new ways of refactor related to get/set colours (from the adapter to total balance)
    private fun configTotalBalance() {
        val totalBalance =
            statistics.totalBalance()

        val colour = getColour(totalBalance)

        with(view.activity_total_balance) {
            text = "Balance: ${totalBalance.formatCurrecytToEuro()}"
            setTextColor(colour)
        }
    }

    private fun getColour(totalBalance: BigDecimal): Int {
        if (totalBalance.toDouble() >= 0) {
            return ContextCompat.getColor(context, R.color.moneyIn)
        }
        return ContextCompat.getColor(context, R.color.moneyOut)

    }

    private fun configDataView(pieData: PieData) {
        view.activity_list_piechart.data = pieData
        view.activity_list_piechart.description.isEnabled = false
        view.activity_list_piechart.dragDecelerationFrictionCoef = 0.95f
        view.activity_list_piechart.isDrawHoleEnabled = true
        view.activity_list_piechart.transparentCircleRadius = 61f
        view.activity_list_piechart.legend.isEnabled = false
        view.activity_list_piechart.setUsePercentValues(true)
        view.activity_list_piechart.setExtraOffsets(10f, 10f, 5f, 10f)
        view.activity_list_piechart.setHoleColor(Color.TRANSPARENT)
        view.activity_list_piechart.invalidate()
    }

    private fun configData(pieDataSet: PieDataSet): PieData {
        val pieData = PieData(pieDataSet)
        pieData.setValueTextSize(20f)
        pieData.setValueTextColor(Color.WHITE)
        return pieData
    }

    private fun configDataSet(): PieDataSet {
        val pieDataSet = PieDataSet(entries, "")

        val balanceColours = context.resources.getIntArray(R.array.balance_colours)


        pieDataSet.colors = ColorTemplate.createColors(balanceColours)
        return pieDataSet
    }

    private fun addEntries() {
        val incoming = statistics.sumOfBalanceIncoming().toFloat()
        val outgoing = statistics.sumOfBalanaceOutgoing().toFloat()

        entries.add(PieEntry(incoming))
        entries.add(PieEntry(outgoing))
    }
}