package com.victor.financekotlinapp.ui.frangment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.victor.financekotlinapp.R
import com.victor.financekotlinapp.model.PieChartType
import com.victor.financekotlinapp.ui.adapter.TransactionAdapter
import com.victor.financekotlinapp.ui.dialog.AlertDialogConfig
import com.victor.financekotlinapp.ui.view.PieChartView
import com.victor.financekotlinapp.viewmodel.ChartBalanceFragmentViewModel
import kotlinx.android.synthetic.main.fragment_chart_total_balance.*
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

class ChartBalanceFragment : Fragment() {

    private val chartBalanceViewModel: ChartBalanceFragmentViewModel by viewModel()

    private val activityContext by lazy {
        context?.let { it }
            ?: throw IllegalArgumentException("Context not found!")
    }

    private val adapter: TransactionAdapter by inject()
    private val viewGroup by lazy {
        activity?.let { it.window.decorView as ViewGroup }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        carregaDados()
    }

    private fun carregaDados() {

        val userId = chartBalanceViewModel.id
        chartBalanceViewModel.getList(userId).observe(this, Observer { transactions ->
            transactions?.let { adapter.update(it) }
        })
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
        val userId = chartBalanceViewModel.id
        configAlertDialog(userId)

    }

    private fun configAlertDialog(userId: Long) {
        viewGroup?.let { viewGroup ->
            fragment_total_balance_fab.setOnClickListener {
                val dialog = AlertDialogConfig(
                    context = activityContext,
                    userId = userId,
                    viewGroup = viewGroup
                )

                dialog.onTransactionCreated = {
                    chartBalanceViewModel.add(it)
                }

                dialog.show()

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