package com.example.examplecalculator.plus

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.examplecalculator.R

class PlusFragment : Fragment() {
    private val mPlusViewModel: PlusViewModel by activityViewModels()
    private var number1: Number? = null
    private var number2: Number? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPlusViewModel.calculate(requireActivity())
        mPlusViewModel.valueResult.observe(requireActivity(), Observer {
            Log.d("PlusViewModel", "get value $it")
            val result: TextView? = view?.findViewById(R.id.result_plus)
            result?.text = it.toString()
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_plus, container, false)

        return view
    }


}