package com.victor.financekotlinapp.ui.view

import android.content.Context
import android.graphics.Color
import android.view.ViewGroup
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter
import com.github.mikephil.charting.utils.ColorTemplate
import com.victor.financekotlinapp.R
import com.victor.financekotlinapp.extensions.formatCurrecytToEuro
import com.victor.financekotlinapp.model.PieChartStatistics
import com.victor.financekotlinapp.model.PieChartType
import com.victor.financekotlinapp.model.Transaction
import kotlinx.android.synthetic.main.fragment_chart_total_balance.view.*


class PieChartView(
    private val context: Context,
    transactions: List<Transaction>,
    private val viewGroup: ViewGroup,
    private val pieChartType: PieChartType
) {

    private val dataTransaction = mutableListOf<PieEntry>()
    private val statistics = PieChartStatistics(transactions)
    private val pieChart = viewGroup.fragment_total_balance_list_piechart

    fun show() {

        when (pieChartType) {
            PieChartType.INCOMING_OUTGOING -> showIncomingOutgoingBalance()
            PieChartType.INCOMING_SEPARATED_BY_TYPE -> {
            }
            PieChartType.OUTGOING_SEPARATED_BY_TYPE -> {
            }
        }

        configData(configDataSet())
        currentBalanceBox()

    }

    private fun currentBalanceBox() {
        viewGroup.fragment_total_balance_value.text =
            "Current Balance: ${statistics.totalBalance().formatCurrecytToEuro()}"
    }

    private fun showIncomingOutgoingBalance() {

        val incoming = statistics.sumOfBalanceIncoming().toFloat()
        val outgoing = statistics.sumOfBalanaceOutgoing().toFloat()

        dataTransaction.add(PieEntry(incoming))
        dataTransaction.add(PieEntry(outgoing))

    }

    private fun configDataSet(): PieDataSet {
        //colours
        val arrayOfColours = context.resources.getIntArray(R.array.balance_colours)

        val pieDataSet = PieDataSet(dataTransaction, null)

        with(pieDataSet) {

            //circle config
            sliceSpace = 2f
            selectionShift = 10f
            colors = ColorTemplate.createColors(arrayOfColours)

            valueFormatter = PercentFormatter(pieChart)


            //text colour and size
            valueTextSize = 20f
            valueTextColor = Color.WHITE

        }

        return pieDataSet
    }

    private fun configData(pieDataSet: PieDataSet): PieData {
        val pieData = PieData(pieDataSet)
        addConfigToPieChartView(pieData)
        return pieData
    }

    private fun addConfigToPieChartView(pieData: PieData) {
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


}