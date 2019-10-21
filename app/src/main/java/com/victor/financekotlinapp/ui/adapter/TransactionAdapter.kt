package com.victor.financekotlinapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.victor.financekotlinapp.R
import com.victor.financekotlinapp.model.Transaction
import com.victor.financekotlinapp.ui.adapter.config.BalanceDesignConfig
import kotlinx.android.synthetic.main.cardview_finance_item.view.*

class TransactionAdapter(
    private val context: Context,
    private val transactions: MutableList<Transaction> = mutableListOf()
) : RecyclerView.Adapter<TransactionAdapter.FinanceViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FinanceViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.cardview_finance_item, parent, false)
        return FinanceViewHolder(view, context)
    }

    override fun getItemCount(): Int {
        return transactions.size
    }

    override fun onBindViewHolder(holder: FinanceViewHolder, position: Int) {
        val transaction = transactions[position]
        holder.bindInformation(transaction)
    }

    fun update(transaction: List<Transaction>) {
        notifyItemRangeRemoved(0, this.transactions.size)
        transactions.clear()
        transactions.addAll(transaction)
        notifyItemRangeInserted(0, this.transactions.size)
    }

    fun getTransactions(): List<Transaction> {
        return transactions
    }

    class FinanceViewHolder(itemView: View, private val context: Context) :
        RecyclerView.ViewHolder(itemView) {


        fun bindInformation(balance: Transaction) {
            val balanceDesignConfig =
                BalanceDesignConfig(balance, context)

            setMessage(balanceDesignConfig)
            setDate(balanceDesignConfig)
            setValueSign(balanceDesignConfig)
            setIcon(balanceDesignConfig)
        }

        private fun setMessage(balance: BalanceDesignConfig) {
            itemView.cardview_finance_message.text = balance.message

        }

        private fun setDate(balance: BalanceDesignConfig) {
            itemView.cardview_finance_date.text = balance.date
        }


        private fun setIcon(balance: BalanceDesignConfig) {
            itemView.cardview_finance_image.setBackgroundResource(balance.getIcon())
        }


        private fun setValueSign(balance: BalanceDesignConfig) {
            with(itemView.cardview_finance_value) {
                text = balance.getValueSign()
                setTextColor(balance.getValueColour())
            }
        }


    }


}


