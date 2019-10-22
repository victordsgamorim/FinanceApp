package com.victor.financekotlinapp.ui.frangment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.victor.financekotlinapp.R
import com.victor.financekotlinapp.model.PieChartType
import com.victor.financekotlinapp.model.BalanceType
import com.victor.financekotlinapp.ui.view.PieChartView
import com.victor.financekotlinapp.model.Transaction
import com.victor.financekotlinapp.ui.adapter.TransactionAdapter
import com.victor.financekotlinapp.ui.dialog.AlertDialogConfig
import kotlinx.android.synthetic.main.fragment_chart_total_balance.*
import java.math.BigDecimal

class ChartBalanceFragment : Fragment() {

    private val activityContext by lazy {
        context?.let { it }
            ?: throw IllegalArgumentException("Context not found!")
    }

    private val adapter by lazy {
        TransactionAdapter(activityContext)
    }

    private val viewGroup by lazy {
        activity?.let { it.window.decorView as ViewGroup }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        carregaDados()
    }

    /**Example of data*/
    private fun carregaDados() {

        val balances: List<Transaction> = listOf(
            Transaction(
                message = "Lunchsaldkajdklasjdklsajdlkajdakljdakldjalkdjakldjalkdjaldkaj",
                value = BigDecimal(100.0), type = BalanceType.OUTGOING
            ),
            Transaction(message = "Wage", value = BigDecimal(300.0), type = BalanceType.INCOMING),
            Transaction(message = "Car", value = BigDecimal(123.98), type = BalanceType.OUTGOING),
            Transaction(message = "House", value = BigDecimal(709.21), type = BalanceType.OUTGOING)
        )

        adapter.update(balances)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_chart_total_balance, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragment_total_balance_transaction_list.adapter = adapter
        configTotalBalancePieChart()
        openAddTransactionAlertDialog()


    }

    private fun openAddTransactionAlertDialog() {
        viewGroup?.let { viewGroup ->
            fragment_total_balance_fab.setOnClickListener {
                AlertDialogConfig(
                    context = activityContext,
                    viewGroup = viewGroup
                ).show()
            }

        }
    }

    private fun configTotalBalancePieChart() {
        val transactionList = adapter.getTransactions()

        viewGroup?.let {
            PieChartView(
                context = activityContext,
                transactions = transactionList,
                viewGroup = it,
                pieChartType = PieChartType.INCOMING_OUTGOING
            ).show()
        }

    }


}