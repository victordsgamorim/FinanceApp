package com.victor.financekotlinapp.model

import android.content.Context
import android.graphics.Color
import android.view.View
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter
import com.github.mikephil.charting.utils.ColorTemplate
import com.victor.financekotlinapp.R
import kotlinx.android.synthetic.main.fragment_chart_ougoing.view.*

class PieChartView(
    transaction: List<Transaction>,
    private val view: View,
    private val context: Context
) {

    private val entries = mutableListOf<PieEntry>()
    private val statistics = PieChartStatistics(transaction)
    private val pieChart = view.activity_list_piechart
    private val formatter = PercentFormatter(pieChart)

    fun show() {
        //TODO("not implemented") still need to config


        addEntries()
        val pieDataSet = configDataSet()
        val pieData = configData(pieDataSet)
        configDataView(pieData)
        configTotalBalance()
    }

    private fun configTotalBalance() {
        val totalBalance =
            statistics.totalBalance()

        //view.activity_total_balance.text = "Balance: ${totalBalance.formatCurrecytToEuro()}"
    }

    private fun configDataView(pieData: PieData) {
        with(pieChart) {
            data = pieData

            //refresh
            invalidate()

            //config hole
            isDrawHoleEnabled = true
            holeRadius = 50f

            //rotation
            isRotationEnabled = true
            setUsePercentValues(true)

            //config desc and legend
            description.isEnabled = false
            legend.isEnabled = false

        }


    }

    private fun configData(pieDataSet: PieDataSet): PieData {
        val pieData = PieData(pieDataSet)
        return pieData
    }

    private fun configDataSet(): PieDataSet {
        //colours
        val arrayOfColours = context.resources.getIntArray(R.array.balance_colours)

        val pieDataSet = PieDataSet(entries, "")
        with(pieDataSet) {

            //circle config
            sliceSpace = 2f
            selectionShift = 10f
            colors = ColorTemplate.createColors(arrayOfColours)

            //text percent
            valueFormatter = formatter

            //text colour and size
            valueTextSize = 20f
            valueTextColor = Color.WHITE


        }

        return pieDataSet
    }

    private fun addEntries() {
        val incoming = statistics.sumOfBalanceIncoming().toFloat()
        val outgoing = statistics.sumOfBalanaceOutgoing().toFloat()

        entries.add(PieEntry(incoming))
        entries.add(PieEntry(outgoing))
    }
}