package com.example.lab1_sakun_nikita

import android.content.Context.MODE_APPEND
import android.content.Intent

import android.os.Bundle

import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import android.widget.Toast


import java.io.FileOutputStream
import java.io.IOException


class FragmentN1 : Fragment() {
    private val FILE_NAME = "content.txt"
    private lateinit var btnEnter: Button
    private lateinit var btnOpen: Button
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
    ): View {
        val useIntent = Intent(activity?.applicationContext, SecondActivity::class.java)
        val view: View = inflater.inflate(R.layout.fragment_n1, container, false)
        btnEnter = view.findViewById(R.id.btnEnter)
        rgCompany = view.findViewById(R.id.rgCompany)
        rgType = view.findViewById(R.id.rgType)
        btnOpen = view.findViewById(R.id.openButton)
        btnEnter.setOnClickListener {

            val rb_company_id = rgCompany.checkedRadioButtonId
            val rb_type_id = rgType.checkedRadioButtonId


            if (rb_company_id == -1 || rb_type_id == -1) {
                Toast.makeText(
                    activity?.applicationContext,
                    "Please choose a company and type",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                val rb_company = rgCompany.findViewById<RadioButton>(rb_company_id)
                val rb_type = rgType.findViewById<RadioButton>(rb_type_id)
                (activity as MainActivity).transportTextResFromF2(rb_company.text.toString() + " " + rb_type.text.toString())
            }
            val rb_company = rgCompany.findViewById<RadioButton>(rb_company_id)
            val rb_type = rgType.findViewById<RadioButton>(rb_type_id)
            var fos: FileOutputStream? = null
            try {

                fos = context?.openFileOutput(FILE_NAME, MODE_APPEND)
                fos?.write((rb_company.text.toString() + " " + rb_type.text.toString() + "\n").toByteArray())
                Toast.makeText(activity?.applicationContext, "Файл сохранен", Toast.LENGTH_LONG)
                    .show()
            } catch (ex: IOException) {
                Toast.makeText(activity?.applicationContext, "ERROR", Toast.LENGTH_LONG).show()
            } finally {
                try {
                    fos?.close()
                } catch (ex: IOException) {
                    Toast.makeText(activity?.applicationContext, "ERROR", Toast.LENGTH_LONG).show()
                }
            }

        }
        btnOpen.setOnClickListener {
            startActivity(useIntent)
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