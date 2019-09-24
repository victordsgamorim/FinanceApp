package com.victor.financekotlinapp.ui.activity

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.victor.financekotlinapp.R
import com.victor.financekotlinapp.extensions.formatDateToDDMMYYYY
import com.victor.financekotlinapp.model.Balance
import com.victor.financekotlinapp.model.BalanceType
import com.victor.financekotlinapp.ui.adapter.FinanceAdapter
import com.victor.financekotlinapp.ui.dialog.AlertDialogConfig
import kotlinx.android.synthetic.main.activity_finance_list.*
import kotlinx.android.synthetic.main.view_form_finance.view.*
import java.math.BigDecimal
import java.util.*

class FinanceListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finance_list)

        val list: List<Balance> = listOf(
            Balance(
                message = "Lunchsaldkajdklasjdklsajdlkajdakljdakldjalkdjakldjalkdjaldkaj",
                value = BigDecimal(100.0), type = BalanceType.OUT
            ),
            Balance(message = "Wage", value = BigDecimal(300.0), type = BalanceType.IN)
        )

        activity_finance_list.adapter =
            FinanceAdapter(this, list)


        val year = 2019
        val month = 8
        val day = 1

        val viewGroup = window.decorView as ViewGroup

        activity_finance_fab.setOnClickListener {
            AlertDialogConfig(context = this, viewGroup = viewGroup).show()
        }

    }


    private fun datePickListener(viewForm: View): DatePickerDialog.OnDateSetListener {
        return DatePickerDialog.OnDateSetListener { view, year, month, day ->
            createDate(year, month, day, viewForm)
        }
    }

    private fun createDate(
        year: Int,
        month: Int,
        day: Int,
        viewForm: View
    ) {
        val selectedDate = Calendar.getInstance()
        selectedDate.set(year, month, day)
        viewForm.form_finance_date.setText(selectedDate.formatDateToDDMMYYYY())
    }


}


