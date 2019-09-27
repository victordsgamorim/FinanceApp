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

class FinanceAdapter(
    val context: Context,
    val transaction: List<Transaction>
) : RecyclerView.Adapter<FinanceAdapter.FinanceViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FinanceViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.cardview_finance_item, parent, false)
        return FinanceViewHolder(view, context)
    }

    override fun getItemCount(): Int {
        return transaction.size
    }

    override fun onBindViewHolder(holder: FinanceViewHolder, position: Int) {
        val transaction = transaction[position]
        holder.bindInformation(transaction)
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


