package com.example.lab1_sakun_nikita

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*


class FragmentN1 : Fragment() {
    private lateinit var btnEnter: Button
    private lateinit var rgCompany: RadioGroup
    private lateinit var rgType: RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?{

        val view:View = inflater.inflate(R.layout.fragment_n1,container,false)
        btnEnter = view.findViewById(R.id.btnEnter)
        rgCompany = view.findViewById(R.id.rgCompany)
        rgType = view.findViewById(R.id.rgType)
        btnEnter.setOnClickListener {

            val rb_company_id = rgCompany.checkedRadioButtonId
            val rb_type_id = rgType.checkedRadioButtonId


            if (rb_company_id == -1 || rb_type_id == -1) {
                Toast.makeText(activity?.applicationContext, "Please choose a company and type", Toast.LENGTH_LONG).show()
            } else {
                val rb_company = rgCompany.findViewById<RadioButton>(rb_company_id)
                val rb_type = rgType.findViewById<RadioButton>(rb_type_id)
                (activity as MainActivity).transportTextResFromF2(rb_company.text.toString() + " " + rb_type.text.toString())
            }
        }
        val pre_checked_company = rgCompany.getChildAt(1) as RadioButton
        pre_checked_company.setChecked(true)

        val pre_checked_type = rgType.getChildAt(1) as RadioButton
        pre_checked_type.setChecked(true)
        return view
    }


    fun clearRg() {
        rgCompany.clearCheck()
        rgType.clearCheck()
    }


}