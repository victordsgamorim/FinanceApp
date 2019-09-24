package com.victor.financekotlinapp.ui.dialog

import android.app.DatePickerDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import com.victor.financekotlinapp.R
import com.victor.financekotlinapp.constants.DAY
import com.victor.financekotlinapp.constants.MONTH
import com.victor.financekotlinapp.constants.TODAY
import com.victor.financekotlinapp.constants.YEAR
import com.victor.financekotlinapp.extensions.formatDateToDDMMYYYY
import kotlinx.android.synthetic.main.view_form_finance.view.*
import java.util.*

class AlertDialogConfig(
    private val viewGroup: ViewGroup,
    private val context: Context
) {
    private val viewForm = inflateFormView()

    fun show() {
        configDate()
        alertDialog()
    }

    private fun alertDialog() {
        AlertDialog.Builder(context)
            .setTitle("Add new finance")
            .setView(viewForm)
            .setPositiveButton("OK", null) //TODO("not implemented") still need to config a listener to ok button
            .setNegativeButton("Cancel", null)
            .show()
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