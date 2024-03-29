package com.victor.financekotlinapp.ui.dialog

import android.app.DatePickerDialog
import android.content.Context
import android.content.DialogInterface
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.victor.financekotlinapp.R
import com.victor.financekotlinapp.constants.DAY
import com.victor.financekotlinapp.constants.MONTH
import com.victor.financekotlinapp.constants.TODAY
import com.victor.financekotlinapp.constants.YEAR
import com.victor.financekotlinapp.extensions.formatCurrecytToEuro
import com.victor.financekotlinapp.extensions.formatDateToDDMMYYYY
import com.victor.financekotlinapp.extensions.getEditTextString
import com.victor.financekotlinapp.model.BalanceType
import com.victor.financekotlinapp.model.Transaction
import com.victor.financekotlinapp.model.User
import com.victor.financekotlinapp.viewmodel.ChartBalanceFragmentViewModel
import kotlinx.android.synthetic.main.fragment_chart_incoming.view.*
import kotlinx.android.synthetic.main.view_form_finance.view.*
import java.lang.IllegalArgumentException
import java.math.BigDecimal
import java.util.*

class AlertDialogConfig(
    private val context: Context,
    private val userId: Long,
    private val viewGroup: ViewGroup
) {
    private val viewForm = inflateFormView()
    var onTransactionCreated: (transaction: Transaction) -> Unit = {}

    fun show() {
        configDate()
        configDropdownBox()
        alertDialog()
    }

    private fun configDropdownBox() {
        val adapter = ArrayAdapter.createFromResource(
            context,
            R.array.balance_type,
            android.R.layout.simple_spinner_dropdown_item
        )

        viewForm.form_finance_dropdown.adapter = adapter
    }

    private fun alertDialog() {
        AlertDialog.Builder(context)
            .setTitle("Add new finance")
            .setView(viewForm)
            .setPositiveButton("OK") { dialogInterface, i ->

                val message = getEditTextString(viewForm.form_finance_message)
                val value = getEditTextString(viewForm.form_finance_value)
                val date = viewForm.form_finance_date.text.toString()
                val categoryItemSelected = getCategory()

                val transaction = Transaction(
                    message = message,
                    value = BigDecimal(value),
                    userId = userId,
                    type = categoryItemSelected
                )

                onTransactionCreated(transaction)


            }
            .setNegativeButton("Cancel", null)
            .show()
    }

    private fun getCategory(): BalanceType {

        return when (viewForm.form_finance_dropdown.selectedItem.toString()) {
            "Incoming" -> BalanceType.INCOMING
            "Outgoing" -> BalanceType.OUTGOING
            else -> throw IllegalArgumentException("There is no item selected.")
        }

    }

    private fun inflateFormView(): View {
        return LayoutInflater.from(context)
            .inflate(R.layout.view_form_finance, viewGroup, false)

    }

    private fun configDate() {
        viewForm.form_finance_date.setText(TODAY.formatDateToDDMMYYYY())

        viewForm.form_finance_date.setOnClickListener {
            DatePickerDialog(
                context,
                configDatePickerListener(),
                YEAR, MONTH, DAY
            ).show()
        }
    }

    private fun configDatePickerListener(): DatePickerDialog.OnDateSetListener {
        return DatePickerDialog.OnDateSetListener { view, year, month, day ->
            val selectedDate = Calendar.getInstance()
            selectedDate.set(year, month, day)
            viewForm.form_finance_date.setText(selectedDate.formatDateToDDMMYYYY())
        }
    }

}