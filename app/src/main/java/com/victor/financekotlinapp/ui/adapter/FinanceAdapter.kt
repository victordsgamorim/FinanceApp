package com.victor.financekotlinapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.victor.financekotlinapp.R
import com.victor.financekotlinapp.extensions.*
import com.victor.financekotlinapp.model.Balance
import com.victor.financekotlinapp.model.BalanceType
import kotlinx.android.synthetic.main.cardview_finance_item.view.*

class FinanceAdapter(
    val context: Context,
    val balance: List<Balance>
) : RecyclerView.Adapter<FinanceAdapter.FinanceViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FinanceViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.cardview_finance_item, parent, false)
        return FinanceViewHolder(view, context)
    }

    override fun getItemCount(): Int {
        return balance.size
    }

    override fun onBindViewHolder(holder: FinanceViewHolder, position: Int) {
        val balance = balance[position]
        holder.bindInformation(balance)
    }

    class FinanceViewHolder(itemView: View, private val context: Context) :
        RecyclerView.ViewHolder(itemView) {

        private val MAX_MESSAGE_CHARACTERS = 14

        fun bindInformation(balance: Balance) {

            setMessage(balance)
            setPositiveOrNegativeValue(balance)
            setDate(balance)
            setBalanceConfigThroughType(balance.type)


        }

        private fun setDate(balance: Balance) {
            itemView.cardview_finance_date.text = balance.date.formatDateToDDMMYYYY()
        }

        private fun setMessage(balance: Balance) {
            itemView.cardview_finance_message.text =
                balance.message.trimBigMessage(MAX_MESSAGE_CHARACTERS)
        }

        private fun setBalanceConfigThroughType(type: BalanceType) {
            if (type == BalanceType.IN) {
                setIcon(R.drawable.ic_balance_arrow_up)
                setValueColour(R.color.moneyIn)

            } else {
                setIcon(R.drawable.ic_balance_arrow_down)
                setValueColour(R.color.moneyOut)
            }
        }

        private fun setPositiveOrNegativeValue(balance: Balance) {
            if (balance.type == BalanceType.IN) {
                itemView.cardview_finance_value.text =
                    balance.value.formatCurrecytToEuro().formatValueToPositive()
            } else {
                itemView.cardview_finance_value.text =
                    balance.value.formatCurrecytToEuro().formatValueToNegative()
            }
        }

        private fun setIcon(icon: Int) {
            itemView.cardview_finance_image.setBackgroundResource(icon)
        }

        private fun setValueColour(colour: Int) {
            itemView.cardview_finance_value.setTextColor(
                ContextCompat.getColor(
                    context,
                    colour
                )
            )
        }


    }


}


