package com.victor.financekotlinapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.victor.financekotlinapp.R
import com.victor.financekotlinapp.extensions.formatCurrecyToCanada
import com.victor.financekotlinapp.extensions.formatToNormalData
import com.victor.financekotlinapp.model.Balance
import kotlinx.android.synthetic.main.cardview_finance_item.view.*

class FinanceAdapter(
    val context: Context,
    val balance: List<Balance>
) : RecyclerView.Adapter<FinanceAdapter.FinanceViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FinanceViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.cardview_finance_item, parent, false)
        return FinanceViewHolder(view)
    }

    override fun getItemCount(): Int {
        return balance.size
    }

    override fun onBindViewHolder(holder: FinanceViewHolder, position: Int) {
        val balance = balance[position]
        holder.bindInformation(balance)
    }

    class FinanceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindInformation(balance: Balance) {
            itemView.cardview_finance_message.text = balance.message
            itemView.cardview_finance_value.text = balance.value.formatCurrecyToCanada()
            itemView.cardview_finance_date.text = balance.date.formatToNormalData()
        }


    }


}
