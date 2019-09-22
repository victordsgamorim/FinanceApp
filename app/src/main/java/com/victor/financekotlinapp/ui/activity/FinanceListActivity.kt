package com.victor.financekotlinapp.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.victor.financekotlinapp.R
import com.victor.financekotlinapp.model.Balance
import com.victor.financekotlinapp.ui.adapter.FinanceAdapter
import kotlinx.android.synthetic.main.activity_finance_list.*
import java.math.BigDecimal
import java.util.*

class FinanceListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finance_list)

        val list: List<Balance> = listOf(
            Balance("Mouse", BigDecimal(100.0), Calendar.getInstance())
        )

        activity_finance_list.adapter =
            FinanceAdapter(this, list)


    }
}
