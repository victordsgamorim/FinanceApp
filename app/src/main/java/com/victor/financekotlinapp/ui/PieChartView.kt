package com.victor.financekotlinapp.ui

import android.graphics.Color
import android.view.View
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate
import com.victor.financekotlinapp.model.Balance
import kotlinx.android.synthetic.main.activity_list_balance.view.*

class PieChartView(private val transaction: List<Balance>, private val view: View) {

    private val entries = mutableListOf<PieEntry>()
    private val statistics = PieChartStatistics(transaction)

    fun show() {
        //TODO("not implemented") still need to config

        addEntries()
        val pieDataSet = configDataSet()
        val pieData = configData(pieDataSet)
        configDataView(pieData)
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
        pieDataSet.colors = ColorTemplate.createColors(ColorTemplate.JOYFUL_COLORS)
        return pieDataSet
    }

    private fun addEntries() {
        val incoming = statistics.sumOfBalanceIncoming().toFloat()
        val outgoing = statistics.sumOfBalanaceOutgoing().toFloat()

        entries.add(PieEntry(incoming))
        entries.add(PieEntry(outgoing))
    }
}