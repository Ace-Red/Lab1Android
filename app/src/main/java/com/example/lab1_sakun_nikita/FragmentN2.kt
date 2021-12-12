package com.example.lab1_sakun_nikita

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView


class FragmentN2 : Fragment() {
    private lateinit var btnClear: Button
    private lateinit var textView3: TextView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view:View = inflater.inflate(R.layout.fragment_n2,container,false)
        btnClear = view.findViewById(R.id.btnClear)
        textView3 = view.findViewById(R.id.textView3)

        textView3.text = " "
        btnClear.setOnClickListener {

            (activity as MainActivity).clearRgMain()
            textView3.text = " "
        }
        return view
    }
    fun writeResToTextView(textRes: String){
        textView3.text = textRes
    }

}