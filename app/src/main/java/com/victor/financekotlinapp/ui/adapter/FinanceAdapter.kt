package com.victor.financekotlinapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.victor.financekotlinapp.R
import com.victor.financekotlinapp.extensions.formatCurrecyToCanada
import com.victor.financekotlinapp.extensions.formatToNormalData
import com.victor.financekotlinapp.model.Transaction
import kotlinx.android.synthetic.main.cardview_finance_item.view.*

class FinanceAdapter(
    val context: Context,
    val transaction: List<Transaction>
) : RecyclerView.Adapter<FinanceAdapter.FinanceViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FinanceViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.cardview_finance_item, parent, false)
        return FinanceViewHolder(view)
    }

    override fun getItemCount(): Int {
        return transaction.size
    }

    override fun onBindViewHolder(holder: FinanceViewHolder, position: Int) {
        val transaction = transaction[position]
        holder.bindInformation(transaction)
    }

    class FinanceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindInformation(transaction: Transaction) {
            itemView.cardview_finance_message.text = transaction.message
            itemView.cardview_finance_value.text = transaction.value.formatCurrecyToCanada()
            itemView.cardview_finance_date.text = transaction.date.formatToNormalData()
        }


    }


}
