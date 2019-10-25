package com.victor.financekotlinapp.ui.frangment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.victor.financekotlinapp.R
import com.victor.financekotlinapp.viewmodel.ChartIncomingFragmentViewModel
import kotlinx.android.synthetic.main.fragment_chart_incoming.*
import org.koin.android.viewmodel.ext.android.viewModel

class ChartIncomingFragment : Fragment() {

    private val viewModel: ChartIncomingFragmentViewModel by viewModel()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_chart_incoming, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val id = viewModel.getId()
        viewModel.getUserById(id).observe(this, Observer {
            it?.let { fragment_incoming_text.text = it.userName }
        })


    }


}